package de.adorsys.projectoverview.controller;
import de.adorsys.projectoverview.domain.Version;
import de.adorsys.projectoverview.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/version")
@CrossOrigin(origins = "http://localhost:4200")
public class VersionController {
    @Autowired
    VersionService versionService;

    @GetMapping
    //-------------------------get all Version-------------------------------
    public ResponseEntity<List<Version>>getAllVersions(){
        return new ResponseEntity<>(versionService.getAllVersions(),HttpStatus.OK);
    }
    //-------------------------get a single Version-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Version>> getSingleVersion (@PathVariable Long id){
        return new ResponseEntity<>(versionService.getSingleVersion(id),HttpStatus.OK);
    }
    //-------------------------delete a Version-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVersion(@PathVariable Long id){
        Optional<Version> version = versionService.findById(id  );
        if (!version.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        versionService.deleteVersions(id);
        return  new ResponseEntity<>(HttpStatus.GONE);
    }
    //------------------------save or add a Version-----------------------
    @RequestMapping(value = "/versions", method = RequestMethod.POST)
    public ResponseEntity<Version> saveVersion(@RequestBody Version version) {
        versionService.save(version);
        return  new ResponseEntity<>(version, HttpStatus.OK);
    }
    // ------------------------update a Version-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Version> updateVersion(@PathVariable("id") Long id, @RequestBody Version version) {
        Version updated = versionService.updateVersion(id, version);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
