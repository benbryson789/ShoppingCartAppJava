package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Product {

    public int id;
    public String name;
    public String description;
    public String category;
    public double price;
    private static int inventory = 10;

    public Product(String name, String description, String category, double price) {
        id++;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public static void decreaseInventory(int quantity) {
        inventory -= quantity;
    }

    public boolean checkIfItemIsInStock() {
        if (inventory <= 0) {
            System.out.println("This item is out of stock");
            return false;
        }
        return true;
    }


    public static void displayProducts(ArrayList<Product> productRepo) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        for (var product : productRepo) {
            System.out.printf("%s --> %s ", product.name.toUpperCase(), formatter.format(product.price)); //todo make this currency
        }
    }

}

