package com.optum.statistics.model;

public class DataPoint {
    private double value;
    private String timePeriod;

    public DataPoint(double value, String timePeriod) {
        this.value = value;
        this.timePeriod = timePeriod;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }
}

