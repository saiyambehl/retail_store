package com.mckinsey.retailstore.service.impl;

import com.mckinsey.retailstore.model.Product;
import com.mckinsey.retailstore.model.ProductType;
import com.mckinsey.retailstore.model.User;
import com.mckinsey.retailstore.model.request.PricingRequestVO;
import com.mckinsey.retailstore.model.response.PricingResponseVO;
import com.mckinsey.retailstore.service.PricingService;
import com.mckinsey.retailstore.service.core.IPricingStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PricingServiceImpl implements PricingService {

    @Override
    public PricingResponseVO getTotalPrice(PricingRequestVO requestVO) {
        double totalPrice = requestVO.getProductList().stream()
                .map(x -> requestVO.getUser().getUserType().getPrice(x.getProduct(), x.getQuantity(), requestVO.getUser()))
                .mapToDouble(y -> y)
                .sum();
        double discount = 0.0d;
        if (totalPrice > 100) {
            discount = (totalPrice / 100) * 5;
        }
        return new PricingResponseVO(totalPrice - discount);
    }
}
