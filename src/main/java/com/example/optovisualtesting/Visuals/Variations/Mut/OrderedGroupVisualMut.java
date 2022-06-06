package com.example.optovisualtesting.Visuals.Variations.Mut;

import com.example.optovisualtesting.DeclareNode;
import com.example.optovisualtesting.MutNode;
import com.example.optovisualtesting.Procedural.Listeners;
import com.example.optovisualtesting.Visuals.OrderedGroupVisual;

import static com.example.optovisualtesting.Visuals.Visuals.declare_to_mut_map;

public class OrderedGroupVisualMut implements MutNode {
    public ListenersWithOnceHistory<DeclareNode> assign_visuals_in_group_listeners = new Listeners<>();
    public void assign_visuals_in_group(DeclareNode visuals_in_group) {
        assign_visuals_in_group_listeners.runAll(visuals_in_group);

        ((OrderedGroupVisual)declare_to_mut_map.to_declare(this)).visuals_in_group = visuals_in_group;
    }
}
