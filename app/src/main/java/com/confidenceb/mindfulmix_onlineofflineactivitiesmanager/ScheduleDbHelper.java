package com.confidenceb.mindfulmix_onlineofflineactivitiesmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schedule.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "schedule";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_EVENT_NAME = "event_name";
    private static final String COLUMN_EVENT_TIME = "event_time";

    public ScheduleDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_SCHEDULE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EVENT_NAME + " TEXT NOT NULL, "
                + COLUMN_EVENT_TIME + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_SCHEDULE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertSchedule(String eventName, String eventTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EVENT_NAME, eventName);
        values.put(COLUMN_EVENT_TIME, eventTime);
        long newRowId = db.insert(TABLE_NAME, null, values);
    }

    public List<ScheduleItem> getAllSchedules() {
        List<ScheduleItem> scheduleList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_EVENT_NAME, COLUMN_EVENT_TIME}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String eventName = cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_NAME));
                String eventTime = cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_TIME));
                scheduleList.add(new ScheduleItem(id, eventName, eventTime));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return scheduleList;
    }
}

