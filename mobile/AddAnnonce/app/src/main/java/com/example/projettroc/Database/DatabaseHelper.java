package com.example.projettroc.Database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "annonce_db";
    public static final String TABLE_ANNONCE = "annonce";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
public static final String COL_DESCRIPTION="description";
    public String CREATE_ANNONCE_TABLE ="create table "+TABLE_ANNONCE+"("
            +COL_ID+" integer primary key autoincrement, "
            +COL_NAME+" text, "+COL_DESCRIPTION+" text)";

    SQLiteDatabase db;

    public DatabaseHelper(Activity context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ANNONCE_TABLE);
        Log.d("DB","DB created ! ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS "+ TABLE_ANNONCE);
        onCreate(db);
    }

    public SQLiteDatabase open(){
        db= this.getWritableDatabase();
        return db;
    }

        public void addAnnonce(Annonce s){
        open();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,s.getName());

        values.put(COL_DESCRIPTION,s.getDescription());
        db.insert(TABLE_ANNONCE,null,values);
    }

    public void updateAnnonce(Annonce s){
        open();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,s.getName());
        values.put(COL_DESCRIPTION,s.getDescription());
        db.update(TABLE_ANNONCE,values,COL_ID+"=?",new String[]{String.valueOf(s.getId())});
    }

    public void removeAnnonce(int id){
        open();
        db.delete(TABLE_ANNONCE,COL_ID+"=?",new String[]{String.valueOf(id)});
    }

    public ArrayList<Annonce> getAllAnnonce(){
        db=this.getReadableDatabase();
        ArrayList<Annonce>List=new ArrayList<Annonce>();
        Cursor c =db.query(TABLE_ANNONCE,null,null,null,null,null,null);
        c.moveToFirst();
        do{
            Annonce s=new Annonce(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            List.add(s);
        }while (c.moveToNext());
        return List;
    }
    public int getAnnonceCount(){
        db=this.getReadableDatabase();
        int cpt=0;
        Cursor c=db.query(TABLE_ANNONCE,null,null,null,null,null,null,null);
        cpt=c.getCount();
        return cpt;
    }


}
