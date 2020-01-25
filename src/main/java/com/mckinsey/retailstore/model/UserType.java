package com.mckinsey.retailstore.model;

import com.mckinsey.retailstore.service.core.CustomerPricingStrategy;
import com.mckinsey.retailstore.service.core.IPricingStrategy;
import com.mckinsey.retailstore.service.core.PercentageStrategy;

public enum UserType {

    EMPLOYEE(new PercentageStrategy(30)),

    AFFILIATE(new PercentageStrategy(10)),

    CUSTOMER(null);

    private IPricingStrategy pricingStrategy;

    UserType(IPricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public IPricingStrategy getPricingStrategy() {
        return this.pricingStrategy;
    }

    public void setPricingStrategy(IPricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double getPrice(Product product, int quantity, User user) {
        if (this.name().equals(CUSTOMER.name())) {
            this.setPricingStrategy(new CustomerPricingStrategy(new PercentageStrategy(5), user));
        }
        return this.getPricingStrategy().getPrice(product, quantity);
    }
}
