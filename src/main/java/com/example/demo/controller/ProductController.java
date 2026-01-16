package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/products")  // 路徑開頭統一，例如 /products
public class ProductController {

    @Autowired
    private ProductService productService;

    
    // 1.查詢單筆商品
    // 取得所有商品列表 (返回 JSON 格式)
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
    System.out.println(">>> getAllProduct 被呼叫了");
    List<Product> products = productService.getAllProduct();
    return ResponseEntity.ok(products);
    }

    // 2.新增商品
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product created with ID: " + productId);
    }

    // 3.更新商品
    // PUT /products/{productId}
    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(
            @PathVariable String productId,
            @RequestBody ProductRequest productRequest) {

        Product existing = productService.getProductById(productId);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        productService.updateProduct(productId, productRequest);
        return ResponseEntity.ok("Product updated successfully.");
    }

    // 4.刪除商品
    // DELETE /products/{productId}
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
        Product existing = productService.getProductById(productId);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        productService.deleteProductById(productId);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
