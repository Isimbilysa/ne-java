package com.example.demo.Services;

import com.example.demo.Classes.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ProductService {
        @Autowired
        private ProductRepository productRepository;

        public void registerProduct(Product product) {
            productRepository.save(product);
        }

        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

    public Product addProduct(Product product) {
        return null;
    }

    public Optional <Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Product product) {
        return product;
    }

    public void deleteProduct(Long id) {
    }
}
