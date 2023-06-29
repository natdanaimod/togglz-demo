package com.example.togglzdemo.service;

import com.example.togglzdemo.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.togglzdemo.DemoFeatures.DISCOUNT_APPLIED;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final FeatureManager featureManager;

    public List<Product> getAvailableProducts() {
        if (featureManager.isActive(DISCOUNT_APPLIED)) {
            return getApplyDiscountProducts();
        } else {
            return getAllProducts();
        }
    }

    private List<Product> getAllProducts() {
        return Stream.of(new Product(1, "milk", 5000),
                new Product(2, "egg", 1500),
                new Product(3, "orange", 2500),
                new Product(4, "apple", 1800)
        ).collect(Collectors.toList());
    }

    private List<Product> getApplyDiscountProducts() {
        List<Product> orderListAfterApplyDiscount = new ArrayList<>();
        getAllProducts().forEach(order -> {
            order.setPrice(order.getPrice() - (order.getPrice() * 5 / 100));
            orderListAfterApplyDiscount.add(order);
        });
        return orderListAfterApplyDiscount;
    }
}
