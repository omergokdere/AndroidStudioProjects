package com.example.administrator.vtuygulama;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by Administrator on 21.10.2014.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="maltepe";
    public static final String TABLE_NAME="personel";
    public static final String COLUMN_AD="ad";
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_CREATE = "CREATE TABLE personel " +
            "(ad String, soyad String);";
    public static final String DATABASE_DROP="DROP TABLE IF EXISTS"+
            TABLE_NAME;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DATABASE_DROP);
        onCreate(db);

    }
}
