package com.example.mints.dialogexmp1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PostingToServerActivity extends AppCompatActivity {
    EditText etName,etClass,etSection;
    Button btnPost;
    ArrayList<NameValuePair> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting_to_server);
        etName= (EditText) findViewById(R.id.etName);
        etClass= (EditText) findViewById(R.id.etClass);
        etSection= (EditText) findViewById(R.id.etSection);
        btnPost= (Button) findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               arrayList=new ArrayList<NameValuePair>();
                arrayList.add(new BasicNameValuePair("username","mukes"));
                arrayList.add(new BasicNameValuePair("password","1234"));
                arrayList.add(new BasicNameValuePair("origin","app"));
                MyTaskPost myTaskPost=new MyTaskPost();
                myTaskPost.execute();

            }
        });
    }


class MyTaskPost extends AsyncTask<Void,Void,String> {
    ProgressDialog progressDialog;
    Context context;



    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(PostingToServerActivity.this);
        progressDialog.setMessage("sending please wait...");
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        String response = null;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://ec2-52-27-23-84.us-west-2.compute.amazonaws.com/users/login");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpResponse httpResponse = null;
        try {
            httpResponse = defaultHttpClient.execute(httpPost);
            response = EntityUtils.toString(httpResponse.getEntity());

            Log.v("Respone====",response);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        if(progressDialog.isShowing()&progressDialog!=null){
            progressDialog.dismiss();
        }
        super.onPostExecute(s);
    }

}
}
