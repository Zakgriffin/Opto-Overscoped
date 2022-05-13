package com.example.optovisualtesting.Procedural;

public class Copy<T> {
    Mutable<T> destination;
    Mutable<T> source;

    public Copy(Mutable<T> destination, Mutable<T> source) {
        this.destination = destination;
        this.source = source;
    }
}
