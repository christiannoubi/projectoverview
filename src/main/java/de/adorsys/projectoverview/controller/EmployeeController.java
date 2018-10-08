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
    EmployeeService employeeService;

    //--------------------------liste of Employee------------------------
    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<Object>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    //-------------------------delete a Employee-------------------------
    @RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployees(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployees(id);
        return  new ResponseEntity<Object>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    //------------------------save or add a Employee-----------------------
    @RequestMapping(value = "save-employee", method = RequestMethod.POST)
    public ResponseEntity <?>save(@RequestBody Employee employee) {
        employeeService.save(employee);

        return  new ResponseEntity<Object>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    // ------------------------update a Employee-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {

        Employee updated = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<Employee>(updated, HttpStatus.OK);
    }
}



