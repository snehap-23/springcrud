package com.employeecrud.controller;

import com.employeecrud.doa.Employee;
import com.employeecrud.exception.RecordNotFoundException;
import com.employeecrud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    /*@Autowired
    Employee employee;*/

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeService.findById(empId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findall());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {

        Employee employee1 = employeeService.findById(empId).orElseThrow(() -> new RecordNotFoundException("Record not found with selected id"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDesignation(employee.getEmpDesignation());
        return ResponseEntity.ok(employeeService.update(employee1));
    }

    @DeleteMapping("/deleteemployee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId) {
        employeeService.deleteById(empId);
        return ResponseEntity.ok("Data deleted successfully");

    }
}
