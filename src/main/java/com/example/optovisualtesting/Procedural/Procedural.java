package com.example.optovisualtesting.Procedural;

public class Procedural {
    public static DoThen doThen( Effect effect, ControlFlowAction next) {
        return new DoThen(effect, next);
    }

    public static Add add(Mutable<Number> augend, Mutable<Number> addend) {
        return new Add(augend, addend);
    }

    public static <T> Copy<T> copy(Mutable<T> destination, Mutable<T> source) {
        return new Copy<>(destination, source);
    }
}
