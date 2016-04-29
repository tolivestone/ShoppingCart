package com.shopping.assignment.cartitem;

import com.shopping.assignment.cartvisitor.ShoppingCartVisitor;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;

public class Fruit implements Item {

    private BigDecimal pricePerKg;
    private int weight;
    private String name;

    public Fruit(final BigDecimal pricePerKg, final int weight, final String name) {
        Validate.notNull(pricePerKg);
        Validate.notNull(name);
        Validate.notEmpty(name);
        assert(weight > 0);

        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal accept(final ShoppingCartVisitor visitor) {
        Validate.notNull(visitor, "Shopping Cart Visitor can't be null");
        return visitor.visit(this);
    }
}
