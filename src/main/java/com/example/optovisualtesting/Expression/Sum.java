package com.example.optovisualtesting.Expression;

public class Sum implements NumberExpression {
    NumberExpression[] terms;

    public Sum(NumberExpression[] terms) {
        this.terms = terms;
    }
}
