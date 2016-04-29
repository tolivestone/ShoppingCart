package com.shopping.assignment.cartcostcalculator;

import com.shopping.assignment.cartitem.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Keya on 26/04/2016.
 */
public interface ShoppingCartCostCalculator {
    BigDecimal calculateCost(List<Item> cartItems);
}
