package de.adorsys.projectoverview.controller;

import de.adorsys.projectoverview.domain.Project;
import de.adorsys.projectoverview.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }
    //-------------------------delete a Project-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        Optional<Project> client = projectService.findById(id  );
        if (!client.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        projectService.deleteProjects(id);
        return  new ResponseEntity<>(HttpStatus.GONE);
    }
    //------------------------save or add a Project-----------------------

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public ResponseEntity<Project> saveProject(@RequestBody Project project) {
        projectService.save(project);

        return  new ResponseEntity<>(project, HttpStatus.OK);
    }
    // ------------------------update a Project-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {

        Project updated = projectService.updateProject(id, project);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
