package de.adorsys.projectoverview.service;
import de.adorsys.projectoverview.domain.Version;
import de.adorsys.projectoverview.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionService {

    @Autowired
    VersionRepository versionRepository;

    public List<Version> getAllVersions(){
        return versionRepository.findAll();
    }

    public Optional<Version> getSingleVersion (Long id){
        return versionRepository.findById(id);
    }
    public Version save(Version version){
        return versionRepository.save(version);
    }

    public void deleteVersions(Long id){
        Version version = versionRepository.findById(id).orElse(new Version());
        versionRepository.delete(version);
    }

    public Optional<Version> findById(Long id){
        return versionRepository.findById(id);
    }

    public Version updateVersion(Long id, Version version){
        Optional<Version> entity = findById(id);
        if (!entity.isPresent()){
            throw new RuntimeException("Unable to update. User with id "+ id + "not found.");
        }
        Version versionEntity = entity.get();
        versionEntity.setDescription(version.getDescription());
        versionEntity.setTitle(version.getTitle());
        versionRepository.save(versionEntity);
        return versionEntity;
    }

}
