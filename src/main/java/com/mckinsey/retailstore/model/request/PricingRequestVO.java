package com.mckinsey.retailstore.model.request;

import com.mckinsey.retailstore.model.ProductType;
import com.mckinsey.retailstore.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricingRequestVO {
    private User user;
    private List<ProductDetailsVO> productList;
}
