package com.example.muammar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button but1 = (Button)findViewById(R.id.buttonA);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Insert.this, InsertActual.class);
                myIntent.putExtra("ID",1);
                startActivity(myIntent);
            }
        });
        Button but2 = (Button)findViewById(R.id.buttonD);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Insert.this, InsertActual.class);
                myIntent.putExtra("ID",2);
                startActivity(myIntent);
            }
        });
        Button but3 = (Button)findViewById(R.id.buttonC);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Insert.this, InsertActual.class);
                myIntent.putExtra("ID",3);
                startActivity(myIntent);
            }
        });
        Button but4 = (Button)findViewById(R.id.buttonB);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Insert.this, InsertActual.class);
                myIntent.putExtra("ID",4);
                startActivity(myIntent);
            }
        });
        Button but5 = (Button)findViewById(R.id.buttonF);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Insert.this, InsertActual.class);
                myIntent.putExtra("ID",5);
                startActivity(myIntent);
            }
        });
    }

}
