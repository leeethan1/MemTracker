package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView name;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button)findViewById(R.id.button2);
        Intent intent = getIntent();
        String placeholder = intent.getStringExtra("toJoinUp2");
        name = (TextView) findViewById(R.id.Name);
        name.setText(placeholder);

    }

    public void onClick(View view) {
        Intent i = getPackageManager().getLaunchIntentForPackage("com.example.myapplication");
        startActivity(i);

        /*Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "BlahBlah");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);*/

    }

    public void onClick2(View v){
        Intent j = new Intent(Main2Activity.this,Listing.class);
        startActivity(j);
    }
}
