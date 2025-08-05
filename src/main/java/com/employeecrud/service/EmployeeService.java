package com.employeecrud.service;

import com.employeecrud.doa.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);


    Optional<Employee> findById(int empId);

    List<Employee> findall();

    Employee update(Employee employee);

    void deleteById(int empId);

}
