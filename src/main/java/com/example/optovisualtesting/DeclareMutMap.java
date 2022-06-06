package com.example.optovisualtesting;

import java.util.HashMap;
import java.util.Map;

public class DeclareMutMap {
    public Map<DeclareNode, MutNode> declare_to_mut = new HashMap<>();
    public Map<MutNode, DeclareNode> mut_to_declare = new HashMap<>();

    public void link(DeclareNode declare, MutNode mut) {
        declare_to_mut.put(declare, mut);
        mut_to_declare.put(mut, declare);
    }

    public MutNode to_mut(DeclareNode declare) {
        return declare_to_mut.get(declare);
    }

    public DeclareNode to_declare(MutNode mut) {
        return mut_to_declare.get(mut);
    }
}
