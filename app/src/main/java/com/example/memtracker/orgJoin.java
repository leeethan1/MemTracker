package com.example.memtracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memtracker.R;

public class orgJoin extends AppCompatActivity {

    TextView name;
    EditText CodeID;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_join);

        Intent intent = getIntent();
        String placeholder = intent.getStringExtra("toJoin");
        name = (TextView)findViewById(R.id.Name);
        name.setText(placeholder);

        CodeID = findViewById(R.id.Code);
        String enteredID = CodeID.getText().toString();
        int codeCheck = Integer.parseInt(enteredID);
    }

    public void onRight(View view){
        String enteredID = CodeID.getText().toString();
        int codeCheck = Integer.parseInt(enteredID);

        if (codeCheck == 124421) {
            Intent i = new Intent(orgJoin.this, MainPageOrg.class);
            startActivity(i);

            Intent b = new Intent(orgJoin.this, MainPageOrg.class);
            b.putExtra("toManage", name.getText().toString());
            startActivity(b);
        }
        else{
            //Nothing
        }
    }
}
