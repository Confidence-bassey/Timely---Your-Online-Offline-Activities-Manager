package com.confidenceb.mindfulmix_onlineofflineactivitiesmanager;

public class ScheduleItem {

    private int id;
    private String eventName;
    private String eventTime;

    // Constructor, getters, and setters
    public ScheduleItem() {
    }

    public ScheduleItem(int id, String eventName, String eventTime) {
        this.id = id;
        this.eventName = eventName;
        this.eventTime = eventTime;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
