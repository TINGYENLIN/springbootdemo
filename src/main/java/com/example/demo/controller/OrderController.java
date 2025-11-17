package com.example.demo.controller;

import com.example.demo.dto.OrderRequest;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*") // 允許所有來源
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 新增訂單
    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        Integer orderId = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Member created with ID: " + orderId);
    }

    @GetMapping("/orders")
    public String test() {
        return "API OK";
    }   

}
