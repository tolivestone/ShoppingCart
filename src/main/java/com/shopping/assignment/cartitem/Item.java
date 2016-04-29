package com.shopping.assignment.cartitem;

import com.shopping.assignment.cartvisitor.ShoppingCartVisitor;

import java.math.BigDecimal;

public interface Item {
    BigDecimal accept(ShoppingCartVisitor visitor);
}
