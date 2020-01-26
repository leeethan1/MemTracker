package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainPageHelp extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_help);

        Intent intent = getIntent();
        String placeholder = intent.getStringExtra("toJoinUp2");
        name = (TextView) findViewById(R.id.Name);
        name.setText(placeholder);
    }
}
