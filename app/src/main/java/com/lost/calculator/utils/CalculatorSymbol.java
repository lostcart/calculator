package com.lost.calculator.utils;

public enum CalculatorSymbol {
    DIVIDE("/", "÷"),
    MULTIPLY("*", "×"),
    ADDITION("+", "+"),
    SUBTRACTION("-", "-"),
    CLEAR("CLR", "CL"),
    EQUALS("=", "="),
    NONE("", "");

    private final String maths;
    private final String visual;

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