package com.example.demo.dao;

import com.example.demo.dto.ProductQueryParams;
import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(String productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(String productId, ProductRequest productRequest);

    void deleteProductById(String productId);
}
