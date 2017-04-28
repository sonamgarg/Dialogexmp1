package com.example.mints.dialogexmp1;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    RecyclerModel recyclerModel;
    ArrayList<RecyclerModel> arrayList;
    MyRecyclerAdapter myRecyclerAdapter;
    RecyclerView recyclerView;
    BroadcastReceiver broadcastReceiver;
    EditText etEnter,etCla;
    Button btnSendToParent,btnNext,btnRecycler;
TextView tvFirst,tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SecondActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        btnNext= (Button) findViewById(R.id.btnNext);
        btnRecycler= (Button) findViewById(R.id.btnRecycler);
        btnSendToParent= (Button) findViewById(R.id.btnSendToParent);
        tvFirst= (TextView) findViewById(R.id.tvFirst);
        tvSecond= (TextView) findViewById(R.id.tvSecond);
        etEnter= (EditText) findViewById(R.id.etEnter);
        etCla= (EditText) findViewById(R.id.etCla);

        arrayList=new ArrayList<>();
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerModel=new RecyclerModel(etEnter.getText().toString(),etCla.getText().toString());
                arrayList.add(recyclerModel);
                myRecyclerAdapter=new MyRecyclerAdapter(SecondActivity.this,arrayList,recyclerModel);
                recyclerView.setAdapter(myRecyclerAdapter);

            }
        });


        final Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String strName=bundle.getString("name");
        String strClass=bundle.getString("class");

        Toast.makeText(SecondActivity.this,"hello "+strName,Toast.LENGTH_LONG).show();
        Toast.makeText(SecondActivity.this,"hi "+strClass,Toast.LENGTH_LONG).show();

        tvFirst.setText(strName);
        tvSecond.setText(strClass);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent1=new Intent(SecondActivity.this,ServerActivity.class);
                startActivity(intent1);
            }
        });



        btnSendToParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMsg=etEnter.getText().toString();
                intent.putExtra("sonam",strMsg);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    /*    broadcastReceiver=new MyReceiver();
        IntentFilter intentFilter=new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        registerReceiver(broadcastReceiver,intentFilter);
        Toast.makeText(SecondActivity.this,"hello dynamic broadcast",Toast.LENGTH_LONG).show();
        unregisterReceiver(broadcastReceiver);
*/    }
}
