package com.example.memtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainPageHelp extends AppCompatActivity {
    TextView name;
    Button button;
    Button clickButton = (Button) findViewById(R.id.clickButton);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_help);

        button = (Button) findViewById(R.id.button2);
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
        clickButton = findViewById(R.id.clickButton);
        Intent j = new Intent(MainPageHelp.this,Listing.class);
        startActivity(j);
    }


}
