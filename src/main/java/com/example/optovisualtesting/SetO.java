package com.example.optovisualtesting;

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

    ProcedurePaths<Item> addProcedures = new ProcedurePaths<>();
    public void add(Item item) {
        set.add(item);

        addProcedures.runAll(item);
    }

    ProcedurePaths<Item> removeProcedures = new ProcedurePaths<>();
    public void remove(Item item) {
        set.remove(item);

        removeProcedures.runAll(item);
    }
}
