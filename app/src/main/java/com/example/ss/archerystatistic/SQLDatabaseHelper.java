package com.example.ss.archerystatistic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by SS on 03.11.2014.
 */
public class SQLDatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_PERSON = "Person";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_AGE = "Age";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_DATE_CREATED = "DateCreated";
    public static final String COLUMN_DATE_UPDATED = "DateUpdated";

    private static final String DATABASE_NAME = "archery.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_PERSON + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null, "
            + COLUMN_AGE + " integer not null, "
            + COLUMN_EMAIL + " text null, "
            + COLUMN_DATE_CREATED + " text not null, "
            + COLUMN_DATE_UPDATED + " text not null"
            + ");";

    public SQLDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SQLDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);
    }

}
