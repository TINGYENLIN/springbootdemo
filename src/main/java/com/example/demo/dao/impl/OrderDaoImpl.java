package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;
import com.example.demo.rowmapper.OrderRowMapper;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createOrder(OrderRequest orderRequest) {
        String sql = "INSERT INTO orders (idorders, memberID, customerName, customerPhone, productID, plan, price, employeeID, employeeName, Credit_Card_Number, Date_Time, status) "
                   + "VALUES (:idorders, :memberID, :customerName, :customerPhone, :productID, :plan, :price, :employeeID, :employeeName, :Credit_Card_Number, :Date_Time, :status)";
    
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idorders", orderRequest.getOrderId());
        params.addValue("memberID", orderRequest.getMemberId());
        params.addValue("customerName", orderRequest.getMemberName());
        params.addValue("customerPhone", orderRequest.getMemberPhone());
        params.addValue("productID", orderRequest.getProductId());
        params.addValue("plan", orderRequest.getPlan());
        params.addValue("price", orderRequest.getPrice());
        params.addValue("employeeID", orderRequest.getEmployeeId());
        params.addValue("employeeName", orderRequest.getEmployeeName());
        params.addValue("Credit_Card_Number", orderRequest.getMemberCreditcard());
        params.addValue("Date_Time", orderRequest.getOrderDate());
        params.addValue("status", "active");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, params, keyHolder);
        Number key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Failed to retrieve generated key for order");
        }
        return key.intValue();
        }

     @Override
    public List<Order> getAllOrder() {
        String sql = "SELECT idorders, memberID, customerName, customerPhone, productID, plan, price, employeeID, employeeName, Credit_Card_Number, Date_Time, status FROM orders";

        return namedParameterJdbcTemplate.query(sql, new OrderRowMapper());
    }
}