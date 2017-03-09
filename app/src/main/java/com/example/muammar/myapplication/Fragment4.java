package com.example.muammar.myapplication;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

/**
 * Created by Muammar on 5/22/2016.
 */
public class Fragment4 extends Fragment {
    Button in,can,bac;
    EditText et;
    TabLayout tabs;
    public String transaction_hist;
    ArrayList<String> array_trans = new ArrayList<String>();
    Float ty  = 1000f;
    int i = 0;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.fragment_4,container,false);
        et = (EditText)x.findViewById(R.id.editText);

        can = (Button)x.findViewById(R.id.button3);
        in = (Button)x.findViewById(R.id.button);

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());







                if(Integer.parseInt(et.getText().toString())<=0){

                }
                else
                {

                    transaction_hist = et.getText().toString();
                    array_trans.add(transaction_hist);
                    ty = ty+Float.parseFloat(et.getText().toString());

                    i++;






                    builder.setMessage("Inserted  "+(et.getText().toString())).setTitle("Insert Successful");
                    AlertDialog dialog = builder.create();


                    dialog.show();

                }

            }
        });



        return x;
    }




}
