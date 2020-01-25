package com.mckinsey.retailstore.model;

public enum ProductType {
    GROCERY(false), OTHER(true);

    private boolean discounted;

    ProductType(boolean discounted) {
        this.discounted = discounted;
    }

    public boolean isDiscounted() {
        return discounted;
    }
}
