package com.confidenceb.mindfulmix_onlineofflineactivitiesmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScreenTimeDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "screen_time.db";
    private static final int DATABASE_VERSION = 1;

    // Define your table and columns
    private static final String TABLE_NAME = "usage_data";
    private static final String COLUMN_APP_NAME = "app_name";
    private static final String COLUMN_USAGE_TIME = "usage_time";

    public ScreenTimeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_APP_NAME + " TEXT NOT NULL, " +
                COLUMN_USAGE_TIME + " INTEGER NOT NULL)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades (if needed)
        // For simplicity, drop and recreate the table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Add methods for CRUD operations (insert, query, update, delete)
    // Example: insertUsageData, getUsageData, updateUsageData, deleteUsageData
}
