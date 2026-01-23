package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.model.Employee;

public interface EmployeeDao {

    Integer createEmployee(EmployeeRequest employeeRequest);
    
    Employee getEmployeeById(Integer employeeId);
    
    List<Employee> getAllEmployees();

    void updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
}

