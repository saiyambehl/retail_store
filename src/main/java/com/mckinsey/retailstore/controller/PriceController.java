package com.mckinsey.retailstore.controller;

import com.mckinsey.retailstore.model.request.PricingRequestVO;
import com.mckinsey.retailstore.model.response.PricingResponseVO;
import com.mckinsey.retailstore.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class PriceController {
    @Autowired
    PricingService pricingService;

    @RequestMapping(value = "/getFinalPrice", method = RequestMethod.POST)
    public ResponseEntity<PricingResponseVO> getPrice(@RequestBody PricingRequestVO requestVO) {
        return new ResponseEntity<>(pricingService.getTotalPrice(requestVO), HttpStatus.OK);
    }
}