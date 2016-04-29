package com.shopping.assignment.cartitem;

import com.shopping.assignment.Constants;
import com.shopping.assignment.cartitem.Fruit;
import com.shopping.assignment.cartvisitor.ShoppingCartVisitor;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class FruitTest extends TestCase {



    @Mock
    ShoppingCartVisitor mockVisitor;

    @Test
    public void testAccept() {
        Fruit testObj = new Fruit(BigDecimal.ONE, Constants.TWO, Constants.ORANGE);
        when(mockVisitor.visit(testObj)).thenReturn(BigDecimal.ONE);

        BigDecimal actaulRetVal = testObj.accept(mockVisitor);

        verify(mockVisitor, times(Constants.NUMBER_OF_INVOCATIONS_ONE)).visit(testObj);
        assertEquals(BigDecimal.ONE, actaulRetVal);
    }

    @Test(expected = NullPointerException.class)
    public void testAcceptWhenVisitorIsNull() {
        Fruit testObj = new Fruit(BigDecimal.ONE, Constants.TWO, Constants.ORANGE);
        testObj.accept(null);
    }
}