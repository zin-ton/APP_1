package com.example.cookbook;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class to_buy_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_buy);
        String toBuyNotParsed = getIntent().getStringExtra("answerNotParsed");
        LinearLayout linearLayout = findViewById(R.id.checkBoxes); // получаем ссылку на макет
        AssetManager assetManager = getAssets();
        InputStream inputStream;
        try {
            inputStream = assetManager.open("csvfile.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        CSVReader csvReader = new CSVReaderBuilder(inputStreamReader)
                .withSkipLines(1)
                .withCSVParser(csvParser)
                .build();
        String[] nextLine;
        for (int i = 0; i < 5; i++) {
            try {
                nextLine = csvReader.readNext();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            CheckBox checkBox = new CheckBox(this); // создаем новый флажок
            checkBox.setText(nextLine[3]); // устанавливаем текст для флажка
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
