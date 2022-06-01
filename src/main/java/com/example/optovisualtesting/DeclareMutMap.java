package com.example.optovisualtesting;

import java.util.HashMap;
import java.util.Map;

public class DeclareMutMap {
    Map<Object, Object> declare_to_mut = new HashMap<>();
    Map<Object, Object> mut_to_declare = new HashMap<>();

    public void link(Object declare, Object mut) {
        declare_to_mut.put(declare, mut);
        mut_to_declare.put(mut, declare);
    }

    public Object to_mut(Object declare) {
        return declare_to_mut.get(declare);
    }

    public Object to_declare(Object mut) {
        return mut_to_declare.get(mut);
    }
}
