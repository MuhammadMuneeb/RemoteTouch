package org.innoversetech.remotetouch;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
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



//TODO Add more comments
//TODO Add server functionality

public class Keyboard extends ActionBarActivity{
    Context context;
    //For Layout stuff
    TextView scrollView;
    //For connection stuff
    private boolean isConnected=false;
    private boolean mouseMoved=false;
    private Socket socket;
    private PrintWriter out;
    //Cursor movement

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        context = this;
        //Init the layout

    }

    public boolean onKeyUp(int keyCode, KeyEvent event){
        switch(keyCode){
            case KeyEvent.KEYCODE_Q:
                if (isConnected && out!=null) {
                    out.println(Constants.key_q);
                }
                return true;
            case KeyEvent.KEYCODE_W:
                if (isConnected && out!=null) {
                    out.println(Constants.key_w);
                }
                return true;
            case KeyEvent.KEYCODE_E:
                if (isConnected && out!=null) {
                    out.println(Constants.key_e);
                }
                return true;
            case KeyEvent.KEYCODE_R:
                if (isConnected && out!=null) {
                    out.println(Constants.key_r);
                }
                return true;
            case KeyEvent.KEYCODE_Y:
                if (isConnected && out!=null) {
                    out.println(Constants.key_y);
                }
                return true;
            case KeyEvent.KEYCODE_U:
                if (isConnected && out!=null) {
                    out.println(Constants.key_u);
                }
                return true;

            case KeyEvent.KEYCODE_I:
                if (isConnected && out!=null) {
                    out.println(Constants.key_i);
                }
                return true;

            case KeyEvent.KEYCODE_O:
                if (isConnected && out!=null) {
                    out.println(Constants.key_o);
                }
                return true;

            case KeyEvent.KEYCODE_P:
                if (isConnected && out!=null) {
                    out.println(Constants.key_p);
                }
                return true;

            case KeyEvent.KEYCODE_A:
                if (isConnected && out!=null) {
                    out.println(Constants.key_a);
                }
                return true;

            case KeyEvent.KEYCODE_S:
                if (isConnected && out!=null) {
                    out.println(Constants.key_s);
                }
                return true;

            case KeyEvent.KEYCODE_D:
                if (isConnected && out!=null) {
                    out.println(Constants.key_d);
                }
                return true;

            case KeyEvent.KEYCODE_F:
                if (isConnected && out!=null) {
                    out.println(Constants.key_f);
                }
                return true;

            case KeyEvent.KEYCODE_G:
                if (isConnected && out!=null) {
                    out.println(Constants.key_g);
                }
                return true;

            case KeyEvent.KEYCODE_H:
                if (isConnected && out!=null) {
                    out.println(Constants.key_h);
                }
                return true;

            case KeyEvent.KEYCODE_J:
                if (isConnected && out!=null) {
                    out.println(Constants.key_j);
                }
                return true;

            case KeyEvent.KEYCODE_K:
                if (isConnected && out!=null) {
                    out.println(Constants.key_k);
                }
                return true;

            case KeyEvent.KEYCODE_L:
                if (isConnected && out!=null) {
                    out.println(Constants.key_l);
                }
                return true;

            case KeyEvent.KEYCODE_Z:
                if (isConnected && out!=null) {
                    out.println(Constants.key_z);
                }
                return true;

            case KeyEvent.KEYCODE_X:
                if (isConnected && out!=null) {
                    out.println(Constants.key_x);
                }
                return true;

            case KeyEvent.KEYCODE_C:
                if (isConnected && out!=null) {
                    out.println(Constants.key_c);
                }
                return true;

            case KeyEvent.KEYCODE_V:
                if (isConnected && out!=null) {
                    out.println(Constants.key_v);
                }
                return true;

            case KeyEvent.KEYCODE_B:
                if (isConnected && out!=null) {
                    out.println(Constants.key_b);
                }
                return true;

            case KeyEvent.KEYCODE_N:
                if (isConnected && out!=null) {
                    out.println(Constants.key_n);
                }
                return true;

            case KeyEvent.KEYCODE_M:
                if (isConnected && out!=null) {
                    out.println(Constants.key_m);
                }
                return true;

            default:
                return super.onKeyUp(keyCode, event);
        }


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
            ConnectPhone connectPhone = new ConnectPhone();
            connectPhone.execute(Constants.SERVER_IP);//Connect with server
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onDestroy(){
        super.onDestroy();
        if(isConnected && out!=null){
            try{
                out.println("exit");//Exit the server
                socket.close();//close the socket
            }catch(IOException e){
                Log.e("APP", "Error in closing the socket", e);
            }
        }

    }

    public class ConnectPhone extends AsyncTask<String, Void, Boolean>{

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
