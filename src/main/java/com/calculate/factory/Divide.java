package com.calculate.factory;

public class Divide implements Operation{
    @Override
    public Double calculate(Double num1, Double num2) {
        if (num2 != 0) {
            return (num1/num2);
        } else {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
    }
}
