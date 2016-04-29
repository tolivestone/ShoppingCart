package com.shopping.assignment.cartcostcalculator;


import com.shopping.assignment.cartitem.Item;
import com.shopping.assignment.cartvisitor.ShoppingCartVisitor;
import com.shopping.assignment.cartvisitor.ShoppingCartVisitorImpl;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartCostCalculatorImpl implements ShoppingCartCostCalculator {

    ShoppingCartVisitor visitor;

    public ShoppingCartCostCalculatorImpl() {
        this.visitor = new ShoppingCartVisitorImpl();
    }

    public ShoppingCartCostCalculatorImpl(final ShoppingCartVisitor visitor) {
        Validate.notNull(visitor);
        this.visitor = visitor;
    }

    public BigDecimal calculateCost(final List<Item> cartItems) {
        Validate.notNull(cartItems, "Cart items can't be null");

        BigDecimal totalCost = BigDecimal.ZERO;
        for (Item cartItem : cartItems) {
            totalCost = totalCost.add(cartItem.accept(visitor));

        }
        return totalCost;
    }
}
