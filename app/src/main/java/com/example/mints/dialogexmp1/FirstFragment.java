package com.example.mints.dialogexmp1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mints on 3/5/2017.
 */

public class FirstFragment extends Fragment {


    MyInterface myInterface;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.firstfrag,null);
        v.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myInterface.clickPosition("Hello world");
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        myInterface= (MyInterface) context;
        super.onAttach(context);
    }
}
