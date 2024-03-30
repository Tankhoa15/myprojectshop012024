package com.khoa.shop.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
