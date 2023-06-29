package com.example.togglzdemo.controller;

import com.example.togglzdemo.dto.Product;
import com.example.togglzdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/orders")
    public List<Product> getAvailableProducts(){
        return productService.getAvailableProducts();
    }
}
