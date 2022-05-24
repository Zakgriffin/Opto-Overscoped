package com.example.optovisualtesting.Math;

import java.util.List;

public interface Expression {
    String typeName();
    List<Expression> children();
    TypeStructure typeStructure();
}
