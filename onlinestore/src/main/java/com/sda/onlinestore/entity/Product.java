package com.sda.onlinestore.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int price;

    @Enumerated(EnumType.STRING)
    private String productType;

}
