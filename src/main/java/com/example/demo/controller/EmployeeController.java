package com.example.demo.controller;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // 新增員工
    @PostMapping("/employeess")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Integer employeeId = employeeService.createEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created with ID: " + employeeId);
    }
}
