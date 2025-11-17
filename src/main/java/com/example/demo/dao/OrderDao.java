package com.example.demo.dao;

import com.example.demo.dto.OrderRequest;

public interface OrderDao {

    Integer createOrder(OrderRequest orderRequest);
}
