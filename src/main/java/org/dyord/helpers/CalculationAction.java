package org.dyord.helpers;

public class CalculationAction {

    public static double sum(double addendA, double addendB){
        return addendA + addendB;
    }

    public static double subtract(double minuend, double subtrahend){
        return minuend - subtrahend;
    }

    public static double multiply(double multiplier, double multiplicand){
        return multiplier*multiplicand;
    }

    public static double divide(double dividend, double divisor){
        return dividend/divisor;
    }

    private CalculationAction() {
    }
}
