package com.lost.calculator.features.calculator;

import com.lost.calculator.utils.CalculatorHelper;

/**
 * Takes in calculator input and returns formatted responses to the view
 */
public class CalculatorPresenter {
    private CalculatorHelper calculatorHelper;

    private View view;

    public CalculatorPresenter(View view, CalculatorHelper calculatorHelper) {
        this.view = view;
        this.calculatorHelper = calculatorHelper;
    }

    public void addValue(String value) {
        view.showMessage(calculatorHelper.addValue(value));
    }

    public interface View {
        void showMessage(String message);
    }
}
