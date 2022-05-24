package com.example.optovisualtesting.Math;

import com.example.optovisualtesting.Procedural.Listeners;

import java.util.HashSet;
import java.util.Set;

public class SetO<Item> {
    Set<Item> set;

    public SetO(Set<Item> set) {
        this.set = set;
    }

    public SetO() {
        this(new HashSet<>());
    }

    Listeners<Item> addProcedures = new Listeners<>();
    public void add(Item item) {
        set.add(item);

        addProcedures.runAll(item);
    }

    Listeners<Item> removeProcedures = new Listeners<>();
    public void remove(Item item) {
        set.remove(item);

        removeProcedures.runAll(item);
    }
}
