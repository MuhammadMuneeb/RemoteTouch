package org.innoversetech.remotetouch;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
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


public class Mouse extends AppCompatActivity implements View.OnClickListener {
    //For Layout stuff
    Context context;
    Button mRbutton;
    Button mLbutton;
    TextView scrollView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse);
        context = this;
        //Init the layout
        mLbutton = (Button)findViewById(R.id.leftClick);
        mRbutton = (Button)findViewById(R.id.rightClick);
        scrollView = (TextView)findViewById(R.id.mousePad);
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
//                        case MotionEvent.ACTION_UP:
//                            //for only a single tap
//                            if (!mouseMoved) {
//                                out.println(SyncStateContract.Constants.MOUSE_LEFT_BUTTON);
//                            }
                    }
                }
                return true;
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}
