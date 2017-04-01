package org.innoversetech.remotetouch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mouse;
    private Button qrCode;
    private Button keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mouse = (Button)findViewById(R.id.Mouse);
        qrCode = (Button)findViewById(R.id.qrCode);
        keyboard = (Button)findViewById(R.id.keyBoard);
        mouse.setOnClickListener(this);
        qrCode.setOnClickListener(this);
        keyboard.setOnClickListener(this);
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
        }
    }
}
