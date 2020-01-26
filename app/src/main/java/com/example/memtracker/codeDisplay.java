package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class codeDisplay extends AppCompatActivity {

    TextView name;
    TextView displayWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_display);

        Intent intent = getIntent();
        name = (TextView)findViewById(R.id.Name);

        String nameOfUser = intent.getStringExtra("orgKey");

        name.setText(nameOfUser);

        int code;
        displayWindow = findViewById(R.id.displayWindow);

    }
}
