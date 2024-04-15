package com.khoa.shop.service;

import com.khoa.shop.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();

    ProductEntity findById(Long id);

    ProductEntity create(ProductEntity product);

    ProductEntity update(ProductEntity product);

    boolean delete(Long id);
}
