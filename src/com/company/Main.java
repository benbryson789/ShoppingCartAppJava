package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> productRepo = ProductRepo.getProductRepo();
        ArrayList<Product> cart = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        String readyToCheckOut = "n";

        while (!readyToCheckOut.equalsIgnoreCase("y")) {
            System.out.println("Welcome to the Shopping Cart App!");
            System.out.println();

            System.out.println();
            System.out.println("Lets get you to our list...");
            System.out.println();

           Product.displayProducts(productRepo);


            //shopping process
            Boolean willAddAnother = true;
            while (willAddAnother) {
                System.out.println();
                System.out.println();
                System.out.println("Choose an option");
                System.out.println("(1)Black Coffee");
                System.out.println("(2)Latte");
                System.out.println("(3)Tea");
                System.out.println("(4)Water");

                String itemChoice = scan.nextLine();

                //adding products

                if (itemChoice.equalsIgnoreCase("1") || itemChoice.equalsIgnoreCase("2") || itemChoice.equalsIgnoreCase("3") || itemChoice.equalsIgnoreCase("4")) {
                    for (var product : productRepo) {
                        if (itemChoice.equalsIgnoreCase("1") && product.name.equalsIgnoreCase("black coffee")) {
                            System.out.println("How many would you like?");
                            int quantity = scan.nextInt();

                            if (product.checkIfItemIsInStock()) {
                                cart = ShoppingCart.addToListBasedOnQuantity(quantity, product, cart);
                                System.out.printf("%s %s's have been added to cart", quantity, product.name);
                            }

                            break;
                        }

                        if (itemChoice.equalsIgnoreCase("2") && product.name.equalsIgnoreCase("latte")) {
                            System.out.println("How many would you like?");
                            int quantity = scan.nextInt();

                            if (product.checkIfItemIsInStock()) {
                                cart = ShoppingCart.addToListBasedOnQuantity(quantity, product, cart);
                                System.out.printf("%s %s's have been added to cart", quantity, product.name);
                            }

                            break;
                        }

                        if (itemChoice.equalsIgnoreCase("3") && product.name.equalsIgnoreCase("tea")) {
                            System.out.println("How many would you like?");
                            int quantity = scan.nextInt();

                            if (product.checkIfItemIsInStock()) {
                                cart = ShoppingCart.addToListBasedOnQuantity(quantity, product, cart);
                                System.out.printf("%s %s's have been added to cart", quantity, product.name);
                            }

                            break;
                        }

                        if (itemChoice.equalsIgnoreCase("4") && product.name.equalsIgnoreCase("water")) {
                            System.out.println("How many would you like?");
                            int quantity = scan.nextInt();

                            if (product.checkIfItemIsInStock()) {
                                cart = ShoppingCart.addToListBasedOnQuantity(quantity, product, cart);
                                System.out.printf("%s %s's have been added to cart", quantity, product.name);
                            }

                            break;
                        }
                    }
                } else {
                    System.out.println("Please choose a valid choice");
                }


                System.out.println();

                System.out.println("Would you like to add another item? (y)es or (n)o");
                scan = new Scanner(System.in);
                String addAnotherItem = scan.nextLine();

                if (!addAnotherItem.equalsIgnoreCase("y")) {
                    willAddAnother = false;
                }

            }

            System.out.println("Are you ready to checkout? (y)es or (n)o");
            readyToCheckOut = scan.nextLine();
        }

        //start checkout process
        double totalPriceBeforeTax = ShoppingCart.calculateTotalCartPriceBeforeTax(cart);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.printf("The total cart price before tax is %s", formatter.format(totalPriceBeforeTax));
        System.out.println();

        double totalCartPriceAfterTax = ShoppingCart.calculateTotalCartPriceAfterTax(totalPriceBeforeTax);
        System.out.printf("The new total price after tax is %s", formatter.format(totalCartPriceAfterTax));


        System.out.println();

        System.out.println("Thank you for choosing us!");
        System.out.println();

    }

}
