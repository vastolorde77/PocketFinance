package com.example.muammar.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Muammar on 5/22/2016.
 */
public class Fragment3 extends MainFragment {
    private FloatingActionButton fab;
    FirebaseDatabase mDb = FirebaseDatabase.getInstance();
    DatabaseReference ref = mDb.getReference("Users/Budget/value");
    DatabaseReference ref1 = mDb.getReference("Users/Expense/value");
    DatabaseReference refHome = mDb.getReference("Users/Expense/type/Home");
    DatabaseReference refePay = mDb.getReference("Users/Expense/type/E-Pay");
    DatabaseReference refFood = mDb.getReference("Users/Expense/type/Food");
    DatabaseReference refOthers = mDb.getReference("Users/Expense/type/Others");
    DatabaseReference refAll = mDb.getReference("Users/Expense");
    String budgets,expns;
    String Home,Food,epay,Others;
    Float homepi,foodpi,epaypi,Otherspi;
    int xpens,budgeta;


    public Fragment3(){


    }
    @Override
    public void onStart() {
        super.onStart();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View s = inflater.inflate(R.layout.fragment_3,container,false);

        final TextView budget = (TextView)s.findViewById(R.id.budget);
        final TextView expens = (TextView)s.findViewById(R.id.expenses);





        final PieChart pi = (PieChart)s.findViewById(R.id.pie);


//        ArrayList<Entry> entries = new ArrayList<>();
//        entries.add(new Entry(40000f, 0));
//        entries.add(new Entry(80000f, 1));
//        entries.add(new Entry(homepi, 2));
//        entries.add(new Entry(120000f, 3));
//        PieDataSet dataset = new PieDataSet(entries, "");
//        dataset.setColors(ColorTemplate.MATERIAL_COLORS);
//        dataset.setValueTextSize(15);
//        dataset.setValueTextColor(Color.WHITE);
//
//
//        ArrayList<String> labels = new ArrayList<String>();
//        labels.add("Food");
//        labels.add("E-pay");
//        labels.add("Home");
//        labels.add("Others");
//
//
//        PieData pid = new PieData(labels,dataset);
//        pid.setValueFormatter(new PercentFormatter());
//        pi.setData(pid);
//        pi.animateY(3000);
//        pi.setDescription("Your Expenses this week");
//        pi.setCenterText("This Week Expenses");
//        pi.setUsePercentValues(true);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                budgets = "Budget : Rp."+dataSnapshot.getValue(String.class);
                budget.setText(budgets);
                budgeta = Integer.parseInt(dataSnapshot.getValue(String.class));




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        refHome.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Home = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        refFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Food = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        refePay.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                epay = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        refOthers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Others = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String xve = dataSnapshot.getValue(String.class);
                expns = "Expense : Rp."+dataSnapshot.getValue(String.class);
                expens.setText(expns);
                xpens = Integer.parseInt(dataSnapshot.getValue(String.class));
                homepi = Float.parseFloat(Home);
                foodpi = Float.parseFloat(Food);
                epaypi = Float.parseFloat(epay);
                Otherspi = Float.parseFloat(Others);


                ArrayList<Entry> entries = new ArrayList<>();
                entries.add(new Entry(foodpi, 0));
                entries.add(new Entry(epaypi, 1));
                entries.add(new Entry(homepi, 2));
                entries.add(new Entry(Otherspi, 3));
                PieDataSet dataset = new PieDataSet(entries, "");
                dataset.setColors(ColorTemplate.MATERIAL_COLORS);
                dataset.setValueTextSize(15);
                dataset.setValueTextColor(Color.WHITE);


                ArrayList<String> labels = new ArrayList<String>();
                labels.add("Food");
                labels.add("E-pay");
                labels.add("Home");
                labels.add("Others");


                PieData pid = new PieData(labels,dataset);
                pid.setValueFormatter(new PercentFormatter());
                pi.setData(pid);
                pi.animateY(3000);
                pi.setDescription("Your Expenses this week");
                pi.setCenterText("This Week Expenses");
                pi.setUsePercentValues(true);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        fab = (FloatingActionButton)s.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(xpens >= budgeta){
                    Toast t = Toast.makeText(getActivity(),"You have insufficient Budget",Toast.LENGTH_SHORT);
                    t.show();

                    Intent myIntent = new Intent(getActivity(), InsertActual.class);
                    myIntent.putExtra("ID",5);
                    startActivity(myIntent);


                }else {

                    Intent myIntent = new Intent(getActivity(), Insert.class);
                    startActivity(myIntent);
                }

            }
        });








        return  s;
    }
}
