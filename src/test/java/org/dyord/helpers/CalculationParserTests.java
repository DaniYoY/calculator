package org.dyord.helpers;

import org.dyord.exceptions.CalculatorException;
import org.dyord.helpers.CalculatorParser;
import org.junit.Assert;
import org.junit.Test;

public class CalculationParserTests {

    @Test
    public void parseShouldThrowCalculatorExceptionWhenDivideByZero(){
        String expression = "10 / 0";
        Assert.assertThrows(CalculatorException.class, ()-> CalculatorParser.parse(expression));
    }
    @Test
    public void parseShouldThrowCalculatorExceptionWhenIncorrectOperator(){
        String expression = "10 as 10";
        Assert.assertThrows(CalculatorException.class, ()-> CalculatorParser.parse(expression));
    }
    @Test
    public void parseShouldThrowCalculatorExceptionWhenExpressionHasMoreElements(){
        String expression = "10 / 0 + 4";
        Assert.assertThrows(CalculatorException.class, ()-> CalculatorParser.parse(expression));
    }
    @Test
    public void parseShouldThrowCalculatorExceptionWhenExpressionHasLessElements(){
        String expression = "10 /";
        Assert.assertThrows(CalculatorException.class, ()-> CalculatorParser.parse(expression));
    }
    @Test
    public void parseShouldThrowCalculatorExceptionWhenExpressionHasNoElements(){
        String expression = "";
        Assert.assertThrows(CalculatorException.class, ()-> CalculatorParser.parse(expression));
    }
    @Test
    public void parseShouldThrowCalculatorExceptionWhenExpressionIsNull(){
        String expression = null;
        Assert.assertThrows(CalculatorException.class, ()-> CalculatorParser.parse(expression));
    }

    @Test
    public void parseShouldReturnResultWhenMultiplication(){
        String expression = "10 * 10";
        Assert.assertEquals(100, CalculatorParser.parse(expression),0);
    }
    @Test
    public void parseShouldReturnResultWhenDivition(){
        String expression = "10 / 10";
        Assert.assertEquals(1, CalculatorParser.parse(expression),0);
    }
    @Test
    public void parseShouldReturnResultWhenSubtraction(){
        String expression = "11 - 10";
        Assert.assertEquals(1, CalculatorParser.parse(expression),0);
    }

    @Test
    public void parseShouldReturnResultWhenAddition(){
        String expression = "10 + 10";
        Assert.assertEquals(20, CalculatorParser.parse(expression),0);
    }
}
