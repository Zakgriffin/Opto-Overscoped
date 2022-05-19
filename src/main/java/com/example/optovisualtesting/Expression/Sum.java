package com.example.optovisualtesting.Expression;

import java.util.List;

public class Sum implements NumberExpression {
    NumberExpression[] terms;

    public Sum(NumberExpression[] terms) {
        this.terms = terms;
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
