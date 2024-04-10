package org.dyord;

import org.dyord.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class CalculatorTests {
    private final InputStream sysInBackUp = System.in;
    private final PrintStream sysOutBackUp = System.out;
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    @Before
    public void setUpTests(){
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void tearDown(){
        System.setIn(sysInBackUp);
        System.setOut(sysOutBackUp);
    }

    @Test
    public void runShouldPrintNumberOnConsole(){
        String testExpression = "10 + 10";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testExpression.getBytes());
        System.setIn(testIn);

        String expected = String.format("Hi, enter arithmetic expressions on each line. To exit enter \"end\"%s%s = 20.0%s",
                System.lineSeparator(),
                testExpression,
                System.lineSeparator());

        Calculator calculator = new Calculator();
        calculator.run();

        Assert.assertEquals(expected,testOut.toString());
    }

    @Test
    public void runShouldEndWhenEndCommandIsGiven(){
        String testExpression = "end"+System.lineSeparator()+"10 + 10";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testExpression.getBytes());
        System.setIn(testIn);

        String expected = String.format("Hi, enter arithmetic expressions on each line. To exit enter \"end\"%s",
                System.lineSeparator());

        Calculator calculator = new Calculator();
        calculator.run();

        Assert.assertEquals(expected,testOut.toString());
    }

    @Test
    public void runShouldPrintCalculatorExceptionOnConsole(){
        String testExpression = "10 / 0";
        String testExceptionMessage = "Zero cannot be divisor!"+System.lineSeparator();
        ByteArrayInputStream testIn = new ByteArrayInputStream(testExpression.getBytes());
        System.setIn(testIn);

        String expected = String.format("Hi, enter arithmetic expressions on each line. To exit enter \"end\"%s%s",
                System.lineSeparator(),
                testExceptionMessage);

        Calculator calculator = new Calculator();
        calculator.run();

        Assert.assertEquals(expected,testOut.toString());
    }

    @Test
    public void runShouldPrintAnyTypeExceptionOnConsole(){
        String testExpression = "test / 0";
        String testExceptionMessage = "This cannot be handled. The program cannot process this number"+System.lineSeparator();
        ByteArrayInputStream testIn = new ByteArrayInputStream(testExpression.getBytes());
        System.setIn(testIn);

        String expected = String.format("Hi, enter arithmetic expressions on each line. To exit enter \"end\"%s%s",
                System.lineSeparator(),
                testExceptionMessage);

        Calculator calculator = new Calculator();
        calculator.run();

        Assert.assertEquals(expected,testOut.toString());
    }
}
