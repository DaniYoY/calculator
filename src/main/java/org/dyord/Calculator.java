package org.dyord;

import org.dyord.exceptions.CalculatorException;
import org.dyord.helpers.CalculatorParser;

import java.util.Scanner;

public class Calculator {
    private static final String END_MSG = "end";
    private static final String WELCOME_MSG = String.format("Hi, enter arithmetic expressions on each line. To exit enter \"%s\"",END_MSG);
    private static final String EQUALS_SIGN = " = ";
    private static final String RUNTIME_EXCEPTION_MSG = "This cannot be handled. The program cannot process this number";
    private final Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    private void calculate() {
        System.out.println(WELCOME_MSG);
        while (scanner.hasNext()){
            String text = scanner.nextLine();
            if(END_MSG.equalsIgnoreCase(text)){
                break;
            }
            System.out.println(text + EQUALS_SIGN + CalculatorParser.parse(text));
        }
    }

    public void run() {
        try {
            calculate();
        }catch (CalculatorException ex){
            System.out.println(ex.getMessage());
        }catch (RuntimeException ex){
            System.out.println(RUNTIME_EXCEPTION_MSG);
        }
    }
}
