package com.example.optovisualtesting.Expression;

import com.example.optovisualtesting.ICollection;

public class Product implements Expression {
    ICollection<Expression> factors;

    public Product(ICollection<Expression> factors) {
        this.factors = factors;
    }
}
