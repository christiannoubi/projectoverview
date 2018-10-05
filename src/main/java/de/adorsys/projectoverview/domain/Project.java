package de.adorsys.projectoverview.domain;

import java.util.List;

public class Project {

    private Client projectOwner;
    private List <Employee> projectManager;
    private List <Employee> scrumMaster;
    private List <Employee> technicalLead;
    private List <Employee> developer;
    private List <Employee> devOps;

    public Project() {
    }

    public Project(Client projectOwner, List<Employee> projectManager, List<Employee> scrumMaster, List<Employee> technicalLead, List<Employee> developer, List<Employee> devOps) {
        this.projectOwner = projectOwner;
        this.projectManager = projectManager;
        this.scrumMaster = scrumMaster;
        this.technicalLead = technicalLead;
        this.developer = developer;
        this.devOps = devOps;
    }

    public Client getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(Client projectOwner) {
        this.projectOwner = projectOwner;
    }

    public List<Employee> getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(List<Employee> projectManager) {
        this.projectManager = projectManager;
    }

    public List<Employee> getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(List<Employee> scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public List<Employee> getTechnicalLead() {
        return technicalLead;
    }

    public void setTechnicalLead(List<Employee> technicalLead) {
        this.technicalLead = technicalLead;
    }

    public List<Employee> getDeveloper() {
        return developer;
    }

    public void setDeveloper(List<Employee> developer) {
        this.developer = developer;
    }

    public List<Employee> getDevOps() {
        return devOps;
    }

    public void setDevOps(List<Employee> devOps) {
        this.devOps = devOps;
    }
}
