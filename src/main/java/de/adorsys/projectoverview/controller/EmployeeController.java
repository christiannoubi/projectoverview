package de.adorsys.projectoverview.controller;
import de.adorsys.projectoverview.domain.Employee;
import de.adorsys.projectoverview.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<Object>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    //-------------------------get a single Employee-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Optional<Employee>>getSingleEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getSingleEmployee(id), HttpStatus.OK);
    }
    //-------------------------delete a Employee-------------------------
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployees(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployees(id);
        return  new ResponseEntity<Object>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    //------------------------save or add a Employee-----------------------
    @RequestMapping( method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity <?>save(@RequestBody Employee employee) {
        employeeService.save(employee);

        return  new ResponseEntity<Object>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    // ------------------------update a Employee-------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {

        Employee updated = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<Employee>(updated, HttpStatus.OK);
    }
}



