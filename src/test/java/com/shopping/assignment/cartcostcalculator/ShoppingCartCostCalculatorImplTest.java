package com.shopping.assignment.cartcostcalculator;

import com.shopping.assignment.Constants;
import com.shopping.assignment.cartcostcalculator.ShoppingCartCostCalculatorImpl;
import com.shopping.assignment.cartitem.Fruit;
import com.shopping.assignment.cartitem.Item;
import com.shopping.assignment.cartcostcalculator.ShoppingCartCostCalculator;
import com.shopping.assignment.cartvisitor.ShoppingCartVisitor;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartCostCalculatorImplTest extends TestCase {

    @Mock
    ShoppingCartVisitor shoppingCartVisitor;

    @Test
    public void testCalculateCost() {
        ShoppingCartCostCalculator testObj = new ShoppingCartCostCalculatorImpl(shoppingCartVisitor);

        List<Item> fruits = new ArrayList<Item>();

        Fruit orange = new Fruit(BigDecimal.ONE, Constants.ONE, Constants.ORANGE);
        fruits.add(orange);

        Fruit apple = new Fruit(BigDecimal.TEN, Constants.TWO, Constants.APPLE);
        fruits.add(apple);

        when(shoppingCartVisitor.visit(orange)).thenReturn(BigDecimal.valueOf(1.0f));
        when(shoppingCartVisitor.visit(apple)).thenReturn(BigDecimal.valueOf(20.0f));

        BigDecimal actualTotal = testObj.calculateCost(fruits);

        assertEquals(BigDecimal.valueOf(21.0f),actualTotal);
        verify(shoppingCartVisitor, times(Constants.NUMBER_OF_INVOCATIONS_ONE)).visit(orange);
        verify(shoppingCartVisitor, times(Constants.NUMBER_OF_INVOCATIONS_ONE)).visit(apple);
    }

    @Test(expected = NullPointerException.class)
    public void testCalculateCostWhenCartItemsIsNull() {
        ShoppingCartCostCalculator testObj = new ShoppingCartCostCalculatorImpl(shoppingCartVisitor);
        testObj.calculateCost(null);
    }
}