package org.androidpccontroller.remotetouch;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andretietz.android.controller.ActionView;
import com.andretietz.android.controller.DirectionView;
import com.andretietz.android.controller.InputView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class GamePad extends AppCompatActivity implements View.OnClickListener, InputView.InputEventListener {
    Context context;
    //For Layout stuff
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mSelect;
    Button mStart;
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
        mButton1 = (Button)findViewById(R.id.but1);
        mButton2 = (Button)findViewById(R.id.but2);
        mButton3 = (Button)findViewById(R.id.but3);
        mButton4 = (Button)findViewById(R.id.but4);
        mSelect= (Button)findViewById(R.id.select);
        mStart = (Button)findViewById(R.id.start);
        //Set listeners

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mSelect.setOnClickListener(this);
        mStart.setOnClickListener(this);

        final ActionView actionView = (ActionView) findViewById(R.id.viewAction);
        actionView.setOnButtonListener(new InputView.InputEventListener(){

            @Override
            public void onInputEvent(View view, int buttons) {
                int i = 0;
                if (isConnected && out != null) {// if the bit on position i is set
                    if (((0x01 << 1) & buttons) > 0) {
                        out.println(Constants.key_i);
                        System.out.println(Constants.key_x);
                    } else if (((0x01 << 2) & buttons) > 1) {
                        out.println(Constants.key_o);
                        System.out.println(Constants.key_y);
                    } else if (((0x01 << 3) & buttons) > 2) {
                        out.println(Constants.key_k);
                        System.out.println(Constants.key_z);
                    } else if (((0x01 << 0) & buttons) ==0) {
                        out.println(Constants.key_l);
                        System.out.println(Constants.key_v);
                    }
                }
            }
        });
        DirectionView directionView = (DirectionView) findViewById(R.id.viewDirection);
        directionView.setOnButtonListener(this);
        ConnectPhone connectPhone = new ConnectPhone();
        connectPhone.execute(constants.getIp());//Connect with server

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
                    System.out.println(Constants.key_back);

                }
                break;
            case R.id.start:
                if(isConnected && out != null){
                    out.println(Constants.key_enter);
                    System.out.println(Constants.key_enter);
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
        Intent intent = new Intent(GamePad.this, MainActivity.class);
        startActivity(intent);
        try {
            if (isConnected && out != null) {
                out.println("went_back");
                socket.close();
                startActivity(intent);
                finish();
            }
        } catch (NullPointerException n) {
            System.out.println("I am null in gamepad");
        } catch (IOException i) {
            System.out.println("Null in gamepad");
        }
    }

    @Override
    public void onInputEvent(View view, int buttons) {
        switch (buttons & 0xff) {
            case DirectionView.DIRECTION_DOWN:
                if(isConnected && out != null){
                    out.println(Constants.key_s);
                }
                break;
            case DirectionView.DIRECTION_LEFT:
                if(isConnected && out != null){
                    out.println(Constants.key_a);
                }
                break;
            case DirectionView.DIRECTION_RIGHT:
                if(isConnected && out != null){
                    out.println(Constants.key_d);
                }
                break;
            case DirectionView.DIRECTION_UP:
                if(isConnected && out != null){
                    out.println(Constants.key_w);
                }
                break;

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
                }
            }catch(IOException e){
                Log.e("AppIssues", "Unable to create outwriter", e);
                Toast.makeText(context, "Error while connecting", Toast.LENGTH_LONG).show();
            }
        }

    }



}

