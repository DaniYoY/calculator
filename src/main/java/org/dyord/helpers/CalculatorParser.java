package org.dyord.helpers;

import org.dyord.exceptions.CalculatorException;
import org.dyord.helpers.CalculationAction;

public class CalculatorParser {

    private static final int EXPECTED_NUMBER_OF_ELEMENTS = 3;
    private static final int FIRST_ELEMENT_NUMBER = 0;
    private static final int SECOND_ELEMENT_NUMBER = 1;
    private static final int THIRD_ELEMENT_NUMBER = 2;
    private static final String PLUS_SIGN = "+";
    private static final String MINUS_SIGN = "-";
    private static final String MULTIPLICATION_SIGN = "*";
    private static final String DIVISION_SIGN = "/";

    private CalculatorParser() {
    }

    public static double  parse(String expression){
        if(null == expression){
            throw new CalculatorException(CalculatorException.WRONG_NUMBER_OF_ELEMENTS, 0);
        }
        String[] elements = expression.split(" ");
        if(elements.length != EXPECTED_NUMBER_OF_ELEMENTS){
            throw new CalculatorException(CalculatorException.WRONG_NUMBER_OF_ELEMENTS, elements.length);
        }
        double firstNumber = Double.parseDouble(elements[FIRST_ELEMENT_NUMBER]);
        String arithmeticOperator = elements[SECOND_ELEMENT_NUMBER];
        double secondNumber = Double.parseDouble(elements[THIRD_ELEMENT_NUMBER]);

        switch (arithmeticOperator) {
            case PLUS_SIGN:
                return CalculationAction.sum(firstNumber, secondNumber);
            case MINUS_SIGN:
                return CalculationAction.subtract(firstNumber, secondNumber);
            case MULTIPLICATION_SIGN:
                return CalculationAction.multiply(firstNumber, secondNumber);
            case DIVISION_SIGN:
                if(secondNumber == 0){
                    throw new CalculatorException(CalculatorException.ZERO_DIVISOR);
                }
                return CalculationAction.divide(firstNumber, secondNumber);
            default:
                throw new CalculatorException(CalculatorException.INCORRECT_OPERATOR, arithmeticOperator);
        }
    }
}
