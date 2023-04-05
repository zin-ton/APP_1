package com.example.cookbook;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText) findViewById(R.id.SearchText);
        inputText.setOnKeyListener(new OnKeyListener(){
            public boolean onKey(View view, int keyCode, KeyEvent keyevent){
                if((keyevent.getAction() == keyevent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    //set code for chatGPT api
                    return true;
                }
                return false;
            }
        });
    }
}