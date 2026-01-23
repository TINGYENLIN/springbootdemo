package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public Integer createOrder(OrderRequest orderRequest) {
        return orderDao.createOrder(orderRequest);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    public void updateOrder(Integer orderId, OrderRequest orderRequest) {
        orderDao.updateOrder(orderId, orderRequest);
    }
}
