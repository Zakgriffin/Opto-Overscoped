package com.example.optovisualtesting.Expression;

public enum Verification {
    TRUE,
    FALSE,
    UNKNOWN;

    public static Verification toVerification(boolean bool) {
        return bool ? TRUE : FALSE;
    }
}
