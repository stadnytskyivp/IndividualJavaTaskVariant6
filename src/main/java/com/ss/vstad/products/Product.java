package com.ss.vstad.products;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Product{

    private String productType;
    private String brand;
    private LocalDate productionDate;

    public Product() {
    }

    public Product(String productType, String brand, LocalDate productDate) {
        this.brand = brand;
        this.productType = productType;
        this.productionDate = productDate;
    }

    //------------------------------------------------------------------------------------------------------------------
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\nProduct{" +
                "productType='" + productType + '\'' +
                ", brand='" + brand + '\'' +
                ", productionDate='" + productionDate + '\'' + "}";
    }

    //----------------------------------------------------------------------------------------------------------------------
    public long getAge() {
        LocalDate today = LocalDate.now();
        try {
            return ChronoUnit.DAYS.between(productionDate, today);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void input(List<Product> list) {
        productionDate = null;

        Scanner myObj = new Scanner(System.in);
        setProductType(myObj.nextLine()); // Read user input
        setBrand(myObj.nextLine());
        dataCheck(myObj.nextLine());
        if (productionDate != null) list.add(new Product(productType, brand, productionDate));
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void output(List<Product> list) {
        System.out.println(list);
    }

    //----------------------------------------------------------------------------------------------------------------------
    public void dataCheck(String date) {   // verify Date format
        try {
            productionDate = LocalDate.parse(date);
        } catch (DateTimeParseException | NullPointerException e) {
            e.printStackTrace();
        }
    }

//----------------------------------------------------------------------------------------------------------------------
}
