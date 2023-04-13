package com.example.cookbook;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


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
                    String request = "выведи построчно что мне надо купить чтобы приготовить ";
                    request.concat(inputText.toString());
                    try {
                        String answer = ChatGpt.chatGPT(request);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return true;
                }
                return false;
            }
        });

    }

    public void to_buy(View view) {
        Intent toBuy = new Intent(MainActivity.this, to_buy_activity.class);
        startActivity(toBuy);
    }

    public void receipt(View view) {
    }
}