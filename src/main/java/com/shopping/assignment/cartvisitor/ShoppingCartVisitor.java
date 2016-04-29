package com.shopping.assignment.cartvisitor;

import com.shopping.assignment.cartitem.Fruit;

import java.math.BigDecimal;

public interface ShoppingCartVisitor {
    BigDecimal visit(Fruit fruit);
}
