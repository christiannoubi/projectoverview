package de.adorsys.projectoverview.service;
import de.adorsys.projectoverview.domain.Employee;
import de.adorsys.projectoverview.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee>getSingleEmployee (Long id) {
        return employeeRepository.findById(id);
    }
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee (Long id){
        Employee employee = employeeRepository.findById(id).orElse(new Employee());
        employeeRepository.delete(employee);
    }
    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }
    public Employee updateEmployee (Long id, Employee employee) {
        Optional<Employee> entity = findById(id);
        if (!entity.isPresent()) {
            throw new RuntimeException("Unable to update. User with id " + id + " not found.");
        }
        Employee employeeEntity = entity.get();
        employeeEntity.setName(employee.getName());
        employeeEntity.setAddress(employee.getAddress());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setAbbreviation(employee.getAbbreviation());
        employeeRepository.save(employeeEntity);
        return employeeEntity;
    }
}
