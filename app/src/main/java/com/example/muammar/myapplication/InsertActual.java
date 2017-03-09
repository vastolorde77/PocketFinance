package com.example.muammar.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertActual extends AppCompatActivity {
    FirebaseDatabase mDb = FirebaseDatabase.getInstance();
    DatabaseReference ref = mDb.getReference("Users/Expense/value");
    DatabaseReference ref1 = mDb.getReference("Users/Expense/type/Home");
    DatabaseReference ref2 = mDb.getReference("Users/Expense/type/Food");
    DatabaseReference ref3 = mDb.getReference("Users/Expense/type/E-Pay");
    DatabaseReference ref4 = mDb.getReference("Users/Expense/type/Others");
    DatabaseReference ref5 = mDb.getReference("Users/Budget/value");
    String typez;

    DateFormat dg =  new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Date rightnow = new Date();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_actual);
        Button bux = (Button)findViewById(R.id.InsertTypeIns1);


        final int inputref = getIntent().getIntExtra("ID",1);
        bux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(InsertActual.this).create(); //Read Update
                alertDialog.setTitle("Inserted");
                alertDialog.setMessage("Data Successfully Inserted");
                if(inputref != 5) {
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            EditText ext = (EditText) findViewById(R.id.editTextInsert1);
                            String y = ext.getText().toString();
                            String x = dataSnapshot.getValue(String.class);
                            int yy = Integer.parseInt(y);
                            int xx = Integer.parseInt(x);
                            int xy = yy + xx;
                            String xy_actual = Integer.toString(xy);
                            dataSnapshot.getRef().setValue(xy_actual);



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    if (inputref == 1) {
                        ref1.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                EditText ext = (EditText) findViewById(R.id.editTextInsert1);
                                String y = ext.getText().toString();
                                String x = dataSnapshot.getValue(String.class);
                                int yy = Integer.parseInt(y);
                                int xx = Integer.parseInt(x);
                                int xy = yy + xx;
                                String xy_actual = Integer.toString(xy);
                                dataSnapshot.getRef().setValue(xy_actual);
                                typez = "Home";

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    } else if (inputref == 2) {
                        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                EditText ext = (EditText) findViewById(R.id.editTextInsert1);
                                String y = ext.getText().toString();
                                String x = dataSnapshot.getValue(String.class);
                                int yy = Integer.parseInt(y);
                                int xx = Integer.parseInt(x);
                                int xy = yy + xx;
                                String xy_actual = Integer.toString(xy);
                                dataSnapshot.getRef().setValue(xy_actual);
                                typez = "Food";

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    } else if (inputref == 3) {
                        ref3.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                EditText ext = (EditText) findViewById(R.id.editTextInsert1);
                                String y = ext.getText().toString();
                                String x = dataSnapshot.getValue(String.class);
                                int yy = Integer.parseInt(y);
                                int xx = Integer.parseInt(x);
                                int xy = yy + xx;
                                String xy_actual = Integer.toString(xy);
                                dataSnapshot.getRef().setValue(xy_actual);
                                typez = "E-Pay";

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    } else if (inputref == 4) {
                        ref4.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                EditText ext = (EditText) findViewById(R.id.editTextInsert1);
                                String y = ext.getText().toString();
                                String x = dataSnapshot.getValue(String.class);
                                int yy = Integer.parseInt(y);
                                int xx = Integer.parseInt(x);
                                int xy = yy + xx;
                                String xy_actual = Integer.toString(xy);
                                dataSnapshot.getRef().setValue(xy_actual);
                                typez = "Others";

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }

                if(inputref == 1){typez = "Home";}
                else if(inputref == 2){typez = "Food";}
                else if(inputref == 3){typez = "E-Pay";}
                else if(inputref == 4){typez = "Others";}

                EditText ext = (EditText) findViewById(R.id.editTextInsert1);
                    EditText notext = (EditText) findViewById(R.id.editTextInsert2) ;

                String val = ext.getText().toString();
                int value = Integer.parseInt(val);
                    String notez = notext.getText().toString();
                mDb.getReference("Transactions").push().setValue(new UpObjects(typez,value,dg.format(rightnow),notez));
                    Toast t = Toast.makeText(getApplicationContext(),"Expense Added",Toast.LENGTH_SHORT);
                    t.show();
            }else{
                    ref5.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            EditText ext = (EditText) findViewById(R.id.editTextInsert1);
                            String y = ext.getText().toString();
                            String x = dataSnapshot.getValue(String.class);
                            int yy = Integer.parseInt(y);
                            int xx = Integer.parseInt(x);
                            int xy = yy + xx;
                            String xy_actual = Integer.toString(xy);
                            dataSnapshot.getRef().setValue(xy_actual);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    Toast t = Toast.makeText(getApplicationContext(),"Budget Added",Toast.LENGTH_SHORT);
                    t.show();



                }





                finish();
                Intent goback = new Intent(InsertActual.this, MainActivity.class);
                startActivity(goback);

            }
        });
    }
}

