package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class createOrg extends AppCompatActivity {
    EditText orgName;
    String eventName;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_org);

        Intent intent = getIntent();
        name = (TextView)findViewById(R.id.Name);

        String nameOfUser = intent.getStringExtra("toCreate");

        name.setText(nameOfUser);

        System.out.println(nameOfUser);

        orgName = findViewById(R.id.NameEvent);

    }

    public void Display(View view) {
        eventName = orgName.getText().toString();
        System.out.println(eventName);
        Intent i = new Intent(createOrg.this, codeDisplay.class);
        startActivity(i);

        Intent b = new Intent(createOrg.this, codeDisplay.class);
        b.putExtra("toDisplay", name.getText().toString());
        b.putExtra("getNameOrg", eventName);
        startActivity(b);
    }

}
