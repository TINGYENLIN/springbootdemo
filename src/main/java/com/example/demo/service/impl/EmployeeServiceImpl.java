package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public Integer createEmployee(EmployeeRequest employeeRequest) {
        return employeeDao.createEmployee(employeeRequest);
    }
}