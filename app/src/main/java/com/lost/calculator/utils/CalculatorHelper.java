package com.lost.calculator.utils;

/**
 * Handles what to do when different calculator functions are used
 */
public class CalculatorHelper {
    private String currentEquation = "";

    public CalculatorHelper() {
    }

    public String addValue(String value) {
        if (value != null) {
            CalculatorSymbol calculatorSymbol = CalculatorSymbol.getSymbol(value);
            switch (calculatorSymbol) {
                case DIVIDE:
                case MULTIPLY:
                case ADDITION:
                case SUBTRACTION:
                    addSymbol(calculatorSymbol);
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
            for (CalculatorSymbol calculatorSymbol : CalculatorSymbol.values()) {
                String valueToReplace = calculatorSymbol.getVisual();
                if (valueToReplace != null) {
                    tempEquation = tempEquation.replace(valueToReplace, calculatorSymbol.getMaths());
                }
            }
            currentEquation = Double.toString(CalculatorUtils.evaluate(tempEquation));
            // Remove trailing .0
            if (currentEquation.endsWith(".0")) {
                currentEquation = currentEquation.substring(0, currentEquation.length() - 2);
            }
        }
    }

    private void addSymbol(CalculatorSymbol calculatorSymbol) {
        if (currentEquation.length() > 0) {
            if (CalculatorSymbol.getSymbol(currentEquation.substring(currentEquation.length() - 1)) ==
                    CalculatorSymbol.NONE) {
                currentEquation += calculatorSymbol.getVisual();
            }
        }
    }
}
