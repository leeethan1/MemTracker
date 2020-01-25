package com.example.memtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NameEntry extends AppCompatActivity {

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_entry);
        input = findViewById(R.id.Name);

    }



    public void onClick(View view) {
        Intent i = new Intent(NameEntry.this, organiserPage.class);
        startActivity(i);

        Intent b = new Intent(NameEntry.this, organiserPage.class);
        b.putExtra("orgKey", input.getText().toString());
        startActivity(b);

        Intent c = new Intent(NameEntry.this, organiserPage.class);
        c.putExtra("orgKeyIan", input.getText().toString());
        startActivity(c);
    }
}
