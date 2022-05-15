package com.example.optovisualtesting.Expression;

import java.util.Arrays;
import java.util.List;

public class Product implements Expression {
    Expression[] factors;

    public Product(NumberExpression[] factors) {
        this.factors = factors;
    }

    @Override
    public String typeName() {
        return "product";
    }

    @Override
    public List<Expression> children() {
        return Arrays.stream((Expression[]) factors).toList();
    }

    @Override
    public TypeStructure typeStructure() {
        return TypeStructure.PRODUCT;
    }

    @Override
    public void setChild(ProductChild whichChild, Expression[] factors) {

    }
}
