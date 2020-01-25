package com.mckinsey.retailstore.service.core;


import com.mckinsey.retailstore.model.Product;
import com.mckinsey.retailstore.model.User;

import java.util.Calendar;
import java.util.Date;

public class CustomerPricingStrategy extends PercentageDecorator {
    private User user;

    public CustomerPricingStrategy(IPricingStrategy pricingStrategy, User user) {
        super(pricingStrategy);
        this.user = user;
    }

    @Override
    public double getPrice(Product product, int quantity) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(new Date());
        c2.setTime(user.getDateOfJoining());
        return (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR) > 2) ?
                pricingStrategy.getPrice(product, quantity) : product.getPrice() * quantity;
    }
}
