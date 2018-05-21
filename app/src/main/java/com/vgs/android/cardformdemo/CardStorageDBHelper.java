package com.vgs.android.cardformdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//A class to manage our local SQLite Database
public class CardStorageDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "vgs-cardform-demo.db";

    public CardStorageDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + "CARDS" + " (" +
                    "CARDS_COLUMN_NAME_ID" + " INTEGER PRIMARY KEY," +
                    "CARDS_COLUMN_NAME_CARDIDENTIFIER" + " TEXT," +
                    "CARDS_COLUMN_NAME_CARDTYPE" + " TEXT," +
                    "CARDS_COLUMN_NAME_CCN" + " TEXT," +
                    "CARDS_COLUMN_NAME_CVV" + " TEXT," +
                    "CARDS_COLUMN_NAME_MONTH" + " TEXT," +
                    "CARDS_COLUMN_NAME_YEAR" + " TEXT," +
                    "CARDS_COLUMN_POST_CODE" + " TEXT," +
                    "CARDS_COLUMN_COUNTRYCOE" + " TEXT," +
                    "CARDS_COLUMN_NAME_MOBILE" + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + "CARDS";

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}