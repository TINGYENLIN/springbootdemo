package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;


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

    // 取得所有會員列表 (返回 JSON 格式)
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> orders = orderService.getAllOrder();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
}
