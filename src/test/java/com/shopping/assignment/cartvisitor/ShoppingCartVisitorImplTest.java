package com.shopping.assignment.cartvisitor;

import com.shopping.assignment.Constants;
import com.shopping.assignment.cartitem.Fruit;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartVisitorImplTest extends TestCase {

    @Test
    public void testVisit() {
        ShoppingCartVisitor testObj = new ShoppingCartVisitorImpl();

        Fruit orange = new Fruit(BigDecimal.ONE, Constants.TWO, Constants.ORANGE);
        BigDecimal actualRetVal = testObj.visit(orange);
        assertEquals(actualRetVal, BigDecimal.valueOf(2));

        Fruit apple = new Fruit(BigDecimal.TEN, Constants.TWO, Constants.APPLE);
        actualRetVal = testObj.visit(apple);
        assertEquals(actualRetVal, BigDecimal.valueOf(20));
    }

    @Test(expected = NullPointerException.class)
    public void testVisitWhenFruitIsNull() {
        ShoppingCartVisitor testObj = new ShoppingCartVisitorImpl();
        testObj.visit(null);
    }
}