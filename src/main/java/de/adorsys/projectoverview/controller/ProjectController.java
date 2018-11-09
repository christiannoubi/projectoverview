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

    //--------------------------liste of Project------------------------
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }
    //--------------------------get a single project--------------------
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Optional<Project>> getSingleProject (@PathVariable Long id){
        return new ResponseEntity<>(projectService.getSingleProject(id), HttpStatus.OK);
    }
    //-------------------------delete a Project-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteProject (@PathVariable Long id){
        Optional<Project> client = projectService.findById(id  );
        if (!client.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        projectService.deleteProject (id);
        return  new ResponseEntity<Object>(projectService.getAllProjects(), HttpStatus.OK);
    }
    //------------------------save or add a Project-----------------------
    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> save(@RequestBody Project project) {
        projectService.save(project);
        return  new ResponseEntity<Object>(projectService.getAllProjects(), HttpStatus.OK);
    }
    // ------------------------update a Project-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        Project updated = projectService.updateProject(id, project);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
