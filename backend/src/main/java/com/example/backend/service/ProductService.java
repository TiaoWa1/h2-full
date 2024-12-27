package com.example.backend.service;

import com.example.backend.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id); // 查(撈可能沒有撈到，所以用Optional)
    Product saveProduct(Product product); // 增
    Product updateProduct(Product product); // 改
    void deleteProduct(Long id); // 刪
}