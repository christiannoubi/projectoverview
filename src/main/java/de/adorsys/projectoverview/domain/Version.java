package de.adorsys.projectoverview.domain;

import java.util.Set;
import javax.persistence.*;
@Entity
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set <Description> description;

    public Version() {
    }

    public Version(String title, Set<Description> description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Description> getDescription() {
        return description;
    }

    public void setDescription(Set<Description> description) {
        this.description = description;
    }
}
