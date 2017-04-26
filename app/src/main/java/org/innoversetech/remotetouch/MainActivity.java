package org.innoversetech.remotetouch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mouse;
    private ImageButton qrCode;
    private ImageButton keyboard;
    private ImageButton mGamepad;
    private boolean isConnected=false;
    private Button mIpButton;
    private Socket socket;
    private PrintWriter out;
    Context context;
    Constants constants = new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        mouse = (ImageButton)findViewById(R.id.Mouse);
        qrCode = (ImageButton)findViewById(R.id.qrCode);
        keyboard = (ImageButton)findViewById(R.id.keyBoard);
        mGamepad = (ImageButton)findViewById(R.id.gamePad);
        mIpButton = (Button)findViewById(R.id.ipAdd);
        mouse.setOnClickListener(this);
        qrCode.setOnClickListener(this);
        keyboard.setOnClickListener(this);
        mGamepad.setOnClickListener(this);
        mIpButton.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //to inflate the menu, and adds it to the actionbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id== R.id.action_connect){
            MainActivity.ConnectPhone connectPhone = new MainActivity.ConnectPhone();
            connectPhone.execute(constants.getIp());//Connect with server
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Mouse:
                Intent intent = new Intent(MainActivity.this, Mouse.class);
                startActivity(intent);
                break;
            case R.id.qrCode:
                Intent in2 = new Intent(MainActivity.this, qrScanner.class);
                startActivity(in2);
                break;
            case R.id.keyBoard:
                Intent in3 = new Intent(MainActivity.this, Keyboard.class);
                startActivity(in3);
                break;
            case R.id.gamePad:
                Intent in4 = new Intent(MainActivity.this, GamePad.class);
                startActivity(in4);
                break;
            case R.id.ipAdd:
                setIp();
        }
    }

    private void setIp() {
        final String[] ip = new String[1];
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_ip, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        alertDialog.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    ip[0] = editText.getText().toString();
                        constants.setIp(ip[0]);
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

    public class ConnectPhone extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = true;
            try{
                InetAddress serverAdrs = InetAddress.getByName(params[0]);
                socket = new Socket(serverAdrs, Constants.SERVER_PORT);
            }catch(IOException e){
                Log.e("Connection", "Error while connecting", e);
                result = false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result){
            isConnected = result;
            Toast.makeText(context, isConnected?"Connected" : "Unable to connect", Toast.LENGTH_SHORT).show();
            try{
                if(isConnected){
                    //Stream to send data to server
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                }
            }catch(IOException e){
                Log.e("AppIssues", "Unable to create outwriter", e);
                Toast.makeText(context, "Error while connecting", Toast.LENGTH_LONG).show();
            }
        }

    }

}
