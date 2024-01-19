package com.calculate.factory;

import org.springframework.stereotype.Component;

@Component
public class OperationFactory {
    public Operation createOperation(String operationType) {
        switch (operationType) {
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            default:
                throw new IllegalArgumentException("Invalid operation type: " + operationType  +
                        " Enter the type of operation you want to perform as a single character.(Ex: + - / *)");
        }
    }

}
