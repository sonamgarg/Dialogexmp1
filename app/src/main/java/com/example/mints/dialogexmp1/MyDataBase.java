package com.example.mints.dialogexmp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mints on 2/20/2017.
 */

public class MyDataBase {
    public SQLiteDatabase sqLiteDatabase;
    Context context;
    MyHelper myHelper;

   public MyDataBase(Context context){
    this.context=context;
    myHelper=new MyHelper(context,"sonamDataBase1",null,1);
    sqLiteDatabase=myHelper.getWritableDatabase();
    }

    // function for inserting data into the database
    public void insertIntoDatabase(String name1,String class1){
        ContentValues contentValues=new ContentValues();
        contentValues.put("StudentName",name1);
        contentValues.put("StudentClass",class1);
     long id=sqLiteDatabase.insert("sonamTable",null,contentValues);
        Toast.makeText(context,"hi position " + id,Toast.LENGTH_LONG).show();
    }


    public void fetchData(){
        Cursor cursor=sqLiteDatabase.query("sonamTable",null,null,null,null,null,null);
        if (cursor!=null){
            while (cursor.moveToNext()){
                Log.v("StudentName", cursor.getString(0));
                Log.v("StudentClass", cursor.getString(1));

            }

        }
    }

}




class MyHelper extends SQLiteOpenHelper{

    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table sonamTable(StudentName text,StudentClass text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
