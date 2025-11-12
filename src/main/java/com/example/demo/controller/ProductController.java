package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")  // 路徑開頭統一，例如 /products
public class ProductController {

    @Autowired
    private ProductService productService;

    
    // 1.查詢單筆商品
    // GET /products/{productId}
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 2.新增商品
    // POST /products
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
