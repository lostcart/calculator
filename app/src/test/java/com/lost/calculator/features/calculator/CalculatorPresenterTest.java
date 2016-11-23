package com.lost.calculator.features.calculator;

import com.lost.calculator.utils.CalculatorHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorPresenterTest {

    CalculatorPresenter calculatorPresenter;
    CalculatorPresenter.View view;

    @Before
    public void before() {
        view = Mockito.mock(CalculatorPresenter.View.class);
        calculatorPresenter = new CalculatorPresenter(view, new CalculatorHelper());
    }

    @Test
    public void addValue_addition() throws Exception {
        calculatorPresenter.addValue("1");
        calculatorPresenter.addValue("+");
        calculatorPresenter.addValue("2");
        calculatorPresenter.addValue("=");
        Mockito.verify(view).showMessage("3");
    }

    @Test
    public void addValue_subtraction() throws Exception {
        calculatorPresenter.addValue("5");
        calculatorPresenter.addValue("-");
        calculatorPresenter.addValue("1");
        calculatorPresenter.addValue("=");
        Mockito.verify(view).showMessage("4");
    }

    @Test
    public void addValue_division() throws Exception {
        calculatorPresenter.addValue("10");
        calculatorPresenter.addValue("÷");
        calculatorPresenter.addValue("4");
        calculatorPresenter.addValue("=");
        Mockito.verify(view).showMessage("2.5");
    }

    @Test
    public void addValue_multiplication() throws Exception {
        calculatorPresenter.addValue("3");
        calculatorPresenter.addValue("×");
        calculatorPresenter.addValue("15");
        calculatorPresenter.addValue("=");
        Mockito.verify(view).showMessage("45");
    }

    @Test
    public void addValue_everything() throws Exception {
        calculatorPresenter.addValue("1");
        calculatorPresenter.addValue("+");
        calculatorPresenter.addValue("2");
        calculatorPresenter.addValue("×");
        calculatorPresenter.addValue("4");
        calculatorPresenter.addValue("÷");
        calculatorPresenter.addValue("2");
        calculatorPresenter.addValue("=");
        Mockito.verify(view).showMessage("5");
    }
}