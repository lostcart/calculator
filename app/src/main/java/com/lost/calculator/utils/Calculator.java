package com.lost.calculator.utils;

public class Calculator {
    private CalculatorSymbols calculatorSymbols;
    private String currentEquation = "";

    public Calculator(CalculatorSymbols calculatorSymbols) {
        this.calculatorSymbols = calculatorSymbols;
    }

    public String addValue(String value) {
        if (value != null) {
            CalculatorSymbols.Symbol symbol = calculatorSymbols.getSymbol(value);
            switch (symbol) {
                case DIVIDE:
                case MULTIPLY:
                case ADDITION:
                case SUBTRACTION:
                    addSymbol(symbol);
                    break;
                case CLEAR:
                    currentEquation = "";
                    break;
                case EQUALS:
                    computeCurrentEquation();
                    break;
                case NONE:
                    currentEquation += value;
                    break;
            }
        }
        return currentEquation;
    }

    private void computeCurrentEquation() {
        currentEquation = "YES!";
    }

    private void addSymbol(CalculatorSymbols.Symbol symbol) {
        if (currentEquation.length() > 0) {
            if (calculatorSymbols.getSymbol(currentEquation.substring(currentEquation.length() - 1)) ==
                    CalculatorSymbols.Symbol.NONE) {
                currentEquation += calculatorSymbols.getValue(symbol);
            }
        }
    }
}
