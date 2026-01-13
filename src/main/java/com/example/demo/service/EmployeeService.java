package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.model.Employee;

public interface EmployeeService {

    Integer createEmployee(EmployeeRequest employeeRequest);
    Employee getEmployeeById(Integer employeeId);
    List<Employee> getAllEmployees();
}