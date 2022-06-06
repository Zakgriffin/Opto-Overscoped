package com.example.optovisualtesting;

import java.util.HashMap;
import java.util.Map;

public class DeclareVisMap {
    public Map<DeclareNode, VisNode> declare_to_vis = new HashMap<>();
    public Map<VisNode, DeclareNode> vis_to_declare = new HashMap<>();

    public void link(DeclareNode declare, VisNode vis) {
        declare_to_vis.put(declare, vis);
        vis_to_declare.put(vis, declare);
    }

    public VisNode to_vis(DeclareNode declare) {
        return declare_to_vis.get(declare);
    }

    public DeclareNode to_declare(VisNode vis) {
        return vis_to_declare.get(vis);
    }
}
