package com.example.memtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class helperPage extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_page);

        Intent intent = getIntent();
        String placeholder = intent.getStringExtra("toJoinUp");
        name = (TextView) findViewById(R.id.Name);
        name.setText(placeholder);
    }

    public void onClick(View view) {
        Intent j = new Intent(helperPage.this, helpJoin.class);
        startActivity(j);

        Intent b = new Intent(helperPage.this, helpJoin.class);
        b.putExtra("toJoinUp2", name.getText().toString());
        startActivity(b);
    }
}