package com.mckinsey.retailstore.service.core;

import com.mckinsey.retailstore.model.Product;

public abstract class PercentageDecorator implements IPricingStrategy {
    protected IPricingStrategy pricingStrategy;

    public PercentageDecorator(IPricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public double getPrice(Product product, int quantity) {
        return pricingStrategy.getPrice(product, quantity);
    }
}
