package org.innoversetech.remotetouch;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class Mouse extends ActionBarActivity implements View.OnClickListener {
    Context context;
    //For Layout stuff
    Button mRbutton;
    Button mLbutton;
    TextView scrollView;
    TextView mScroller;
    //For connection stuff
    private boolean isConnected=false;
    private boolean mouseMoved=false;
    private Socket socket;
    private PrintWriter out;
    //Cursor movement
    private float initX =0;
    private float initY =0;
    private float disX =0;
    private float disY =0;
    private float sInitY =0;
    private float sDisY =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse);
        context = this;
        //Init the layout
        mLbutton = (Button)findViewById(R.id.leftClick);
        mRbutton = (Button)findViewById(R.id.rightClick);
        scrollView = (TextView)findViewById(R.id.mousePad);
        mScroller = (TextView)findViewById(R.id.mousePadScroller);
        //Setting the on click listeners for the buttons
        mLbutton.setOnClickListener(this);
        mRbutton.setOnClickListener(this);
        //Set touch on touch listener for mousepad
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (isConnected && out != null) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            //Save XY Co ordinates
                            initX = event.getX();
                            initY = event.getY();
                            mouseMoved = false;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            disX = event.getX() - initX; //movement in X Axis
                            disY = event.getY() - initY; //Movement in Y Axis
                            //reset Inits so that new position could always be captured
                            initX = event.getX();
                            initY = event.getY();
                            if (disX != 0 || disY != 0) {
                                out.println(disX + "," + disY); //send the movements to server to implement
                            }
                            mouseMoved = true;
                            break;
                        case MotionEvent.ACTION_UP:
                            //for only a single tap
                            if (!mouseMoved) {
                                out.println(Constants.MOUSE_LEFT_CLICK);
                            }
                    }
                }
                return true;
            }
        });

            mScroller.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(isConnected && out!=null){
                        switch(event.getAction()){
                            case MotionEvent.ACTION_DOWN:
                                sInitY = event.getY();
                                mouseMoved = false;
                                break;
                            case MotionEvent.ACTION_MOVE:
                                sDisY = event.getY()-sInitY;
                                initY = event.getY();
                                if(sDisY != 0){
                                    out.println("." + sDisY);
                                }
                                mouseMoved = true;
                                break;
                        }
                    }



                    return true;
                }
            });

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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.leftClick:
                if(isConnected && out != null){
                    out.println(Constants.MOUSE_LEFT_CLICK);
                }
                break;
            case R.id.rightClick:
                if(isConnected && out != null){
                    out.println(Constants.MOUSE_RIGHT_CLICK);
                }
        }

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
