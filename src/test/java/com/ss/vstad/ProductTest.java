package com.ss.vstad;

import com.ss.vstad.products.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class ProductTest {

    @Test
    public void getAgeTest() {
        //arrange
        int expectedAge = 63;
        Product product = new Product("chocolate","milka", LocalDate.of(2020,1,1));
        //act
        long age = product.getAge();
        //assert
        Assert.assertEquals(age,expectedAge,"getAge method calculates days from creation to current day");
    }

}
