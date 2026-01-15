package com.example.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import com.example.demo.model.Order;

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
        order.setMemberCreditcard(resultSet.getString("Credit_Card_Number"));
        order.setOrderDate(resultSet.getDate("Date_Time"));
        order.setStatus(resultSet.getString("status"));

        return order;
    }
}
