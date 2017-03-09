package com.example.muammar.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Muammar on 5/22/2016.
 */
public class Fragment1 extends MainFragment {


    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    FloatingActionButton fab;
    TabLayout tabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View s = inflater.inflate(R.layout.fragment_1,container,false);
        tabs = (TabLayout) s.findViewById(R.id.tabs);


        expListView = (ExpandableListView)s.findViewById(R.id.expandableListView);






        expListView.setAdapter(new SavedTabsListAdapter());



        return s;

    }
    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = { "Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday","Sunday" };

        private String[][] children = {
                { "10:05 AM ....... Rp 10.000","11:25 AM ....... Rp 20.000","07:05 PM ....... Rp 10.000" },
                { "10:52 AM ....... Rp 40.000", "12:05 PM ....... Rp 30.000", "04:05 PM ....... Rp 10.000" },
                { "09:05 AM ....... Rp 30.000", "01:32 PM ....... Rp 30.000","05:05 PM ....... Rp 30.000" },
                { "11:05 AM ....... Rp 60.000", "05:05 PM ....... Rp 60.000" },
                { "10:23 AM ....... Rp 60.000", "06:05 PM ....... Rp 60.000", "09:05 PM ....... Rp 60.000"},
                { "04:02 PM ....... Rp 30.000", "06:05 PM ....... Rp 30.000","10:43 PM ....... Rp 30.000" },
                { "02:05 PM ....... Rp 30.000", "10:05 PM ....... Rp 30.000","10:25 PM ....... Rp 30.000" }

        };

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(Fragment1.this.getActivity());
            textView.setText(getGroup(i).toString());
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setTextSize(30);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundResource(R.color.colorPrimaryDark);


            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(Fragment1.this.getActivity());
            textView.setText(getChild(i, i1).toString());

            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }
}
