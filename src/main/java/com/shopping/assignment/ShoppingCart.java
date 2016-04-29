package com.shopping.assignment;

import com.shopping.assignment.cartcostcalculator.ShoppingCartCostCalculator;
import com.shopping.assignment.cartcostcalculator.ShoppingCartCostCalculatorImpl;
import com.shopping.assignment.cartitem.Item;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    ShoppingCartCostCalculator costCalculator;
    private List<Item> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<Item>();
        costCalculator = new ShoppingCartCostCalculatorImpl();
    }

    public ShoppingCart(final ShoppingCartCostCalculator shoppingCartCostCalculator) {
        Validate.notNull(shoppingCartCostCalculator);

        this.cartItems = new ArrayList<Item>();
        costCalculator = shoppingCartCostCalculator;
    }

    public int size() {
        return cartItems.size();
    }

    public void addItem(final Item item) {
        Validate.notNull(item, "Item can't be null");
        this.cartItems.add(item);
    }

    public void removeItem(final Item item) {
        Validate.notNull(item, "Item can't be null");
        this.cartItems.remove(item);
    }

    public BigDecimal calculateTotal() {
        return costCalculator.calculateCost(cartItems);
    }
}
