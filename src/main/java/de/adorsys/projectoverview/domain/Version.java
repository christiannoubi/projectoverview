package de.adorsys.projectoverview.domain;

import java.util.List;

public class Version {

    private String title;
    private List <Description> description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }
}