package tech.getarrays.employeemanager.controller;

import tech.getarrays.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @PostMapping(path = "/find/{id}")
    public ResponseEntity<Employee> find(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.findEmployeeById(id),HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
