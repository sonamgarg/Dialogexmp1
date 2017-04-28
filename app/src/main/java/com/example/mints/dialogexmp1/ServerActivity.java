package com.example.mints.dialogexmp1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerActivity extends AppCompatActivity {
    EditText etName,etClass,etSection;
    Button btnSend;
   // Button btnNextExpand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        etName= (EditText) findViewById(R.id.etName);
        etClass= (EditText) findViewById(R.id.etClass);
        etSection= (EditText) findViewById(R.id.etSection);
       btnSend= (Button) findViewById(R.id.btnSend);
       /* btnNextExpand= (Button) findViewById(R.id.btnNextExpand);
        btnNextExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ServerActivity.this,ExpandableListActivity.class);
                startActivity(in);
            }
        });
*/


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           MyTask myTask=new MyTask(ServerActivity.this);
                myTask.execute();
            }
        });
    }
}

class MyTask extends AsyncTask<Void,Void,String>{
Context context;
    String result;
    ProgressDialog progressDialog;

    public MyTask(Context context){
        this.context=context;
    }
    @Override
    protected void onPreExecute() {
        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("processing...");

        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        DefaultHttpClient client=new DefaultHttpClient();
        try {
        HttpGet get=new HttpGet("http://hmkcode.appspot.com/jsonservlet");
        HttpResponse response=null;
            response=client.execute(get);
             result= EntityUtils.toString(response.getEntity());
            Log.v("Response=",result);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {

        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        try {
            JSONArray jsonArray=new JSONArray(s);
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String name=jsonObject.getString("name");
                String country=jsonObject.getString("country");
                String twitter=jsonObject.getString("twitter");
                Log.v("twitter",twitter);
                Log.v("name",name);
                Log.v("country",country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        super.onPostExecute(s);
    }
}
