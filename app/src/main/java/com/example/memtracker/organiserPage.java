package com.example.memtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memtracker.R;

public class organiserPage extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organiser_page);

        Intent intent = getIntent();
        name = (TextView)findViewById(R.id.label);

        String nameOfUser = intent.getStringExtra("orgKey");

        name.setText(nameOfUser);

    }

    public void Creator(View view) {
        Intent i = new Intent(organiserPage.this, MainPageOrg.class);
        i.putExtra("orgkey2", name.getText().toString());
        startActivity(i);

//        Intent b = new Intent(organiserPage.this, MainPageOrg.class);
//        b.putExtra("orgKey2", name.getText().toString());
//        startActivity(b);
    }

    public void Joiner(View view) {
//        Intent j = new Intent(organiserPage.this, orgJoin.class);
//        startActivity(j);
//
//        Intent c = new Intent(organiserPage.this, orgJoin.class);
//        c.putExtra("orgKey3", nameOfUser);
//        startActivity(c);
    }
}
