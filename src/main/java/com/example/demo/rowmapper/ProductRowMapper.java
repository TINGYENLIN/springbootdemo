package com.example.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import com.example.demo.model.Product;


public class ProductRowMapper implements RowMapper<Product> {

    @Override
    @NonNull
    public Product mapRow(@NonNull ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getString("idproduct"));
        product.setDistance(resultSet.getString("distance"));
        product.setLength(resultSet.getString("length"));
        product.setWeight(resultSet.getString("weight"));
        product.setPrice(resultSet.getInt("price"));
        product.setNote(resultSet.getString("note"));

        return product;
    }
}
