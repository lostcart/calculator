package com.lost.calculator.utils;

import android.content.Context;

import com.lost.calculator.R;

public class CalculatorSymbols {
    private String divide;
    private String multiply;
    private String addition;
    private String subtraction;
    private String clear;
    private String equals;

    public enum Symbol {
        DIVIDE,
        MULTIPLY,
        ADDITION,
        SUBTRACTION,
        CLEAR,
        EQUALS,
        NONE
    }

    public CalculatorSymbols(Context context) {
        this.divide = context.getString(R.string.symbol_divide);
        this.multiply = context.getString(R.string.symbol_multiply);
        this.addition = context.getString(R.string.symbol_addition);
        this.subtraction = context.getString(R.string.symbol_subtract);
        this.clear = context.getString(R.string.symbol_clear);
        this.equals = context.getString(R.string.symbol_equals);
    }

    public String getValue(Symbol symbol) {
        switch (symbol) {
            case DIVIDE:
                return divide;
            case MULTIPLY:
                return multiply;
            case ADDITION:
                return addition;
            case SUBTRACTION:
                return subtraction;
            case CLEAR:
                return clear;
            case EQUALS:
                return equals;
            case NONE:
            default:
                return null;
        }
    }

    public Symbol getSymbol(String character) {
        Symbol symbol = Symbol.NONE;
        if (character.equals(divide)) {
            symbol = Symbol.DIVIDE;
        } else if (character.equals(multiply)) {
            symbol = Symbol.MULTIPLY;
        } else if (character.equals(addition)) {
            symbol = Symbol.ADDITION;
        } else if (character.equals(subtraction)) {
            symbol = Symbol.SUBTRACTION;
        } else if (character.equals(clear)) {
            symbol = Symbol.CLEAR;
        } else if (character.equals(equals)) {
            symbol = Symbol.EQUALS;
        }
        return symbol;
    }
}
