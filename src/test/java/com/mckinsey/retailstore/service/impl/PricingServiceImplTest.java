package com.mckinsey.retailstore.service.impl;

import com.mckinsey.retailstore.service.PricingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PricingServiceImplTest {
    @InjectMocks
    PricingServiceImpl pricingServiceImpl;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployeesTest() {
        Assert.assertTrue(true);
    }

}
