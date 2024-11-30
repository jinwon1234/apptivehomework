package com.example.homework.controller;


import com.example.homework.dto.ProductRequest;
import com.example.homework.entity.Product;
import com.example.homework.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/order")
    public String order() {
        return "addProduct";
    }

    @PostMapping("/order")
    public String addProduct(@ModelAttribute @Valid ProductRequest productRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "addProduct";
        }


        productService.order(productRequest);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String allProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "productList";
    }
}
