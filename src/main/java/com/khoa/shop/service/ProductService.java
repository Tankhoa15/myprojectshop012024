package com.khoa.shop.service;

import com.khoa.shop.entity.ProductEntity;
import com.khoa.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

   @Autowired
   ProductRepository repo;

    public List<ProductEntity> getAllProduct() {
        List<ProductEntity> products = (List<ProductEntity>) repo.findAll();
        return products;
    }

}
