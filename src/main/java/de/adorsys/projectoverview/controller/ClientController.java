package de.adorsys.projectoverview.controller;
import de.adorsys.projectoverview.domain.Client;
import de.adorsys.projectoverview.domain.Employee;
import de.adorsys.projectoverview.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;


    @GetMapping
    public ResponseEntity<?> getAllClients() {
        return new ResponseEntity<Object>(clientService.getAllClients(), HttpStatus.OK);
    }
    //-------------------------delete a Employee-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClients(@PathVariable Long id){
        Optional<Client> client = clientService.findById(id  );
        if (!client.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clientService.deleteClients(id);
        return  new ResponseEntity<Object>(clientService.getAllClients(), HttpStatus.OK);
    }
    //------------------------save or add a Employee-----------------------

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity <?>save(@RequestBody Client client) {
        clientService.save(client);

        return  new ResponseEntity<Object>(clientService.getAllClients(), HttpStatus.OK);
    }
    // ------------------------update a Employee-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {

        Client updated = clientService.updateClient(id, client);
        return new ResponseEntity<Client>(updated, HttpStatus.OK);
    }
}

