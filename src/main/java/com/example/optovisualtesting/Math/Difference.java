package com.example.optovisualtesting.Math;

import java.util.List;

public class Difference implements NumberExpression {
    NumberExpression minuend;
    NumberExpression subtrahend;

    public Difference(NumberExpression minuend, NumberExpression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public String typeName() {
        return null;
    }

    @Override
    public List<Expression> children() {
        return null;
    }

    @Override
    public TypeStructure typeStructure() {
        return null;
    }
}
