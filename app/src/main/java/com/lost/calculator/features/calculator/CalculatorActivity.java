package com.lost.calculator.features.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lost.calculator.R;
import com.lost.calculator.utils.Calculator;
import com.lost.calculator.utils.CalculatorSymbols;

public class CalculatorActivity extends AppCompatActivity implements CalculatorPresenter.View {

    private CalculatorPresenter calculatorPresenter;

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        resultTextView = (TextView) findViewById(R.id.calculator_textview_result);
        calculatorPresenter = new CalculatorPresenter(this, new Calculator(new CalculatorSymbols(this)));
    }

    @SuppressWarnings("unused")
    public void buttonOnClick(View view) {
        calculatorPresenter.addValue(((TextView) view).getText().toString());
    }

    @Override
    public void showMessage(String message) {
        resultTextView.setText(message);
    }
}
