package com.calculate.factory;

public class Add implements Operation{
    @Override
    public Double calculate(Double num1, Double num2) {
        return num1 + num2;
    }
}
