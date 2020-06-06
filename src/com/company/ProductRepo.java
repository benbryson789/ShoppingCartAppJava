package com.company;

import java.util.ArrayList;

public class ProductRepo {

    public static ArrayList<Product> getProductRepo(){
        ArrayList<Product> productRepo = new ArrayList<>();
        productRepo.add(new Product("black coffee", "Just the basic coffee", "coffee", 1.25));
        productRepo.add(new Product("latte", "The fancy variety", "coffee", 2.50));
        productRepo.add(new Product("tea", "Meditation in a cup", "tea", 1.25));
        productRepo.add(new Product("water", "Quench that thirst", "beverage", 1.00));

        return productRepo;

    }
}
