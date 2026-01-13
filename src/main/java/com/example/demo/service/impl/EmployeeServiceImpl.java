package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public Integer createEmployee(EmployeeRequest employeeRequest) {
        return employeeDao.createEmployee(employeeRequest);
    }
    
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}