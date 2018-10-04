package de.adorsys.projectoverview.domain;

import java.util.Date;
import java.util.Timer;

public class Description {

    private Date calenderWeeks;
    private Timer time;
    private double budget;
    private String quality;

    public Date getCalenderWeeks() {
        return calenderWeeks;
    }

    public void setCalenderWeeks(Date calenderWeeks) {
        this.calenderWeeks = calenderWeeks;
    }

    public Timer getTime() {
        return time;
    }

    public void setTime(Timer time) {
        this.time = time;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
