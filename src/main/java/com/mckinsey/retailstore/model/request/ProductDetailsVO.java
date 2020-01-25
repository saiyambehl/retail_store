package com.mckinsey.retailstore.model.request;

import com.mckinsey.retailstore.model.Product;
import com.mckinsey.retailstore.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsVO {
    private Product product;
    private int quantity;
}
