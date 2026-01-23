package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;

public interface OrderService {

    Integer createOrder(OrderRequest orderRequest);
    
    List<Order> getAllOrder();

    void updateOrder(Integer orderId, OrderRequest orderRequest);
}