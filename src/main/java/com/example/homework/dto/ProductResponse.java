package com.example.homework.dto;

import com.example.homework.entity.Product;

public record ProductResponse (
    String name,
    int price,
    int quantity
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getName(),product.getPrice(),product.getQuantity());
    }
}
