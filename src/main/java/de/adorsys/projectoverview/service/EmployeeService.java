package de.adorsys.projectoverview.service;

import de.adorsys.projectoverview.domain.Employee;
import de.adorsys.projectoverview.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployees (Long id){

        Employee employee = employeeRepository.findById(id).orElse(new Employee());
        employeeRepository.delete(employee);
    }
    public Optional<Employee> findById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }
}
