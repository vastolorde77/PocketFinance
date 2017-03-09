package com.example.muammar.myapplication;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;

/**
 * Created by Muammar on 5/22/2016.
 */
public class Fragment2 extends Fragment4 {

 Entry xi;







    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View s = inflater.inflate(R.layout.fragment_2,container,false);
        LineChart barChart = (LineChart) s.findViewById(R.id.barchart);


     ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(40000, 0));
        entries.add(new Entry(80000, 1));
        entries.add(new Entry(60000, 2));
        entries.add(new Entry(120000, 3));
        entries.add(new Entry(180000, 4));
        entries.add(new Entry(90000, 5));
        entries.add(new Entry(90000, 6));

       if( i > 0 ){
           AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
           builder.setMessage("Inserted  "+(et.getText().toString())).setTitle("Insert Successful");
           AlertDialog dialog = builder.create();
          entries.set(3,new Entry((120000+ty),3));
       }











        LineDataSet dataset = new LineDataSet(entries, "");
        dataset.setColors(ColorTemplate.MATERIAL_COLORS);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Monday");
        labels.add("Tuesday");
        labels.add("Wednesday");
        labels.add("Thursday");
        labels.add("Friday");
        labels.add("Saturday");
        labels.add("Sunday");



        LineData data = new LineData(labels, dataset);
        data.setValueTextColor(Color.WHITE);

        barChart.setData(data);
        barChart.invalidate();
        barChart.setBackgroundColor(Color.DKGRAY);
        dataset.setValueTextColor(Color.WHITE);
        dataset.setValueTextSize(12);
        barChart.getAxisLeft().setTextColor(Color.WHITE); // left y-axis
        barChart.getXAxis().setTextColor(Color.WHITE);
        barChart.getAxisRight().setTextColor(Color.WHITE);
        barChart.getLegend().setTextColor(Color.WHITE);
        dataset.setDrawFilled(true);



        barChart.setDescription("Description");
        barChart.animateX(4000);
        barChart.setBorderColor(Color.WHITE);
        barChart.setDescriptionColor(Color.WHITE);


        LineChart barChart1 = (LineChart)s.findViewById(R.id.barchart1);

        ArrayList<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(660000f, 0));
        entries1.add(new Entry(340000f, 1));
        entries1.add(new Entry(790000f, 2));
        entries1.add(new Entry(1200000f, 3));

        LineDataSet dataset1 = new LineDataSet(entries1, "");
        dataset1.setColors(ColorTemplate.MATERIAL_COLORS);
        ArrayList<String> labels1 = new ArrayList<String>();
        labels1.add("Week 1");
        labels1.add("Week 2");
        labels1.add("Week 3");
        labels1.add("Week 4");



        LineData data1 = new LineData(labels1, dataset1);
        data1.setValueTextColor(Color.WHITE);

        barChart1.setData(data1);
        barChart1.setBackgroundColor(Color.DKGRAY);
        dataset1.setValueTextColor(Color.WHITE);
        dataset1.setValueTextSize(12);
        barChart1.getAxisLeft().setTextColor(Color.WHITE); // left y-axis
        barChart1.getXAxis().setTextColor(Color.WHITE);
        barChart1.getAxisRight().setTextColor(Color.WHITE);
        barChart1.getLegend().setTextColor(Color.WHITE);
        dataset1.setDrawFilled(true);



        barChart1.setDescription("Description");
        barChart1.animateX(4000);
        barChart1.setBorderColor(Color.WHITE);
        barChart1.setDescriptionColor(Color.WHITE);





        return s;
    }


}
