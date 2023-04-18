package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class to_buy_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_buy);
        String toBuyNotParsed = getIntent().getStringExtra("answerNotParsed");
        LinearLayout linearLayout = findViewById(R.id.checkBoxes); // получаем ссылку на макет

        for (int i = 0; i < 5; i++) {
            CheckBox checkBox = new CheckBox(this); // создаем новый флажок
            checkBox.setText("Флажок " + (i + 1)); // устанавливаем текст для флажка
            linearLayout.addView(checkBox); // добавляем флажок в макет
        }
    }
    public void to_main() {
        Intent intent = new Intent(to_buy_activity.this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        to_main();
    }
}
