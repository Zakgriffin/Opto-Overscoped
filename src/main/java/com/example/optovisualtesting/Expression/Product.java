package com.example.optovisualtesting.Expression;

import com.example.optovisualtesting.ICollection;

public class Product implements NumberExpression {
    ICollection<NumberExpression> factors;

    public Product(ICollection<NumberExpression> factors) {
        this.factors = factors;
    }
}
