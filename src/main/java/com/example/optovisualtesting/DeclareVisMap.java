package com.example.optovisualtesting;

import java.util.HashMap;
import java.util.Map;

public class DeclareVisMap {
    Map<Object, Object> declare_to_vis = new HashMap<>();
    Map<Object, Object> vis_to_declare = new HashMap<>();

    public void link(Object declare, Object vis) {
        declare_to_vis.put(declare, vis);
        vis_to_declare.put(vis, declare);
    }

    public Object to_vis(Object declare) {
        return declare_to_vis.get(declare);
    }

    public Object to_declare(Object vis) {
        return vis_to_declare.get(vis);
    }
}
