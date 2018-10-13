package de.adorsys.projectoverview.service;

import de.adorsys.projectoverview.domain.Client;
import de.adorsys.projectoverview.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClients (Long id){

        Client client = clientRepository.findById(id).orElse(new Client());
        clientRepository.delete(client);
    }
    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }
    public Client updateClient(Long id, Client client) {
        Optional<Client> entity = findById(id);

        if (!entity.isPresent()) {
            throw new RuntimeException("Unable to update. User with id " + id + " not found.");
        }
        Client clientEntity = entity.get();
        clientEntity.setNameClient(client.getNameClient());
        clientEntity.setAddressClient(client.getAddressClient());
        clientEntity.setEmailClient(client.getEmailClient());


        clientRepository.save(clientEntity);
        return clientEntity;
    }
}
