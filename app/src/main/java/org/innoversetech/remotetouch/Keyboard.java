package org.innoversetech.remotetouch;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.os.AsyncTask;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.QwertyKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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

public class Keyboard extends ActionBarActivity implements View.OnClickListener {
    Context context;
    //For Layout stuff
    Button keyOpener;
    //For connection stuff
    private boolean isConnected=false;
    private Socket socket;
    private PrintWriter out;
    //Cursor movement

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        context = this;
        //Init the layout
        keyOpener = (Button)findViewById(R.id.keyb);
        keyOpener.setOnClickListener(this);
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){
        if (isConnected && out!=null) {
           switch (keyCode) {
                case KeyEvent.KEYCODE_Q:
                    if(event.isShiftPressed()){
                        out.println(Constants.key_Q);
                        System.out.println("Q HERE");
                    }
                    else{
                        out.println(Constants.key_q);
                        System.out.println("q here");
                    }
                    return true;
               case KeyEvent.KEYCODE_W:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_W);
                       System.out.println("W HERE");
                   }
                   else{
                       out.println(Constants.key_w);
                       System.out.println("w here");
                   }
                   return true;
               case KeyEvent.KEYCODE_E:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_E);
                       System.out.println("E HERE");
                   }
                   else{
                       out.println(Constants.key_e);
                       System.out.println("e here");
                   }
                   return true;
               case KeyEvent.KEYCODE_R:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_R);
                       System.out.println("R HERE");
                   }
                   else{
                       out.println(Constants.key_r);
                       System.out.println("r here");
                   }
                   return true;
               case KeyEvent.KEYCODE_T:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_T);
                       System.out.println("T HERE");
                   }
                   else{
                       out.println(Constants.key_t);
                       System.out.println("t here");
                   }
                   return true;
               case KeyEvent.KEYCODE_Y:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_Y);
                       System.out.println("Y HERE");
                   }
                   else{
                       out.println(Constants.key_y);
                       System.out.println("y here");
                   }
                   return true;
               case KeyEvent.KEYCODE_U:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_U);
                       System.out.println("U HERE");
                   }
                   else{
                       out.println(Constants.key_u);
                       System.out.println("u here");
                   }
                   return true;
               case KeyEvent.KEYCODE_I:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_I);
                       System.out.println("I HERE");
                   }
                   else{
                       out.println(Constants.key_i);
                       System.out.println("i here");
                   }
                   return true;
               case KeyEvent.KEYCODE_O:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_O);
                       System.out.println("O HERE");
                   }
                   else{
                       out.println(Constants.key_o);
                       System.out.println("o here");
                   }
                   return true;
               case KeyEvent.KEYCODE_P:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_P);
                       System.out.println("P HERE");
                   }
                   else{
                       out.println(Constants.key_p);
                       System.out.println("p here");
                   }
                   return true;
               case KeyEvent.KEYCODE_A:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_A);
                       System.out.println("A HERE");
                   }
                   else{
                       out.println(Constants.key_a);
                       System.out.println("a here");
                   }
                   return true;
               case KeyEvent.KEYCODE_S:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_S);
                       System.out.println("S HERE");
                   }
                   else{
                       out.println(Constants.key_s);
                       System.out.println("s here");
                   }
                   return true;
               case KeyEvent.KEYCODE_D:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_D);
                       System.out.println("D HERE");
                   }
                   else{
                       out.println(Constants.key_d);
                       System.out.println("d here");
                   }
                   return true;
               case KeyEvent.KEYCODE_F:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_F);
                       System.out.println("F HERE");
                   }
                   else{
                       out.println(Constants.key_f);
                       System.out.println("f here");
                   }
                   return true;
               case KeyEvent.KEYCODE_G:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_G);
                       System.out.println("G HERE");
                   }
                   else{
                       out.println(Constants.key_g);
                       System.out.println("g here");
                   }
                   return true;
               case KeyEvent.KEYCODE_H:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_H);
                       System.out.println("H HERE");
                   }
                   else{
                       out.println(Constants.key_h);
                       System.out.println("h here");
                   }
                   return true;
               case KeyEvent.KEYCODE_J:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_J);
                       System.out.println("J HERE");
                   }
                   else{
                       out.println(Constants.key_j);
                       System.out.println("j here");
                   }
                   return true;
               case KeyEvent.KEYCODE_K:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_K);
                       System.out.println("K HERE");
                   }
                   else{
                       out.println(Constants.key_k);
                       System.out.println("k here");
                   }
                   return true;
               case KeyEvent.KEYCODE_L:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_L);
                       System.out.println("L HERE");
                   }
                   else{
                       out.println(Constants.key_l);
                       System.out.println("l here");
                   }
                   return true;
               case KeyEvent.KEYCODE_Z:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_Z);
                       System.out.println("Z HERE");
                   }
                   else{
                       out.println(Constants.key_z);
                       System.out.println("z here");
                   }
                   return true;
               case KeyEvent.KEYCODE_X:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_X);
                       System.out.println("X HERE");
                   }
                   else{
                       out.println(Constants.key_x);
                       System.out.println("x here");
                   }
                   return true;
               case KeyEvent.KEYCODE_C:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_C);
                       System.out.println("C HERE");
                   }
                   else{
                       out.println(Constants.key_c);
                       System.out.println("c here");
                   }
                   return true;
               case KeyEvent.KEYCODE_V:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_V);
                       System.out.println("V HERE");
                   }
                   else{
                       out.println(Constants.key_v);
                       System.out.println("v here");
                   }
                   return true;
               case KeyEvent.KEYCODE_B:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_B);
                       System.out.println("B HERE");
                   }
                   else{
                       out.println(Constants.key_b);
                       System.out.println("b here");
                   }
                   return true;
               case KeyEvent.KEYCODE_N:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_N);
                       System.out.println("N HERE");
                   }
                   else{
                       out.println(Constants.key_n);
                       System.out.println("n here");
                   }
                   return true;
               case KeyEvent.KEYCODE_M:
                   if(event.isShiftPressed()){
                       out.println(Constants.key_M);
                       System.out.println("M HERE");
                   }
                   else{
                       out.println(Constants.key_m);
                       System.out.println("m here");
                   }
                   return true;
               default:
                    return super.onKeyUp(keyCode, event);
            }
        }
        return super.onKeyUp(keyCode, event);
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

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.keyb:
            try {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            } catch (Exception e) {
                e.printStackTrace();
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
