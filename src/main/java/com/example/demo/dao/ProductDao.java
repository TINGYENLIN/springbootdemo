package com.example.demo.dao;

import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Product;


public interface ProductDao {

    Product getProductById(String productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(String productId, ProductRequest productRequest);

    void deleteProductById(String productId);
}
