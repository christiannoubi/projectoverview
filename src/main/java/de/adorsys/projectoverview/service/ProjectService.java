package de.adorsys.projectoverview.service;

import de.adorsys.projectoverview.domain.Project;
import de.adorsys.projectoverview.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProjects (Long id){

        Project project = projectRepository.findById(id).orElse(new Project());
        projectRepository.delete(project);
    }
    public Optional<Project> findById(Long id){
        return projectRepository.findById(id);
    }
    public Project updateProject(Long id, Project project) {
        Optional<Project> entity = findById(id);

        if (!entity.isPresent()) {
            throw new RuntimeException("Unable to update. User with id " + id + " not found.");
        }
        Project projectEntity = entity.get();
        projectEntity.setDeveloper(project.getDeveloper());
        projectEntity.setDevOps(project.getDevOps());
        projectEntity.setProjectManager(project.getProjectManager());
        projectEntity.setProjectOwner(project.getProjectOwner());
        projectEntity.setScrumMaster(project.getScrumMaster());
        projectEntity.setTechnicalLead(project.getTechnicalLead());

        projectRepository.save(projectEntity);
        return projectEntity;
    }
}
