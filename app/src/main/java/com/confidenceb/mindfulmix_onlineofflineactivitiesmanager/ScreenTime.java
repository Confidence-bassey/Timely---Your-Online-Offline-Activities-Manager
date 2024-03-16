package com.confidenceb.mindfulmix_onlineofflineactivitiesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ScreenTime extends AppCompatActivity {

    private ScreenTimeDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_time);

        dbHelper = new ScreenTimeDbHelper(this);

    }

}

