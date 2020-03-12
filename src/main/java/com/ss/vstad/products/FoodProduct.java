package com.ss.vstad.products;

import java.time.LocalDate;
import java.util.*;

public class FoodProduct extends Product {

    private String foodName;
    private int suitabilityDuration;

    public FoodProduct() {
    }

    public FoodProduct(String productType, String brand, LocalDate productDate, String foodName, int suitabilityDuration) {
        super(productType, brand, productDate);
        this.foodName = foodName;
        this.suitabilityDuration = suitabilityDuration;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getSuitabilityDuration() {
        return suitabilityDuration;
    }

    public void setSuitabilityDuration(int suitabilityDuration) {
        this.suitabilityDuration = suitabilityDuration;
    }

    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void input(List<Product> list) {
        setProductionDate(null);

        Scanner myObj = new Scanner(System.in);
        setProductType(myObj.nextLine());
        setBrand(myObj.nextLine());
        dataCheck(myObj.nextLine());
        setFoodName(myObj.nextLine());
        setSuitabilityDuration(myObj.nextInt());
        if (getProductionDate() != null)
            list.add(new FoodProduct(getProductType(), getBrand(), getProductionDate(), foodName, suitabilityDuration));
    }

    @Override
    public void output(List<Product> list) {
        super.output(list);
    }

    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public long getAge() {
        return super.getAge();
    }

    @Override
    public void dataCheck(String date) {
        super.dataCheck(date);
    }

    @Override
    public String toString() {
        return "\nFoodProduct{" +
                "productType='" + getProductType() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", productionDate='" + getProductionDate() + '\'' +
                ", foodName='" + foodName + '\'' +
                ", suitabilityDuration=" + suitabilityDuration +
                '}';
    }

    //----------------------------------------------------------------------------------------------------------------------
    public LocalDate getExpirationDate() {
        try {
            return getProductionDate().plusDays(suitabilityDuration);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
}
