package de.adorsys.projectoverview.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.time.ZonedDateTime;

@Entity
@EqualsAndHashCode @ToString

public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double budget;
    private String quality;
    private Date calenderWeeks;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private ZonedDateTime time;

    public Description() {
    }

    /*public Description(Date calenderWeeks, ZonedDateTime time, double budget, String quality) {
        this.calenderWeeks = calenderWeeks;
        this.time = time;
        this.budget = budget;
        this.quality = quality;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
