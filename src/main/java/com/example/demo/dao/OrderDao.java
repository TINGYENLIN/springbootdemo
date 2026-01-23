package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;

public interface OrderDao {

    Integer createOrder(OrderRequest orderRequest);
    
    List<Order> getAllOrder();
    
    void updateOrder(Integer orderId, OrderRequest orderRequest);
}
