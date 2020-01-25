package com.mckinsey.retailstore.service.impl;

import com.mckinsey.retailstore.model.Product;
import com.mckinsey.retailstore.model.ProductType;
import com.mckinsey.retailstore.model.User;
import com.mckinsey.retailstore.model.UserType;
import com.mckinsey.retailstore.model.request.PricingRequestVO;
import com.mckinsey.retailstore.model.request.ProductDetailsVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PricingServiceImplTest {
    @InjectMocks
    PricingServiceImpl pricingServiceImpl;
    private PricingRequestVO request;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        request = Mockito.mock(PricingRequestVO.class);
        List<ProductDetailsVO> list = new ArrayList<>();
        ProductDetailsVO productDetails = new ProductDetailsVO(new Product(ProductType.GROCERY, 100, "A"), 2);
        ProductDetailsVO productDetails2 = new ProductDetailsVO(new Product(ProductType.OTHER, 1000, "B"), 1);
        list.add(productDetails);
        list.add(productDetails2);
        Mockito.when(request.getProductList()).thenReturn(list);

    }

    @Test
    public void getPriceForEmployeeTest() {
        User user = new User("Saiyam", UserType.EMPLOYEE, new Date());
        Mockito.when(request.getUser()).thenReturn(user);
        Assert.assertEquals(Double.doubleToLongBits(pricingServiceImpl.getTotalPrice(request).getTotalPrice()), Double.doubleToLongBits(855.0));
    }

    @Test
    public void getPriceForAffiliatedTest() {
        User user = new User("Saiyam", UserType.AFFILIATE, new Date());
        Mockito.when(request.getUser()).thenReturn(user);
        Assert.assertEquals(Double.doubleToLongBits(pricingServiceImpl.getTotalPrice(request).getTotalPrice()), Double.doubleToLongBits(1045.0));
    }

    @Test
    public void getPriceForCustomerLessThan2YearsTest() {
        User user = new User("Saiyam", UserType.CUSTOMER, new Date());
        Mockito.when(request.getUser()).thenReturn(user);
        Assert.assertEquals(Double.doubleToLongBits(pricingServiceImpl.getTotalPrice(request).getTotalPrice()), Double.doubleToLongBits(1140.0));
    }

    @Test
    public void getPriceForCustomerGreaterThan2YearsTest() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -3);
        Date dateBefore30Days = cal.getTime();
        User user = new User("Saiyam", UserType.CUSTOMER, cal.getTime());
        Mockito.when(request.getUser()).thenReturn(user);
        Assert.assertEquals(Double.doubleToLongBits(pricingServiceImpl.getTotalPrice(request).getTotalPrice()), Double.doubleToLongBits(1092.5));
    }
}
