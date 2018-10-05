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

    public List<Client> getAllEmployees() {
        return clientRepository.findAll();
    }

    public Client save(Client employee) {
        return clientRepository.save(employee);
    }

    public void deleteEmployees (Long id){

        Client employee = clientRepository.findById(id).orElse(new Client());
        clientRepository.delete(employee);
    }
    public Optional<Client> findById(Long id){
        Optional<Client> employee = clientRepository.findById(id);
        return employee;
    }
}
