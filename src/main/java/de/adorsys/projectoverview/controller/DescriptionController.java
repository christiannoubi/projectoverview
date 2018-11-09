package de.adorsys.projectoverview.controller;
import de.adorsys.projectoverview.domain.Description;
import de.adorsys.projectoverview.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/description")
@CrossOrigin(origins = "http://localhost:4200")
public class DescriptionController {

    @Autowired
    DescriptionService descriptionService;

    //-------------------------liste of Description-------------------------
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getAllDescriptions(){
        return new ResponseEntity<Object>(descriptionService.getAllDescriptions(),HttpStatus.OK);
    }
    //-------------------------get a single  Description-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Optional<Description>>getSingleDescription (@PathVariable Long id) {
        return new ResponseEntity<>(descriptionService.getSingleDescription(id), HttpStatus.OK);
    }
    //-------------------------delete a Description-------------------------
    @RequestMapping(value = "/id",method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteDescription (@PathVariable Long id){
        Optional<Description> description = descriptionService.findById(id);
        if(!description.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        descriptionService.deleteDescription (id);
        return new ResponseEntity<Object>(descriptionService.getAllDescriptions(), HttpStatus.OK);
    }
    //---------------------------save or add Description---------------------
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save (@RequestBody Description description){
        descriptionService.save(description);
        return new ResponseEntity<Object>(descriptionService.getAllDescriptions(), HttpStatus.OK);
    }
    //----------------------------update a Description-----------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Description> updateDescription (@PathVariable("id")Long id, @RequestBody Description description){
        Description updated = descriptionService.updateDescription(id, description);
        return  new ResponseEntity<>(updated,HttpStatus.OK);
    }
}
