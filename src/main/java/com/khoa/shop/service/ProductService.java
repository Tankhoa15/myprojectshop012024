package com.khoa.shop.service;

import com.khoa.shop.entity.ProductEntity;
import com.khoa.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

   @Autowired
   ProductRepository productRepository;

    public List<ProductEntity> findAll() {
         return productRepository.findAll();
    }

    //create product
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    // update product
    public ProductEntity updateProduct(ProductEntity product) throws Exception {
        return productRepository.findById(product.getId())
                .map(existingProduct -> productRepository.save(product))
                .orElseThrow(() -> new Exception("Product not found with id: " + product.getId()));
    }

    //delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
