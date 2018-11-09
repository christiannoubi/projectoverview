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

    public Optional <Description> getSingleDescription (Long id) {
        return descriptionRepository.findById(id);
    }
    public Description save(Description description){
        return descriptionRepository.save(description);
    }

    public void deleteDescription ( Long id){
        Description description = descriptionRepository.findById(id).orElse(new Description());
        descriptionRepository.delete(description);
    }
    public Optional<Description>findById(Long id){
        return descriptionRepository.findById(id);
    }
    public Description updateDescription(Long id, Description description){
        Optional<Description> entity = findById(id);
        if(!entity.isPresent()){
            throw new RuntimeException("Unable to update.User with id"+ id + "not found.");
        }
        Description descriptionEntity = entity.get();
        descriptionEntity.setBudget(description.getBudget());
        descriptionEntity.setCalenderWeeks(description.getCalenderWeeks());
        descriptionEntity.setQuality(description.getQuality());
        descriptionEntity.setTime(description.getTime());
        descriptionRepository.save(descriptionEntity);
        return descriptionEntity;
    }
}
