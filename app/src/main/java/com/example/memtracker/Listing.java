package com.example.memtracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Listing extends AppCompatActivity {
    Button mOrder;
    TextView mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        mOrder = findViewById(R.id.btnOrder);
        mItemSelected = findViewById(R.id.tvItemSelected);

        listItems = getResources().getStringArray(R.array.ListNames);
        checkedItems = new boolean[listItems.length];

        mOrder.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Listing.this);
                mBuilder.setTitle("List Names");
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            if (!mUserItem.contains(position)) {
                                mUserItem.add(position);

                            } else {
                                mUserItem.remove(position);
                            }
                        }

                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItem.size(); i++) {
                            item = item + listItems[mUserItem.get(i)];
                            if (i != mUserItem.size() - 1) {
                                item = item + ", ";
                            }

                        }
                        mItemSelected.setText(item);

                    }
                });
                mBuilder.setNegativeButton("dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItem.clear();
                            mItemSelected.setText("");
                        }

                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }

        });
    }


}

