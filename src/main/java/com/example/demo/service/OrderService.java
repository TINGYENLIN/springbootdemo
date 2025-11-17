package com.example.demo.service;

import com.example.demo.dto.OrderRequest;

public interface OrderService {

    Integer createOrder(OrderRequest orderRequest);
}