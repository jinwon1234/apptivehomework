package com.example.homework.service;


import com.example.homework.dto.ProductRequest;
import com.example.homework.entity.Product;
import com.example.homework.exception.ProductDuplicateException;
import com.example.homework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product order(ProductRequest productRequest) {

        Product product = new Product(productRequest.name(), productRequest.price(), productRequest.quantity());
        validateDuplicate(product);
        return productRepository.save(product);
    }

    public void validateDuplicate(Product product) {
        productRepository.findByName(product.getName())
                        .ifPresent(p->{
                            throw new ProductDuplicateException();
                        });
    }



    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
