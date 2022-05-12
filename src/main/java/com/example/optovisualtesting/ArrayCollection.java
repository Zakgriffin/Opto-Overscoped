package com.example.optovisualtesting;

import java.util.Arrays;

public class ArrayCollection<T> implements ICollection<T> {
    T[] array;

    public ArrayCollection(T[] array) {
        this.array = array;
    }

    @Override
    public boolean contains(T item) {
        return Arrays.asList(array).contains(item);
    }
}
