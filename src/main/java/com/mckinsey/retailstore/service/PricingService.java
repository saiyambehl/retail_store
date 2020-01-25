package com.mckinsey.retailstore.service;

import com.mckinsey.retailstore.model.request.PricingRequestVO;
import com.mckinsey.retailstore.model.response.PricingResponseVO;
import org.springframework.stereotype.Service;

public interface PricingService {
    PricingResponseVO getTotalPrice(PricingRequestVO requestVO);
}
