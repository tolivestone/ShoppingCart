package com.shopping.assignment;

import com.shopping.assignment.cartitem.Fruit;
import com.shopping.assignment.cartitem.Item;

import java.math.BigDecimal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item orange = new Fruit(BigDecimal.valueOf(5.20f), 2, "Orange");
        Item banana = new Fruit(BigDecimal.valueOf(1.50f), 3, "Banana");
        Item apple = new Fruit(BigDecimal.valueOf(2.90f), 5, "Apple");

        shoppingCart.addItem(orange);
        shoppingCart.addItem(banana);
        shoppingCart.addItem(apple);

        BigDecimal totalCost = shoppingCart.calculateTotal();
        System.out.println("Total Cost of Shopping Cart is: " + totalCost);

    }
}
