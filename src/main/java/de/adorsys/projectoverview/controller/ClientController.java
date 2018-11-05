package de.adorsys.projectoverview.controller;
import java.util.List;
import de.adorsys.projectoverview.domain.Client;
import de.adorsys.projectoverview.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    ClientService clientService;
    //------------------------liste of employee-------------------------
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }
    //-------------------------add a single  Client--------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Optional<Client>>getSingleClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getSingleClient(id), HttpStatus.OK);
    }
    //-------------------------delete a Client-------------------------
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClients(@PathVariable Long id){
        Optional<Client> client = clientService.findById(id  );
        if (!client.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clientService.deleteClients(id);
        return  new ResponseEntity<Object>(clientService.getAllClients(), HttpStatus.OK);
    }
    //------------------------save or add a Client-----------------------
    @RequestMapping( method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        clientService.save(client);

        return  new ResponseEntity<Object>(clientService.getAllClients(), HttpStatus.OK);
    }
    // ------------------------update a Client-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {

        Client updated = clientService.updateClient(id, client);
        return new ResponseEntity<Client>(updated, HttpStatus.OK);
    }
}

