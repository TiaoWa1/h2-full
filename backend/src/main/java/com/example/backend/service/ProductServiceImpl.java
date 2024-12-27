package com.example.backend.service;

import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    // 透過 AuotoWired 自動做操作綁定資料庫
    @Autowired
    private ProductRepository productRepository;

    // public 公用函數，別人才能呼叫使用
    // ProductService 宣告的函數是空的，所以我們需要覆寫
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}