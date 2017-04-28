package com.example.mints.dialogexmp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpandableListActivity extends AppCompatActivity {
    //String[] groupItems = {"veg", "non-veg","Chineese","rajastani"};
  //Map<String,childItems> map=new HashMap();

    ArrayList<Model_Food> listMenu=new ArrayList<>();

    MyExpandableAdapter myExpandableAdapter;
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        Model_Food m=new Model_Food("Veg",new String[]{"Allo Paratha","Tea","Rolls"});
        Model_Food m1=new Model_Food("Non Veg",new String[]{"Allo Paratha","Tea","Rolls"});
        Model_Food m2=new Model_Food("Veg",new String[]{"Allo Paratha","Tea","Rolls"});
        Model_Food m3=new Model_Food("Veg",new String[]{"Allo Paratha","Tea","Rolls"});
        Model_Food m4=new Model_Food("Veg",new String[]{"Allo Paratha","Tea","Rolls"});
        Model_Food m5=new Model_Food("Veg",new String[]{"Allo Paratha","Tea","Rolls"});
        Model_Food m6=new Model_Food("Veg",new String[]{"Allo Paratha","Tea","Rolls"});

        listMenu.add(m);
        listMenu.add(m1);
        listMenu.add(m2);
        listMenu.add(m3);
        listMenu.add(m4);
        listMenu.add(m5);
        listMenu.add(m6);


        expandableListView= (ExpandableListView) findViewById(R.id.expandableListView);
        myExpandableAdapter=new MyExpandableAdapter(ExpandableListActivity.this,listMenu);
        expandableListView.setAdapter(myExpandableAdapter);
    }
}
