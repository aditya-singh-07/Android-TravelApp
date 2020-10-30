package com.aditya.travelapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aditya.travelapp.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class category {
    static DBhelper dbhelper;
    static SQLiteDatabase database;

    public static DBhelper getinstance(Context context){
        if(dbhelper==null){
            dbhelper=new DBhelper(context);

        }
        return dbhelper;
    }

    public static void opendb(){
        database=dbhelper.getWritableDatabase();
    }
    public static void closedb(){
        database.close();
    }

    public static void category(CategoryModel categoryModels) {
        ContentValues cv=new ContentValues();
        cv.put("cat_image",categoryModels.getCat_image());
        cv.put("cat_title",categoryModels.getCat_title());
        database.insert("category",null,cv);
        database.close();
    }
    public ArrayList<CategoryModel> getcatlist(){
        database=dbhelper.getReadableDatabase();
        ArrayList<CategoryModel> catlist=new ArrayList<CategoryModel>();
        String order_sql="SELECT cat_image,cat_title FROM category";
        Cursor cursor=database.rawQuery(order_sql,null);
        if(cursor.moveToNext()){
            while(cursor.moveToNext()){
                CategoryModel catmodel=new CategoryModel();
                catmodel.setCat_image(cursor.getString(0));
                catmodel.setCat_title(cursor.getString(1));
                catlist.add(catmodel);
            }
        }
        cursor.close();
        return catlist;
    }

}
