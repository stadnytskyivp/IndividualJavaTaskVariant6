package com.ss.vstad;

import com.ss.vstad.products.FoodProduct;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class FoodProductTest {

    @Test
    public void expirationDateTest(){
        // arrange
        LocalDate expectedDate = LocalDate.parse("2020-01-22");
        FoodProduct product = new FoodProduct("drinks","lvivske", LocalDate.of(2020,1,02),"beer",20);
        //act
        LocalDate expirationDate = product.getExpirationDate();
        //assert   // make it variable  !!!
        Assert.assertEquals(expirationDate,expectedDate,"getExpirationDate method returns date when end product suitability");
    }

}
