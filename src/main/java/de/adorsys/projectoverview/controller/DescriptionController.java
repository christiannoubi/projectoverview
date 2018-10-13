package de.adorsys.projectoverview.controller;

import de.adorsys.projectoverview.domain.Description;
import de.adorsys.projectoverview.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/description")
public class DescriptionController {

    @Autowired
    DescriptionService descriptionService;

    @GetMapping
    public ResponseEntity<List<Description>> getAllDescriptions(){
        return new ResponseEntity<>(descriptionService.getAllDescriptions(),HttpStatus.OK);
    }
    //-------------------------delete a Description-------------------------
    @RequestMapping(value = "/id",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDescription(@PathVariable Long id){
        Optional<Description> description = descriptionService.findById(id);
        if(!description.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        descriptionService.deleteDescriptions(id);
        return new ResponseEntity<Void>(HttpStatus.GONE);
    }
    //---------------------------save or add Description---------------------
    @RequestMapping(value = "/descriptions",method = RequestMethod.POST)
    public ResponseEntity<Description> saveDescription(@RequestBody Description description){
        descriptionService.save(description);
        return new ResponseEntity<>(description, HttpStatus.OK);
    }
    //----------------------------update a Description-----------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Description> updateDescription(@PathVariable("id")Long id, @RequestBody Description description){
        Description updated = descriptionService.updateDescription(id, description);
        return  new ResponseEntity<>(updated,HttpStatus.OK);
    }
}
