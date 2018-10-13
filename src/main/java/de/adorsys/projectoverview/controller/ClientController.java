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

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }
    //-------------------------delete a Client-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        Optional<Client> client = clientService.findById(id  );
        if (!client.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clientService.deleteClients(id);
        return  new ResponseEntity<>(HttpStatus.GONE);
    }
    //------------------------save or add a Client-----------------------

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        clientService.save(client);

        return  new ResponseEntity<>(client, HttpStatus.OK);
    }
    // ------------------------update a Client-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {

        Client updated = clientService.updateClient(id, client);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}

