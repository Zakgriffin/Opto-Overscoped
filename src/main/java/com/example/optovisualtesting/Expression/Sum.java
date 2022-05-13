package com.example.optovisualtesting.Expression;

import com.example.optovisualtesting.ICollection;

public class Sum implements NumberExpression {
    ICollection<NumberExpression> terms;

    public Sum(ICollection<NumberExpression> terms) {
        this.terms = terms;
    }
}
