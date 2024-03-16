package com.confidenceb.mindfulmix_onlineofflineactivitiesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SchedulerGenerator extends AppCompatActivity {

    EditText editTextSchedule;
    TextView textViewSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler_generator);

        editTextSchedule = findViewById(R.id.editTextSchedule);
        textViewSchedule = findViewById(R.id.textViewSchedule);
    }

    ScheduleDbHelper dbHelper = new ScheduleDbHelper(this);

    public void generateSchedule(View view) {
        String scheduleText = editTextSchedule.getText().toString();
        String[] events = scheduleText.split(";");
        StringBuilder scheduleBuilder = new StringBuilder();
        for (String event : events) {
            String[] details = event.split(",");
            String eventName = details[0].split(":")[1].trim();
            String eventTime = details[1].split(":")[1].trim();
            scheduleBuilder.append(eventTime).append(" - ").append(eventName).append("\n");

            // Insert event into the database
            dbHelper.insertSchedule(eventName, eventTime);
        }
        textViewSchedule.setText(scheduleBuilder.toString());
    }
}