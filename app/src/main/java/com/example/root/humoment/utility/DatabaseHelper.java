package com.example.root.humoment.utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.BaseColumns._ID;
import static com.example.root.humoment.utility.DatabaseContract.BentukColumns.EKS_BENTUK;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.CAP_SHAPE;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.COLOR;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.EDIBILITY;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.HABITAT;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.IMG_NAME;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.MUSHROOM_NAME;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.RANGE;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.STATUS;
import static com.example.root.humoment.utility.DatabaseContract.DictionaryColumns.USABILITY;
import static com.example.root.humoment.utility.DatabaseContract.TABLE_BENTUK;
import static com.example.root.humoment.utility.DatabaseContract.TABLE_JAMURY;

/**
 * Created by root on 2/23/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "dbjamur";
    private static final int DATABASE_VERSION = 1;

    public static String CREATE_TABLE_JAMURY = "create table "
            + TABLE_JAMURY + " (" + _ID + " integer primary key autoincrement, "+
            IMG_NAME + " text not null, "+
            RANGE + " text not null, "+
            MUSHROOM_NAME + " text not null, "+
            STATUS + " text not null, "+
            EDIBILITY + " text not null, "+
            USABILITY + " text not null, "+
            HABITAT + " text not null, "+
            COLOR + " text not null, "+
            CAP_SHAPE + " text not null);";

    public static String CREATE_TABLE_BENTUK = "create table " + TABLE_BENTUK + " (" + _ID + " integer primary key autoincrement, " +
            EKS_BENTUK + " text not null);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_JAMURY);
        db.execSQL(CREATE_TABLE_BENTUK);
        Log.d("loggy", CREATE_TABLE_JAMURY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_JAMURY);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BENTUK);
        onCreate(db);
    }
}
