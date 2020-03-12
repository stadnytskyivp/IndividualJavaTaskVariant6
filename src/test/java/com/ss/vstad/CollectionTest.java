package com.ss.vstad;

import com.ss.vstad.products.Product;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.io.*;
import java.util.List;

public class CollectionTest {

    @Test(dataProvider = "CollectionProvider", dataProviderClass = CollectionProvider.class)
    public void deserializationTest(List<Product> productList) throws FileNotFoundException {
        //arrange
        ProductCollection actualDeserializeList = new ProductCollection();
        //act
        actualDeserializeList.deserializeProducts("productsTest.xml");
        //assert
        ReflectionAssert.assertReflectionEquals(productList, actualDeserializeList.getProductList());
    }

    @Test(dataProvider = "SortProductTypeCollectionProvider", dataProviderClass = CollectionProvider.class)
    public void SortByProductTypeTest(List<Product> actualProductList, List<Product> expectedProductList ) {
        //arrange
        ProductCollection objProductList = new ProductCollection(actualProductList);
        //act
        objProductList.sortProductType();
        //assert
        ReflectionAssert.assertReflectionEquals(expectedProductList,actualProductList);

    }

    @Test(dataProvider = "SortBrandCollectionProvider", dataProviderClass = CollectionProvider.class)
    public void SortByBrandTest(List<Product> actualProductList, List<Product> expectedProductList ) {
        //arrange
        ProductCollection objProductList = new ProductCollection(actualProductList);
        //act
        objProductList.sortByBrand();
        //assert
        ReflectionAssert.assertReflectionEquals(expectedProductList,actualProductList);

    }

}
