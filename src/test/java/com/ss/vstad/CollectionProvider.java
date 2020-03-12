package com.ss.vstad;

import com.ss.vstad.products.FoodProduct;
import com.ss.vstad.products.Product;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollectionProvider {

    @DataProvider(name = "CollectionProvider")
    public Object[][] getData() {
        List<Product> productList = new ArrayList();
        productList.add(new Product("laptop", "lenovo", LocalDate.of(2015, 5, 02)));
        productList.add(new FoodProduct("water", "truskawetska", LocalDate.of(2016, 1, 01), "soda water", 180));
        productList.add(new Product("automobile", "audi", LocalDate.of(2005, 5, 02)));
        productList.add(new Product("cell phone", "apple", LocalDate.of(2018, 5, 02)));
        productList.add(new FoodProduct("milk product", "cheese club", LocalDate.of(2019, 5, 02), "cheese", 40));
        productList.add(new FoodProduct("drinks", "lvivske", LocalDate.of(2020, 1, 02), "beer", 20));
        return new Object[][]{{productList}};
    }

    @DataProvider(name = "SortProductTypeCollectionProvider")
    public Object[][] SortByProductTypeTest() {
        List<Product> productList = new ArrayList();
        productList.add(new Product("laptop", "lenovo", LocalDate.of(2015, 5, 02)));
        productList.add(new FoodProduct("water", "truskawetska", LocalDate.of(2016, 1, 01), "soda water", 180));
        productList.add(new Product("automobile", "audi", LocalDate.of(2005, 5, 02)));
        productList.add(new Product("cell phone", "apple", LocalDate.of(2018, 5, 02)));
        productList.add(new FoodProduct("milk product", "cheese club", LocalDate.of(2019, 5, 02), "cheese", 40));
        productList.add(new FoodProduct("drinks", "lvivske", LocalDate.of(2020, 1, 02), "beer", 20));

        List<Product> sortedProductList = new ArrayList();
        sortedProductList.add(new Product("automobile", "audi", LocalDate.of(2005, 5, 02)));
        sortedProductList.add(new Product("cell phone", "apple", LocalDate.of(2018, 5, 02)));
        sortedProductList.add(new FoodProduct("drinks", "lvivske", LocalDate.of(2020, 1, 02), "beer", 20));
        sortedProductList.add(new Product("laptop", "lenovo", LocalDate.of(2015, 5, 02)));
        sortedProductList.add(new FoodProduct("milk product", "cheese club", LocalDate.of(2019, 5, 02), "cheese", 40));
        sortedProductList.add(new FoodProduct("water", "truskawetska", LocalDate.of(2016, 1, 01), "soda water", 180));

        return new Object[][]{{productList, sortedProductList}};
    }

    @DataProvider(name = "SortBrandCollectionProvider")
    public Object[][] SortByBrandTest() {
        List<Product> productList = new ArrayList();
        productList.add(new Product("laptop", "lenovo", LocalDate.of(2015, 5, 02)));
        productList.add(new FoodProduct("water", "truskawetska", LocalDate.of(2016, 1, 01), "soda water", 180));
        productList.add(new Product("automobile", "audi", LocalDate.of(2005, 5, 02)));
        productList.add(new Product("cell phone", "apple", LocalDate.of(2018, 5, 02)));
        productList.add(new FoodProduct("milk product", "cheese club", LocalDate.of(2019, 5, 02), "cheese", 40));
        productList.add(new FoodProduct("drinks", "lvivske", LocalDate.of(2020, 1, 02), "beer", 20));

        List<Product> sortedProductList = new ArrayList();
        sortedProductList.add(new Product("cell phone", "apple", LocalDate.of(2018, 5, 02)));
        sortedProductList.add(new Product("automobile", "audi", LocalDate.of(2005, 5, 02)));
        sortedProductList.add(new FoodProduct("milk product", "cheese club", LocalDate.of(2019, 5, 02), "cheese", 40));
        sortedProductList.add(new Product("laptop", "lenovo", LocalDate.of(2015, 5, 02)));
        sortedProductList.add(new FoodProduct("drinks", "lvivske", LocalDate.of(2020, 1, 02), "beer", 20));
        sortedProductList.add(new FoodProduct("water", "truskawetska", LocalDate.of(2016, 1, 01), "soda water", 180));

        return new Object[][]{{productList, sortedProductList}};
    }

}
