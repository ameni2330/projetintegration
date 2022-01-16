package com.example.evenement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Databasehelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "evenement_db";
    public static final String TABLE_Evenement = "evenement";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_DATE = "date";
    public static final String COL_TEMPS = "temps";
    public String CREATE_Evenement_TABLE ="create table "+TABLE_Evenement+"("
            +COL_ID+" integer primary key autoincrement, "
            +COL_NAME+" text, "
            +COL_DATE+" text, "+COL_TEMPS+" text)";
    SQLiteDatabase db;

    public Databasehelper( Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Evenement_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS "+ TABLE_Evenement);
        onCreate(db);
    }

    public SQLiteDatabase open(){
        db= this.getWritableDatabase();
        return db;
    }

    public void addAnnonce(Evenement s){
        open();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,s.getName());
        values.put(COL_DATE,s.getDate());
        values.put(COL_TEMPS,s.getTemps());
        db.insert(TABLE_Evenement,null,values);
    }

    public void updateAnnonce(Evenement s){
        open();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,s.getName());
        values.put(COL_DATE,s.getDate());
        values.put(COL_TEMPS,s.getTemps());
        db.update(TABLE_Evenement,values,COL_ID+"=?",new String[]{String.valueOf(s.getId())});
    }

    public void removeAnnonce(int id){
        open();
        db.delete(TABLE_Evenement,COL_ID+"=?",new String[]{String.valueOf(id)});
    }

    public ArrayList<Evenement> getAllAnnonce(){
        db=this.getReadableDatabase();
        ArrayList<Evenement>List=new ArrayList<Evenement>();
        Cursor c =db.query(TABLE_Evenement,null,null,null,null,null,null);
        c.moveToFirst();
        do{
            Evenement s=new Evenement(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            List.add(s);
        }while (c.moveToNext());
        return List;
    }
    public int getAnnonceCount(){
        db=this.getReadableDatabase();
        int cpt=0;
        Cursor c=db.query(TABLE_Evenement,null,null,null,null,null,null,null);
        cpt=c.getCount();
        return cpt;
    }
}
