package com.example.optovisualtesting.Expression;

import com.example.optovisualtesting.ICollection;

public class Sum implements Expression {
    ICollection<Expression> terms;

    public Sum(ICollection<Expression> terms) {
        this.terms = terms;
    }
}
