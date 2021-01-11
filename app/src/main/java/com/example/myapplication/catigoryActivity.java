package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class catigoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catigory);
        TextView hibhob = (TextView) findViewById(R.id.hibhob);
        hibhob.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent hibhobIntent = new Intent(catigoryActivity.this, hibhobActivity.class);
                startActivity(hibhobIntent);
            }
        });
        TextView classic = (TextView) findViewById(R.id.classic);
        classic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent cIntent = new Intent(catigoryActivity.this, classicActivity.class);
                startActivity(cIntent);
            }
        });
        TextView folk = (TextView) findViewById(R.id.folk);
        folk.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent folkIntent = new Intent(catigoryActivity.this, folkActivity.class);
                startActivity(folkIntent);
            }
        });
        TextView color = (TextView) findViewById(R.id.rock);
        color.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent rocky = new Intent(catigoryActivity.this, rockActivity.class);
                startActivity(rocky);
            }
        });
        Button goo = (Button) findViewById(R.id.gooplay);
        goo.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent gooIntent = new Intent(catigoryActivity.this, PlayerActivity.class);
                startActivity(gooIntent);

            }
        });
    }
    }

