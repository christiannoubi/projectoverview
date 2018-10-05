package de.adorsys.projectoverview.repository;

import de.adorsys.projectoverview.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
