package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    public static ArrayList<Product> addToListBasedOnQuantity(int quantity, Product product, ArrayList<Product> products) {


        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }

        Product.decreaseInventory(quantity);
        return products;
    }

    public static double calculateTotalCartPriceBeforeTax(ArrayList<Product> cart) {
        double totalCartPrice = 0;

        for (var product : cart) {
            totalCartPrice += product.price;
        }

        return totalCartPrice;
    }

    public static double calculateTotalCartPriceAfterTax(double totalCartPriceBeforeTax){
        double taxAmount = totalCartPriceBeforeTax *.06;
        double totalCartPriceWithTax = totalCartPriceBeforeTax + taxAmount;

        return totalCartPriceWithTax;
    }

}
