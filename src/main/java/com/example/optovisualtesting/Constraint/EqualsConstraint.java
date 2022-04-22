package com.example.optovisualtesting.Constraint;

public class EqualsConstraint<T> {
    private final T t1;
    private final T t2;

    public EqualsConstraint(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
}
