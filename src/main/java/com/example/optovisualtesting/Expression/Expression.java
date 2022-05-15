package com.example.optovisualtesting.Expression;

import java.util.List;

public interface Expression {
    String typeName();
    List<Expression> children();
    TypeStructure typeStructure();
}
