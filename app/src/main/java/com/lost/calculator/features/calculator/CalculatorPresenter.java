package com.lost.calculator.features.calculator;

import com.lost.calculator.utils.CalculatorHelper;

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
