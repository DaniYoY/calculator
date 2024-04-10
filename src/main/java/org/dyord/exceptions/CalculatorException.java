package org.dyord.exceptions;

public class CalculatorException extends RuntimeException{
    public static final String WRONG_NUMBER_OF_ELEMENTS = "You have to provide 3 elements separated by space - 2 numbers and an arithmetic operator in between";
    public static final String INCORRECT_OPERATOR = "You have to provide proper arithmetic operator: + - * /";
    public static final String ZERO_DIVISOR = "Zero cannot be divisor!";

    public CalculatorException(String message) {
        super(message);
    }
    public CalculatorException(String message, String provided) {
        super(String.format("%s. You have provided %s",message, provided));
    }

    public CalculatorException(String message, int provided) {
        super(String.format("%s. You have provided %d",message, provided));
    }
}
