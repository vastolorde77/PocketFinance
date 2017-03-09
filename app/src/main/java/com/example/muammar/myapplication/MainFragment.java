package com.example.muammar.myapplication;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;


import com.example.muammar.myapplication.Tabs.SlidingTabLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements HistoryFragment.OnFragmentInteractionListener {
    View v;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;









    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x =  inflater.inflate(R.layout.fragment_main,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
//        BarChart barChart = (BarChart) x.findViewById(R.id.barchart);
//        ArrayList<BarEntry> entries = new ArrayList<>();
//        entries.add(new BarEntry(4f, 0));
//        entries.add(new BarEntry(8f, 1));
//        entries.add(new BarEntry(6f, 2));
//        entries.add(new BarEntry(12f, 3));
//        entries.add(new BarEntry(18f, 4));
//        entries.add(new BarEntry(9f, 5));
//        ArrayList<String> labels = new ArrayList<String>();
//        labels.add("January");
//        labels.add("February");
//        labels.add("March");
//        labels.add("April");
//        labels.add("May");
//        labels.add("June");
//        BarDataSet dataset = new BarDataSet(entries, "# of Calls");
//        BarData data = new BarData(labels, dataset);
//        barChart.setData(data);


//        barChart.invalidate(); // refresh
        
        return x;


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private class Appcompat extends AppCompatActivity{
        public Appcompat() {

        }
    }

     class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

         @Override
         public Fragment getItem(int position) {
             switch (position){

                 case 0 : return  new Fragment3();
                 case 1 : return  new Fragment2();
                 case 2 : return  new HistoryFragment();


             }
             return null;
         }

         @Override
         public int getCount() {
             return int_items;
         }

         @Override
         public CharSequence getPageTitle(int position) {
              String title [] = {"Main","Week","History"};
             return title[position];




         }
     }
}
