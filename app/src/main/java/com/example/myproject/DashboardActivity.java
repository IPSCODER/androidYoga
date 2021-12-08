package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button yogasonactive,yogmudraactive,dietactive,hractive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        yogasonactive = (Button) findViewById(R.id.yson);
        yogmudraactive = (Button) findViewById(R.id.ymudra);
        dietactive = (Button) findViewById(R.id.ydiet);
        hractive = (Button) findViewById(R.id.yhr);

        yogasonactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this,YogaSonActivity.class);
                startActivity(intent);


            }
        });

        yogmudraactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(DashboardActivity.this,YogMudraActivity.class);
                startActivity(intent1);


            }
        });

        dietactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(DashboardActivity.this,DietActivity.class);
                startActivity(intent2);


            }
        });

        hractive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(DashboardActivity.this,HomeRemediesActivity.class);
                startActivity(intent3);


            }
        });


    }
}