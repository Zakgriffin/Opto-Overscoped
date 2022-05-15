package com.example.optovisualtesting.Expression;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpressionBuilder {
    Expression root;
    Map<Expression, List<VerifiedProposition>> constraintsToUpdateByExpression;
    Set<VerifiedProposition> allConstraints;
    boolean hasValidTypeChecking;

    public void setRoot(Expression root) {
        this.root = root;
    }

    public void updateChild(Expression expressionInGraph, Expression child) {
        expressionInGraph.setChild(whichChild, child);

        expressionInGraph.validateChildType();
    }
}
