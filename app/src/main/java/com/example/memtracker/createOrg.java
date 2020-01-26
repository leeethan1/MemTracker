package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class createOrg extends AppCompatActivity {

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_org);

        Intent intent = getIntent();
        name = (TextView)findViewById(R.id.Name);

        String nameOfUser = intent.getStringExtra("toCreate");

        name.setText(nameOfUser);
    }

    public void Display(View view) {
        Intent i = new Intent(createOrg.this, codeDisplay.class);
        startActivity(i);

        Intent b = new Intent(createOrg.this, codeDisplay.class);
        b.putExtra("toDisplay", name.getText().toString());
        startActivity(b);
    }

}
