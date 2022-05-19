package com.example.optovisualtesting;

import com.example.optovisualtesting.Expression.Expression;
import com.example.optovisualtesting.Expression.NumberExpression;
import com.example.optovisualtesting.Expression.TypeStructure;

import java.util.List;

public class NumberVariable implements NumberExpression {
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
