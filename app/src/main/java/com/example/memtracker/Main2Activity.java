package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button button;
    EditText Value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button)findViewById(R.id.button2);

    }

    public void onClick(View view) {
        Intent i = getPackageManager().getLaunchIntentForPackage("com.example.myapplication");
        startActivity(i);
        Value = findViewById(R.id.integerVal);

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "BlahBlah");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }
}
