package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void Manager(View view) {
        Intent i = new Intent(codeDisplay.this, MainPageOrg.class);
        //i.putExtra("orgkey2", name.getText().toString());
        startActivity(i);

        Intent b = new Intent(codeDisplay.this, MainPageOrg.class);
        b.putExtra("toManage", name.getText().toString());
        startActivity(b);

        Intent c = new Intent(codeDisplay.this, MainPageOrg.class);
        b.putExtra("toManage2", name.getText().toString());
        startActivity(c);
    }

}
