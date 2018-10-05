package de.adorsys.projectoverview.domain;

import java.util.Date;
import java.time.ZonedDateTime;

public class Description {

    private Date calenderWeeks;
    private ZonedDateTime time;
    private double budget;
    private String quality;

    public Description() {
    }

    public Description(Date calenderWeeks, ZonedDateTime time, double budget, String quality) {
        this.calenderWeeks = calenderWeeks;
        this.time = time;
        this.budget = budget;
        this.quality = quality;
    }

    public Date getCalenderWeeks() {
        return calenderWeeks;
    }

    public void setCalenderWeeks(Date calenderWeeks) {
        this.calenderWeeks = calenderWeeks;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
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
