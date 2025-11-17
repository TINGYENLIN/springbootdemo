package com.example.demo.rowmapper;

import com.example.demo.model.Order;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    @NonNull
    public Order mapRow(@NonNull ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();    

        order.setOrderId(resultSet.getInt("idorders"));
        order.setMemberId(resultSet.getInt("memberID"));
        order.setMemberName(resultSet.getString("customerName"));
        order.setMemberPhone(resultSet.getString("customerPhone"));
        order.setProductId(resultSet.getInt("productID"));
        order.setPlan(resultSet.getString("plan"));
        order.setPrice(resultSet.getInt("price"));
        order.setEmployeeId(resultSet.getInt("employeeID"));
        order.setEmployeeName(resultSet.getString("employeeName"));
        order.setMemberCreditcard(resultSet.getString("Credit Card Number"));
        order.setOrderDate(resultSet.getDate("orderDate"));
        order.setStatus(resultSet.getString("status"));

        return order;
    }
}
