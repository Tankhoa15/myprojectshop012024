package com.khoa.shop.service.Impl;

import com.khoa.shop.entity.ProductEntity;
import com.khoa.shop.repository.ProductRepository;
import com.khoa.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repo;

    @Override
    public List<ProductEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ProductEntity create(ProductEntity product) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setDescription(product.getDescription());
        return repo.save(newProduct);
    }

    @Override
    public ProductEntity update(ProductEntity product) {
        ProductEntity findById = repo.findById(product.getId()).orElse(null);
        findById.setName(product.getName());
        findById.setPrice(product.getPrice());
        findById.setQuantity(product.getQuantity());
        findById.setDescription(product.getDescription());
        return repo.save(findById);
    }

    @Override
    public boolean delete(Long id) {
        Optional<ProductEntity> product = repo.findById(id);
        if(product.isPresent()){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
