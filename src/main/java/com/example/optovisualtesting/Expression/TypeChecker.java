package com.example.optovisualtesting.Expression;

public class TypeChecker {
    public static Verification isZero(Expression expression) {
        switch(expression.typeStructure()) {
            case PRODUCT -> {
                return Verification.TRUE;
            }
            default -> {
                return Verification.UNKNOWN;
            }
        }
    }
}
