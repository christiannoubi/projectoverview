package de.adorsys.projectoverview.domain;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode @ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client projectOwner;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Employee> projectManager = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    private Set <Employee> scrumMaster = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    private Set <Employee> technicalLead = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    private Set <Employee> developer = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    private Set <Employee> devOps = new HashSet<>();

    public Project() {
    }
   /* public Project(Client projectOwner, Set<Employee> projectManager, Set<Employee> scrumMaster, Set<Employee> technicalLead, Set<Employee> developer, Set<Employee> devOps) {
        this.projectOwner = projectOwner;
        this.projectManager = projectManager;
        this.scrumMaster = scrumMaster;
        this.technicalLead = technicalLead;
        this.developer = developer;
        this.devOps = devOps;
    }*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(Client projectOwner) {
        this.projectOwner = projectOwner;
    }

    public Set<Employee> getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Set<Employee> projectManager) {
        this.projectManager = projectManager;
    }

    public Set<Employee> getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(Set<Employee> scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public Set<Employee> getTechnicalLead() {
        return technicalLead;
    }

    public void setTechnicalLead(Set<Employee> technicalLead) {
        this.technicalLead = technicalLead;
    }

    public Set<Employee> getDeveloper() {
        return developer;
    }

    public void setDeveloper(Set<Employee> developer) {
        this.developer = developer;
    }

    public Set<Employee> getDevOps() {
        return devOps;
    }

    public void setDevOps(Set<Employee> devOps) {
        this.devOps = devOps;
    }
}
