package com.example.optovisualtesting.Expression;

public class Difference implements NumberExpression {
    NumberExpression minuend;
    NumberExpression subtrahend;

    public Difference(NumberExpression minuend, NumberExpression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }
}
