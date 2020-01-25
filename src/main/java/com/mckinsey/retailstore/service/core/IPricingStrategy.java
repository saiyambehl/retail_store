package com.mckinsey.retailstore.service.core;

import com.mckinsey.retailstore.model.Product;

public interface IPricingStrategy {
    double getPrice(Product product, int quantity);
}
