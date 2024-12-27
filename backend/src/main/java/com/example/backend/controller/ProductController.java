package com.example.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.backend.model.Product;
import com.example.backend.service.ProductService;

@RestController
@CrossOrigin("*") // 重要
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService; // 宣告 ProductService 物件

    @GetMapping // 輸入根目錄的話
    public List<Product> getAllProducts() {
        // 經由 productService interface 找到真正的指令(ProductServiceImpl)
        return productService.getAllProducts();
    }

    @GetMapping("/{id}") // 查找指定id的路由 查找用 GET 請求
    public ResponseEntity<Product> getProductById(@PathVariable Long id) { // 用路徑當變數
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(
            () -> ResponseEntity.notFound().build()
        );
    }

    @PostMapping // 新增所以用 POST 請求
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}") // 更新用 PUT 請求
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product productDetail) {
        Optional<Product> product = productService.getProductById(id);
        if(product.isPresent()) {
            Product productNew = product.get();
            productNew.setName(productDetail.getName());
            productNew.setDescription(productDetail.getDescription());
            productNew.setPrice(productDetail.getPrice());
            return ResponseEntity.ok(productService.updateProduct(productNew));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}") // 刪除用 DELETE 請求
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if(product.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
