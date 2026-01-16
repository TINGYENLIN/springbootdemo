package com.example.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Product;
import com.example.demo.rowmapper.ProductRowMapper;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

      
    // 1.查詢全部資料

    @Override
    public List<Product> getAllProduct() {
        String sql = "SELECT idproduct, distance, length, weight, price, note FROM product2";
        Map<String, Object> map = new HashMap<>();
        return namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
    }

    @Override
    public Product getProductById(String productId) {
        String sql = "SELECT idproduct, distance, length, weight, price, note FROM product2 WHERE idproduct = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> list = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        return list.isEmpty() ? null : list.get(0);
    }

    
    // 2.新增資料
    
    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product2 (distance, length, weight, price, note) "
                   + "VALUES (:distance, :length, :weight, :price, :note)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("distance", productRequest.getDistance());
        params.addValue("length", productRequest.getLength());
        params.addValue("weight", productRequest.getWeight());
        params.addValue("price", productRequest.getPrice());
        params.addValue("note", productRequest.getNote());

        namedParameterJdbcTemplate.update(sql, params);

        // 回傳新資料的自動編號（如果你的 idproduct2 是 AUTO_INCREMENT 的話）
        Integer newId = namedParameterJdbcTemplate.getJdbcTemplate()
                .queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return newId;
    }

    
    // 3.更新資料
    
    @Override
    public void updateProduct(String productId, ProductRequest productRequest) {
        String sql = "UPDATE product2 SET "
                   + "distance = :distance, "
                   + "length = :length, "
                   + "weight = :weight, "
                   + "price = :price, "
                   + "note = :note "
                   + "WHERE idproduct = :productId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("distance", productRequest.getDistance());
        params.addValue("length", productRequest.getLength());
        params.addValue("weight", productRequest.getWeight());
        params.addValue("price", productRequest.getPrice());
        params.addValue("note", productRequest.getNote());
        params.addValue("productId", productId);

        namedParameterJdbcTemplate.update(sql, params);
    }


    // 4.刪除資料

    @Override
    public void deleteProductById(String productId) {
        String sql = "DELETE FROM product2 WHERE idproduct = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}