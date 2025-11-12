package com.example.demo.dao;

import com.example.demo.dto.EmployeeRequest;

public interface EmployeeDao {

    Integer createEmployee(EmployeeRequest employeeRequest);
}
