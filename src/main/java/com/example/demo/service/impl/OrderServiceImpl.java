package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderRequest;
import com.example.demo.service.OrderService;


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
}
