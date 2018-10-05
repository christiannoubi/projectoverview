package de.adorsys.projectoverview.repository;

import de.adorsys.projectoverview.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
