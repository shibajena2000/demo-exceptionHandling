package com.demo.exceptionhandler.controller;

import com.demo.exceptionhandler.exception.ResourceNotFoundException;
import com.demo.exceptionhandler.model.Employee;
import com.demo.exceptionhandler.repository.PostGreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1")
public class PostGreSqlController {
    @Autowired
    PostGreRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with::" + id));
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createNewEmployeeId(@RequestBody Employee emp) {
        employeeRepository.save(emp);
        return ResponseEntity.ok(emp);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        if (employeeRepository.existsById(emp.getId())) {
            employeeRepository.save(emp);
        } else {
            employeeRepository.save(emp);

        }
        return ResponseEntity.ok(emp);
    }
}


