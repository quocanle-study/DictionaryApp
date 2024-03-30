package com.example.dictionaryappdictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.dictionaryappdictionaryapp.databaseUtil.DatabaseAccessAnhViet;

public class DefinitionActivity extends AppCompatActivity {

    private TextView tvDefinition, tvWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);
        tvDefinition = findViewById(R.id.tv_definition);
        tvWord = findViewById(R.id.tv_word);
        //Lấy dữ liệu form kia gởi qua
        Intent intent = getIntent();
        String word = intent.getStringExtra("word");
        tvWord.setText(word);
        //query định nghĩa của từ từ csdl
        DatabaseAccessAnhViet dbAccess = DatabaseAccessAnhViet.getInstance(this);
        dbAccess.open();
        String definition = dbAccess.getDefinition(word);
        dbAccess.close();
        //Hiển thị trên textView
        tvDefinition.setText(Html.fromHtml(definition));


    }

}