package de.adorsys.projectoverview.repository;
import de.adorsys.projectoverview.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
