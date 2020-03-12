package com.ss.vstad;

import com.ss.vstad.products.FoodProduct;
import com.ss.vstad.products.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ActiveConsole {

    private final String srcDir = System.getProperty("user.dir");
    private String file = srcDir + "\\src\\main\\resources\\aboutProducts.xml";    // laptop

    private ProductCollection collection = new ProductCollection();
    private FoodProduct foodProduct = new FoodProduct();
    private Product product = new Product();

    public void reader() throws FileNotFoundException {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(" +++ Session started. You can use next commands: \n (in) input 1 element\n (out) output all\n " +
                "(ga) get age of the last product when it was made\n (ts) to String one element\n (ser) serialize to XML file\n" +
                " (des) deserialize from XML file\n (sort_t/sort_b) collection sorting\n (ef) getExpiredFood\n (ed) getExpirationDate" +
                " \n (exit) exit ");

        while (true) {
            System.out.print(" : ");
            String strInput = myObj.nextLine().toLowerCase();  // Read user input

            switch (strInput) {
                case ("ser"):
                    collection.serializeProducts(file);
                    System.out.println(" Data was serialize to XML file");
                    break;
                case ("des"):
                    collection.deserializeProducts(file);
                    System.out.print(collection.toString());
                    System.out.println("");
                    System.out.println(" Data was deserialize from XML");
                    break;
                case ("sort_b"):
                    collection.sortByBrand();
                    break;
                case ("sort_t"):
                    collection.sortProductType();
                    break;
                case ("ts"):
                    System.out.println(product.toString());
                    break;
                case ("tsF"):
                    System.out.println(foodProduct.toString());
                    break;
                case ("ef"):
                    System.out.println(collection.getExpiredFood());
                    break;
                case ("txt"):
                    collection.writeToTxtFile(collection.getProductList(), "collection.txt");
                    break;
                case ("out"):
                    product.output(collection.getProductList());
                    break;
                case ("ed"):
                    System.out.println(foodProduct.getExpirationDate());
                    break;
                case ("ga"):
                    System.out.println(product.getAge());
                    break;
                case ("gaf"):
                    System.out.println(foodProduct.getAge());
                    break;
                case ("in"):
                    System.out.println("Insert Product type; Brand; Product Date yyyy-MM-dd");
                    product.input(collection.getProductList());
                    break;
                case ("inf"):
                    System.out.println("Insert FOOD Product type; Brand; Product Date yyyy-MM-dd; FoodName; SuitabilityDuration");
                    foodProduct.input(collection.getProductList());
                    break;
                case ("exit"):
                    System.out.println(" +++ THE END +++ ");
                    System.exit(0);
                default:
                    System.out.println(" ??? invalid command ???");
                    break;
            }
        }
    }
}
