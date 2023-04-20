package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class to_buy_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_buy);
        String toBuyNotParsed = getIntent().getStringExtra("answerNotParsed");
        LinearLayout linearLayout = findViewById(R.id.checkBoxes); // получаем ссылку на макет
        String nextLine[];
        try {
            String csvfileString = this.getApplicationInfo().dataDir + File.separatorChar + "csvfile.csv";
            File csvfile = new File(csvfileString);
            CSVReader reader = new CSVReader(new FileReader("csvfile.getAbsolutePath()"));
            for (int i = 0; i < 5; i++) {
                nextLine = reader.readNext();
                CheckBox checkBox = new CheckBox(this); // создаем новый флажок
                checkBox.setText(nextLine[i]); // устанавливаем текст для флажка
                linearLayout.addView(checkBox); // добавляем флажок в макет
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
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
