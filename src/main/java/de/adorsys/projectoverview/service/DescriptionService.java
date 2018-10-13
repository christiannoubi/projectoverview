package de.adorsys.projectoverview.service;


import de.adorsys.projectoverview.domain.Description;
import de.adorsys.projectoverview.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescriptionService {

    @Autowired
    DescriptionRepository descriptionRepository;

    public List<Description> getAllDescriptions(){
        return descriptionRepository.findAll();
    }

    public Description save(Description description){
        return descriptionRepository.save(description);
    }

    public void deleteDescriptions( Long id){
        Description description = descriptionRepository.findById(id).orElse(new Description());
        descriptionRepository.delete(description);
    }
    public Optional<Description>findById(Long id){
        return descriptionRepository.findById(id);
    }
}
