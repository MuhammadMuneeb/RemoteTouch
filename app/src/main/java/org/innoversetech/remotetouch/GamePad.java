package org.innoversetech.remotetouch;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class GamePad extends AppCompatActivity implements View.OnClickListener {
    Context context;
    //For Layout stuff
    Button upButton;
    Button downButton;
    Button leftButton;
    Button rightButton;
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Constants constants = new Constants();
    //For connection stuff
    private boolean isConnected=false;
    private Socket socket;
    private PrintWriter out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_pad);
        context = this;
        upButton = (Button)findViewById(R.id.up);
        downButton = (Button)findViewById(R.id.Down);
        leftButton= (Button)findViewById(R.id.left);
        rightButton = (Button)findViewById(R.id.right);
        mButton1 = (Button)findViewById(R.id.but1);
        mButton2 = (Button)findViewById(R.id.but2);
        mButton3 = (Button)findViewById(R.id.but3);
        mButton4 = (Button)findViewById(R.id.but4);
        //Set listeners
        upButton.setOnClickListener(this);
        downButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.up:
                if(isConnected && out != null){
                    out.println(Constants.key_w);
                }
                break;
            case R.id.Down:
                if(isConnected && out != null){
                    out.println(Constants.key_s);
                }
                break;
            case R.id.left:
                if(isConnected && out != null){
                    out.println(Constants.key_a);
                }
                break;
            case R.id.right:
                if(isConnected && out != null){
                    out.println(Constants.key_d);
                }
                break;
            case R.id.but1:
                if(isConnected && out != null){
                    out.println(Constants.key_u);
                }
                break;
            case R.id.but2:
                if(isConnected && out != null){
                    out.println(Constants.key_b);
                }
                break;
            case R.id.but3:
                if(isConnected && out != null){
                    out.println(Constants.key_o);
                }
                break;
            case R.id.but4:
                if(isConnected && out != null){
                    out.println(Constants.key_p);
                }
                break;
            case R.id.select:
                if(isConnected && out != null){
                    out.println(Constants.key_back);
                }
                break;
            case R.id.start:
                if(isConnected && out != null){
                    out.println(Constants.key_enter);
                }
                break;
            case R.id.button4:
                if(isConnected && out != null){
                    out.println(Constants.key_q);
                }
                break;
            case R.id.button5:
                if(isConnected && out != null){
                    out.println(Constants.key_e);
                }
                break;
            case R.id.button6:
                if(isConnected && out != null){
                    out.println(Constants.key_r);
                }
                break;
            case R.id.button7:
                if(isConnected && out != null){
                    out.println(Constants.key_m);
                }
                break;



        }

    }

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
            ConnectPhone connectPhone = new ConnectPhone();
            connectPhone.execute(constants.getIp());//Connect with server
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if(constants.isConnected() && out!=null){
            out.println("went_back");
        }
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
                    out.println("gamepad");
                }
            }catch(IOException e){
                Log.e("AppIssues", "Unable to create outwriter", e);
                Toast.makeText(context, "Error while connecting", Toast.LENGTH_LONG).show();
            }
        }

    }



}

