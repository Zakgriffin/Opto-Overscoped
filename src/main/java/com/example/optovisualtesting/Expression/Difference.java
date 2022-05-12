package com.example.optovisualtesting.Expression;

public class Difference implements Expression {
    Expression minuend;
    Expression subtrahend;

    public Difference(Expression minuend, Expression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }
}
