package com.lost.calculator.utils;

/**
 * Enum to help map the visual symbols used in the calculator to the mathmatical symbols
 * that we need to do the calculations
 */
public enum CalculatorSymbol {
    DIVIDE("/", "÷"),
    MULTIPLY("*", "×"),
    ADDITION("+"),
    SUBTRACTION("-"),
    CLEAR("CL"),
    EQUALS("="),
    NONE("");

    private final String maths;
    private final String visual;

    CalculatorSymbol(String maths) {
        this.maths = maths;
        this.visual = maths;
    }

    CalculatorSymbol(String maths, String visual) {
        this.maths = maths;
        this.visual = visual;
    }

    public String getVisual() {
        return visual;
    }

    public String getMaths() {
        return maths;
    }

    public static CalculatorSymbol getSymbol(String character) {
        CalculatorSymbol returnCalculatorSymbol = CalculatorSymbol.NONE;
        for (CalculatorSymbol calculatorSymbol : CalculatorSymbol.values()) {
            if (calculatorSymbol.getVisual().equals(character)) {
                returnCalculatorSymbol = calculatorSymbol;
                break;
            }
        }
        return returnCalculatorSymbol;
    }
}