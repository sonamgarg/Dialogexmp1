package com.example.mints.dialogexmp1;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mints on 2/22/2017.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<Model_Food> listMenu;


    public MyExpandableAdapter(Context context, ArrayList<Model_Food> listMenu) {
        this.context=context;
        this.listMenu=listMenu;
    }

    @Override
    public int getGroupCount() {
        return listMenu.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listMenu.get(groupPosition).items.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listMenu.get(groupPosition).groupName;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // listMenu.get(groupPosition)     gives you entire one record  for ex new Model_Food("Veg",new String[]{"Allo Paratha","Tea","Rolls"});
        //
        // listMenu.get(groupPosition).items    gives you    new String[]{"Allo Paratha","Tea","Rolls"}

        // listMenu.get(groupPosition).items[childPosition]   gives you child item at child position   eg "Allo Paratha"
        return listMenu.get(groupPosition).items[childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.row_of_recycler,null);
        TextView textView= (TextView) convertView.findViewById(R.id.textView);

        Model_Food m=listMenu.get(groupPosition);
        textView.setText(m.groupName);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.row_of_recycler,null);
        TextView textView2= (TextView) convertView.findViewById(R.id.textView2);

        Model_Food m=listMenu.get(groupPosition);
        textView2.setText(m.items[childPosition]);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

