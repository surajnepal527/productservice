package com.scaler.productservice.models;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
    private Rating rating;

}
