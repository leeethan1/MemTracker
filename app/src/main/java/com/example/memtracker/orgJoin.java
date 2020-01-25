package com.example.memtracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class orgJoin extends AppCompatActivity {

    TextView name;
    EditText CodeID;
    EditText Opassword;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_join);

        Intent intent = getIntent();
        String placeholder = intent.getStringExtra("orgKey");
        name = (TextView)findViewById(R.id.Name);
        name.setText(placeholder);

        CodeID = findViewById(R.id.labelID);
        Opassword = findViewById(R.id.labelPassword);
        String enteredID = CodeID.getText().toString();
        String password = Opassword.getText().toString();

    }

    public void onRight(View view){
        Intent i =new Intent(orgJoin.this, MainPageOrg.class);
    }
}
