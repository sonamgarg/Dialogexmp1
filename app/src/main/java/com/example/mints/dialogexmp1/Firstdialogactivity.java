package com.example.mints.dialogexmp1;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Firstdialogactivity extends AppCompatActivity implements MyInterface{

     AlertDialog.Builder ab;
    EditText etName,etClass;
    SharedPreferences sharedPreferences;
    String stName,stClass;
    Button btnSharedPreferences,btnFetchSharedPreferences,btnSaveToDatabase,btnFetchFromDataBase,
            btnSendDataToNext,btnAlertDialog,btnDataPicker,btnStartActivityForResult,btnVolley,
            btnNextExpand,btnPostToServer,btnFragPager;
    MyDataBase myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstdialogactivity);
        btnStartActivityForResult= (Button) findViewById(R.id.btnStartActivityForResult);
        btnPostToServer= (Button) findViewById(R.id.btnPostToServer);
        btnVolley= (Button) findViewById(R.id.btnVolley);
        btnDataPicker= (Button) findViewById(R.id.btnDataPicker);
        btnAlertDialog= (Button) findViewById(R.id.btnAlertDialog);
        btnSendDataToNext= (Button) findViewById(R.id.btnSendDataToNext);
        btnFetchFromDataBase= (Button) findViewById(R.id.btnFetchFromDataBase);
        btnSharedPreferences= (Button) findViewById(R.id.btnSharedPreferences);
        btnFetchSharedPreferences= (Button) findViewById(R.id.btnFetchSharedPreferences);
        btnSaveToDatabase= (Button) findViewById(R.id.btnSaveToDatabase);
        btnFragPager= (Button) findViewById(R.id.btnFragPager);
        etClass= (EditText) findViewById(R.id.etClass);
        etName= (EditText) findViewById(R.id.etName);
        myDataBase=new MyDataBase(this);

        btnNextExpand= (Button) findViewById(R.id.btnNextExpand);

        findViewById(R.id.btnGoogleMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Firstdialogactivity.this,GoogleMapActivity.class);
                startActivity(intent);
            }
        });
        btnNextExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Firstdialogactivity.this,ExpandableListActivity.class);
                startActivity(in);
            }
        });


        btnSendDataToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Firstdialogactivity.this,SecondActivity.class);
                //Intent intent=new Intent("Hello");
                stName=etName.getText().toString();
                stClass=etClass.getText().toString();

                intent.putExtra("name",stName);
                intent.putExtra("class",stClass);
                startActivity(intent);
            }
        });

        btnSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stName=etName.getText().toString();
                stClass=etClass.getText().toString();

                sharedPreferences=getSharedPreferences("myShaeredPreferences",0);
                final SharedPreferences.Editor editor=sharedPreferences.edit();
              editor.putString("name",stName);
              editor.putString("class",stClass);
                editor.commit();
            }
        });
        btnFetchSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences=getSharedPreferences("myShaeredPreferences",0);

              String name1=sharedPreferences.getString("name","this is my name");
                String class1=sharedPreferences.getString("class","this is my class");
                Toast.makeText(Firstdialogactivity.this,"snsj"+name1,Toast.LENGTH_LONG).show();
                Toast.makeText(Firstdialogactivity.this,"sj"+class1,Toast.LENGTH_LONG).show();
                Log.v("name====",name1);
                Log.v("class===",class1);


            }
        });

        btnSaveToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stName=etName.getText().toString();
                stClass=etClass.getText().toString();
                myDataBase.insertIntoDatabase(stName,stClass);

            }
        });
        btnFetchFromDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataBase.fetchData();

            }
        });
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab=new AlertDialog.Builder(Firstdialogactivity.this);
                ab.setMessage("hello guys");
                ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Firstdialogactivity.this,"ok is clicked",Toast.LENGTH_LONG).show();
                    }
                });ab.show();
            }
        });

        btnDataPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                DatePickerDialog datePickerDialog=new DatePickerDialog(Firstdialogactivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                    }
                },calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btnStartActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Firstdialogactivity.this,SecondActivity.class);
                intent.putExtra("name",etName.getText().toString());
                startActivityForResult(intent,1);
            }
        });
        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Firstdialogactivity.this,VolleyActivity.class);

                startActivity(intent);
            }
        });
        btnPostToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Firstdialogactivity.this,PostingToServerActivity.class);

                startActivity(intent);
            }
        });

        btnFragPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Firstdialogactivity.this,PagerActivity.class);

                startActivity(intent);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String value=data.getExtras().getString("sonam");
        if(requestCode==1){
            Toast.makeText(Firstdialogactivity.this,"hello  "+value,Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void clickPosition(String val) {
        Toast.makeText(Firstdialogactivity.this,"Value= "+val,Toast.LENGTH_LONG).show();
    }
}