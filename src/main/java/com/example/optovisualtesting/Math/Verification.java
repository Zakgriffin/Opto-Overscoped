package com.example.optovisualtesting.Math;

public enum Verification {
    TRUE,
    FALSE,
    UNKNOWN;

    public static Verification toVerification(boolean bool) {
        return bool ? TRUE : FALSE;
    }
}
