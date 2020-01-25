package com.mckinsey.retailstore.service.core;


import com.mckinsey.retailstore.model.Product;

public class PercentageStrategy implements IPricingStrategy {
    private double percentageDiscount;

    public PercentageStrategy(int percentageDiscount) {
        this.percentageDiscount = percentageDiscount / 100.0;
    }

    @Override
    public double getPrice(Product product, int quantity) {
        double price = !product.getProductType().isDiscounted() ? product.getPrice() * quantity :
                ((product.getPrice() * quantity) * (1.0 - percentageDiscount));
        return price;
    }
}
