            package com.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mOperandOne;
    private EditText mOperandTwo;
    private TextView mresultView;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalculator = new Calculator();

        mOperandOne = findViewById(R.id.operandOneEditTxt);
        mOperandTwo = findViewById(R.id.operandTwoEditTxt);
        mresultView = findViewById(R.id.resultView);

    }

    public void add(View view) {
        try {
            String operand1 = mOperandOne.getText().toString();
            String operand2 = mOperandTwo.getText().toString();

            double result = mCalculator.Add(Double.valueOf(operand1), Double.valueOf(operand2));
            mresultView.setText(String.valueOf(result));
        }
        catch (NumberFormatException e)
        {
            mresultView.setText(getString(R.string.computationError));
            return;
        }

    }

    public void sub(View view) {
        try {
            String operand1 = mOperandOne.getText().toString();
            String operand2 = mOperandTwo.getText().toString();

            double result = mCalculator.Sub(Double.valueOf(operand1), Double.valueOf(operand2));
            mresultView.setText(String.valueOf(result));
        }
        catch (NumberFormatException e)
        {
            mresultView.setText(getString(R.string.computationError));
            return;
        }
    }

    public void mul(View view) {
        String operand1 = mOperandOne.getText().toString();
        String operand2 = mOperandTwo.getText().toString();

        double result = mCalculator.Mul(Double.valueOf(operand1), Double.valueOf(operand2));
        mresultView.setText(String.valueOf(result));
    }

    public void div(View view) {
        String operand1 = mOperandOne.getText().toString();
        String operand2 = mOperandTwo.getText().toString();

        double result = mCalculator.Div(Double.valueOf(operand1), Double.valueOf(operand2));
        mresultView.setText(String.valueOf(result));
    }
}