package de.adorsys.projectoverview.controller;

import de.adorsys.projectoverview.domain.Employee;
import de.adorsys.projectoverview.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeService;


    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<Object>(employeService.getAllEmployees(), HttpStatus.OK);
    }


    @RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployees(@PathVariable Long id){
        Optional<Employee> employee = employeService.findById(id  );
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeService.deleteEmployees(id);
        return  new ResponseEntity<Object>(employeService.getAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "saveEmployee", method = RequestMethod.POST)
    public ResponseEntity <?>save(@RequestBody Employee employee) {
        employeService.save(employee);

        return  new ResponseEntity<Object>(employeService.getAllEmployees(), HttpStatus.OK);
    }
}



