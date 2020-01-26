package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class codeDisplay extends AppCompatActivity {
    String code;
    TextView name;
    TextView displayWindow;
    String nameOfEvent;
    String nameOfUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_display);

        Intent intent = getIntent();
        name = (TextView)findViewById(R.id.Name);

        nameOfUser = intent.getStringExtra("toDisplay");
        nameOfEvent = intent.getStringExtra("getNameOrg");

        name.setText(nameOfUser);

        client clientTask = new client(nameOfEvent, nameOfUser);
        clientTask.execute();
        code = clientTask.getMessage();
    }

    public void onClick(View view) {
//        Random random = new Random();
//        do {
//            code = random.nextInt(1000000);
//        } while (code < 99999);

        displayWindow = findViewById(R.id.displayWindow);
        displayWindow.setText(code);
    }

    public void Manager(View view) {
        Intent i = new Intent(codeDisplay.this, Main2Activity.class);
        startActivity(i);

    }

}



