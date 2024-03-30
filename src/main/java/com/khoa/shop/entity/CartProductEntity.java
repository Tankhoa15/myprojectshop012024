package com.khoa.shop.entity;

import jakarta.persistence.*;

@Entity
public class CartProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private CartEntity cart;

    @ManyToOne
    @JoinTable(name="product_id")
    private ProductEntity product;
}
