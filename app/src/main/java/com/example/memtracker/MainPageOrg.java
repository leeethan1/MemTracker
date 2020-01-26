package com.example.memtracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPageOrg extends AppCompatActivity {

    TextView name;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_org);

        Intent intent = getIntent();
        name = (TextView)findViewById(R.id.Name);

        String nameOfUser = intent.getStringExtra("toManage");

        name.setText(nameOfUser);

        Intent intent2 = getIntent();
        name = (TextView)findViewById(R.id.Number);

        String nameOfUser2 = intent2.getStringExtra("toManage2");

        name.setText(nameOfUser);
        number.setText(nameOfUser2);


    }
}
