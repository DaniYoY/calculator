package org.dyord.helpers;

import org.dyord.helpers.CalculationAction;
import org.junit.Assert;
import org.junit.Test;

public class CalculationActionTests {
    @Test
    public void sumShouldReturnNumber(){
        double first = 15;
        double second = 3;

        double result = CalculationAction.sum(first,second);

        Assert.assertEquals(18,result,0);
        Assert.assertNotEquals(12,result,0);
        Assert.assertNotEquals(45,result,0);
        Assert.assertNotEquals(5,result,0);
    }

    @Test
    public void subtractShouldReturnNumber(){
        double first = 15;
        double second = 3;

        double result = CalculationAction.subtract(first,second);
        Assert.assertEquals(12,result,0);
        Assert.assertNotEquals(18,result,0);
        Assert.assertNotEquals(45,result,0);
        Assert.assertNotEquals(5,result,0);
    }

    @Test
    public void multiplyShouldReturnNumber(){
        double first = 15;
        double second = 3;

        double result = CalculationAction.multiply(first,second);

        Assert.assertEquals(45,result,0);
        Assert.assertNotEquals(12,result,0);
        Assert.assertNotEquals(18,result,0);
        Assert.assertNotEquals(5,result,0);
    }

    @Test
    public void divideShouldReturnNumber(){
        double first = 15;
        double second = 3;

        double result = CalculationAction.divide(first,second);

        Assert.assertEquals(5,result,0);
        Assert.assertNotEquals(12,result,0);
        Assert.assertNotEquals(45,result,0);
        Assert.assertNotEquals(18,result,0);
    }
}
