package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.opencsv.CSVReader;


public class MainActivity extends AppCompatActivity {
    EditText inputText;
    private String request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       inputText = (EditText) findViewById(R.id.SearchText);
       inputText.setHint("Введите название рецепта");
        Button to_buy = (Button) findViewById(R.id.shopListButton);
        Button receipt = (Button) findViewById(R.id.receiptButton);
        inputText.setOnKeyListener(new OnKeyListener(){
           public boolean onKey(View view, int keyCode, KeyEvent keyevent){
                if((keyevent.getAction() == keyevent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    //set code for chatGPT api
                    request = inputText.getText().toString();
                    to_buy(request);
                    return true;
                }
                return false;
            }
        });
       to_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_buy(request);
            }
        });
    }

    public void to_buy(String answer) {
        Intent intent = new Intent(MainActivity.this, to_buy_activity.class);
        intent.putExtra("answerNotParsed", answer);
        startActivity(intent);
    }
}