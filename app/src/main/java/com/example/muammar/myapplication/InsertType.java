package com.example.muammar.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertType extends AppCompatActivity {

    FirebaseDatabase mDb = FirebaseDatabase.getInstance();
    DatabaseReference ref = mDb.getReference("Users/Budget/value");
    DatabaseReference ref1 = mDb.getReference("Users/Expense/value");
    EditText etx = (EditText)findViewById(R.id.editTextInsert);
    Integer val_actual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_type);

        Button bux = (Button)findViewById(R.id.InsertTypeIns);
        bux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(InsertType.this).create(); //Read Update
                alertDialog.setTitle("Inserted");
                alertDialog.setMessage("Data Successfully Inserted");


                alertDialog.show();
                Intent goback = new Intent(InsertType.this, MainActivity.class);
                startActivity(goback);

            }
        });


    }
}

