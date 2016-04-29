package com.shopping.assignment.cartvisitor;

import com.shopping.assignment.cartitem.Fruit;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.math.MathContext;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    public BigDecimal visit(final Fruit fruit) {
        Validate.notNull(fruit, "Fruit can't be null");

        MathContext mc = new MathContext(4);
        return fruit.getPricePerKg().multiply(new BigDecimal(fruit.getWeight()), mc);
    }
}
