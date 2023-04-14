package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class to_buy_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_buy);
        String toBuyNotParsed = getIntent().getStringExtra("answerNotParsed");
    }
    public void to_main() {
        Intent intent = new Intent(to_buy_activity.this, MainActivity.class);
        startActivity(intent);
    }
}
