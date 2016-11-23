package com.lost.calculator.features.calculator;

import com.lost.calculator.utils.Calculator;

public class CalculatorPresenter {
    private Calculator calculator;

    private View view;

    public CalculatorPresenter(View view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void addValue(String value) {
        view.showMessage(calculator.addValue(value));
    }

    public interface View {
        void showMessage(String message);
    }
}
