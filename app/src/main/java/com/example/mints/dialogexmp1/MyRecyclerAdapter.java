package com.example.mints.dialogexmp1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Mints on 2/20/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
    Context context;
    ArrayList<RecyclerModel> arrayList;
    RecyclerModel recyclerModel;
    public MyRecyclerAdapter(Context context,ArrayList<RecyclerModel> arrayList,RecyclerModel recyclerModel){
        this.context=context;
        this.arrayList=arrayList;
        this.recyclerModel=recyclerModel;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.row_of_recycler,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(recyclerModel.name);
        holder.textView2.setText(recyclerModel.class1);


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView,textView2;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView= (TextView) itemView.findViewById(R.id.textView);
        textView2= (TextView) itemView.findViewById(R.id.textView2);


    }
}