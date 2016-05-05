package com.shopping.assignment;

import com.shopping.assignment.cartcostcalculator.ShoppingCartCostCalculator;
import com.shopping.assignment.cartitem.Fruit;
import com.shopping.assignment.cartitem.Item;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest extends TestCase {

    @Mock
    ShoppingCartCostCalculator shoppingCartCostCalculator;

    @Test
    public void testAddItem() {
        Item orange = new Fruit(BigDecimal.ONE, Constants.TWO, Constants.ORANGE);
        ShoppingCart testObj = new ShoppingCart();
        testObj.addItem(orange);
        assertEquals(Constants.ONE, testObj.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddItemWhenItemIsNull() {
        ShoppingCart testObj = new ShoppingCart();
        testObj.addItem(null);
    }

    @Test
    public void testRemoveItem() {

        ShoppingCart testObj = new ShoppingCart();
        Item orange = new Fruit(BigDecimal.ONE, Constants.ONE, Constants.ORANGE);
        testObj.addItem(orange);

        Item apple = new Fruit(BigDecimal.ONE, Constants.TWO, Constants.APPLE);
        testObj.addItem(apple);

        testObj.removeItem(orange);
        assertEquals(Constants.ONE, testObj.size());

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveItemWhenItemIsNull() {

        ShoppingCart testObj = new ShoppingCart();
        testObj.removeItem(null);

    }

    @Test
    public void testSize() {
        ShoppingCart testObj = new ShoppingCart();
        Item orange = new Fruit(BigDecimal.ONE, Constants.ONE, Constants.ORANGE);
        testObj.addItem(orange);

        assertEquals(Constants.ONE, testObj.size());

        Item apple = new Fruit(BigDecimal.ONE, Constants.TWO, Constants.APPLE);
        testObj.addItem(apple);

        assertEquals(Constants.TWO, testObj.size());

        testObj.removeItem(orange);
        assertEquals(Constants.ONE, testObj.size());

    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart testObj = new ShoppingCart(shoppingCartCostCalculator);
        when(shoppingCartCostCalculator.calculateCost(anyList())).thenReturn(BigDecimal.ONE);

        Item orange = new Fruit(BigDecimal.ONE, Constants.ONE, Constants.ORANGE);
        testObj.addItem(orange);

        Item apple = new Fruit(BigDecimal.ONE, Constants.TWO, Constants.APPLE);
        testObj.addItem(apple);

        assertEquals(BigDecimal.ONE, testObj.calculateTotal());
        verify(shoppingCartCostCalculator, times(Constants.NUMBER_OF_INVOCATIONS_ONE)).calculateCost(anyList());
    }
}