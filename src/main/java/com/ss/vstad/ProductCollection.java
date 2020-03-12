package com.ss.vstad;

import com.ss.vstad.products.FoodProduct;
import com.ss.vstad.products.Product;

import java.beans.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductCollection {

    private List<Product> productList;

    public ProductCollection() {
        productList = new ArrayList<>();
    }

    public ProductCollection(List<Product> products) {
        this.productList = products;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String str = "";
        for (Product product : productList) {
            str += product.toString();
        }
        return str;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void serializeProducts(String fileName) throws FileNotFoundException {

        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
        encoder.setPersistenceDelegate(LocalDate.class, new PersistenceDelegate() {
            @Override
            protected Expression instantiate(Object localDate, Encoder encoder) {
                return new Expression(localDate, LocalDate.class, "parse", new Object[]{localDate.toString()});
            }
        });
        encoder.writeObject(this.getProductList());
        encoder.close();
    }

    public void deserializeProducts(String fileName) throws FileNotFoundException {
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
        this.productList = (ArrayList<Product>) decoder.readObject();
        decoder.close();
    }

    //----------------------------------------------------------------------------------------------------------------------
    public List<FoodProduct> getExpiredFood() {
        try {
            if (productList.size() == 0) throw new MyExceptions("The collection is empty");
        } catch (MyExceptions extraExceptions) {
            extraExceptions.printStackTrace();
        }

        List<FoodProduct> productsWithExpiredFood = new ArrayList<>();
        for (Product product : productList) {
            if (product instanceof FoodProduct) {
                FoodProduct foodProduct = (FoodProduct) product;
                if ((foodProduct.getExpirationDate().compareTo(LocalDate.now()) < 0)) {
                    productsWithExpiredFood.add(foodProduct);
                }
            }
        }
        return productsWithExpiredFood;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void writeToTxtFile(List<Product> list, String fileName) {

        try {
            if (list.size() == 0) throw new MyExceptions("The collection is empty");
        } catch (MyExceptions extraExceptions) {
            extraExceptions.printStackTrace();
        }

        try {
            PrintWriter print = new PrintWriter(new FileOutputStream(fileName));
            for (Object e : list) {
                print.println(e.toString());
            }
            print.close();
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file name!");
            writeToTxtFile(list, fileName);
        }

        System.out.println("collection.txt created");
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void sortByBrand() {
        try {
            if (productList.size() == 0) throw new MyExceptions("The collection is empty");
        } catch (MyExceptions extraExceptions) {
            extraExceptions.printStackTrace();
        }
        Collections.sort(productList, new SortByBrandComparator());
        System.out.println("sorted by brand");
    }

    public void sortProductType() {
        try {
            if (productList.size() == 0) throw new MyExceptions("The collection is empty");
        } catch (MyExceptions extraExceptions) {
            extraExceptions.printStackTrace();
        }
        Collections.sort(productList, new SortByProductTypeComparator());
        System.out.println("sorted by product type");
    }
}

//----------------------------------------------------------------------------------------------------------------------
class SortByBrandComparator implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2) {
        return product1.getBrand().compareToIgnoreCase(product2.getBrand());
    }
}

//----------------------------------------------------------------------------------------------------------------------
class SortByProductTypeComparator implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2) {
        return product1.getProductType().compareToIgnoreCase(product2.getProductType());
    }
}
//----------------------------------------------------------------------------------------------------------------------