package com.lost.calculator.utils;

public class CalculatorHelper {
    private CalculatorSymbols calculatorSymbols;
    private String currentEquation = "";

    public CalculatorHelper(CalculatorSymbols calculatorSymbols) {
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
        if (currentEquation.length() > 0) {
            String tempEquation = currentEquation;
            for (CalculatorSymbols.Symbol symbol : CalculatorSymbols.Symbol.values()) {
                String valueToReplace = calculatorSymbols.getValue(symbol);
                if (valueToReplace != null) {
                    tempEquation = tempEquation.replace(valueToReplace, symbol.toString());
                }
            }
            currentEquation = Double.toString(CalculatorUtils.evaluate(tempEquation));
            // Remove trailing .0
            if (currentEquation.endsWith(".0")) {
                currentEquation = currentEquation.substring(0, currentEquation.length() - 2);
            }
        }
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
