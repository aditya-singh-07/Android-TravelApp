package com.aditya.travelapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    public DBhelper(@Nullable Context context) {
        super(context, "cache.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String TABLE="CREATE TABLE category(cat_id integer primary key autoincrement, text cat_title,text cat_image)";
    db.execSQL(TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table category");
        onCreate(db);
    }
}
