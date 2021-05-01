package com.android.calculator;

public class Calculator {
    public enum Operator{ADD, SUB, MUL, DIV}

    public double Add(double operand1, double operand2)
    {
        return operand1 + operand2;
    }
    public double Sub(double operand1, double operand2)
    {
        return operand1 - operand2;
    }
    public double Mul(double operand1, double operand2)
    {
        return operand1 * operand2;
    }
    public double Div(double operand1, double operand2)
    {
        return operand1 / operand2;
    }
}
