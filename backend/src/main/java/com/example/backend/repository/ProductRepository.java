package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.model.Product;

@Repository
// interface 表示只是借接，若為 class 需要有屬性、方法
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
