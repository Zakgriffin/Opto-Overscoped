package com.example.optovisualtesting.Visuals.Variations.Mut;

import com.example.optovisualtesting.Math.OrderedSet;
import com.example.optovisualtesting.Procedural.Listeners;
import com.example.optovisualtesting.Visuals.OrderedGroupVisual;

public class OrderedGroupVisualMut {
    OrderedGroupVisual ordered_group_visual;

    public OrderedGroupVisualMut(OrderedGroupVisual ordered_group_visual) {
        this.ordered_group_visual = ordered_group_visual;

        // set exists, apply to all existing
        // no set, add listener for when added
        // if visuals_in_group unassigned, propagate to children

//        if(ordered_group_visual.visuals_in_group == null) {
//            assign_visuals_in_group_listeners.add((visuals_in_group_mut) -> {
//                if(visuals_in_group_mut instanceof OrderedSet visuals_in_group_mut_typed) {
//                    visuals_in_group_mut_typed.(ordered_set_mut_typed);
//                }
//            });
//        } else {
//            ordered_group_visual.visuals_in_group.mut.for_each_resent(() -> {
//
//            });
//            ordered_group_visual.visuals_in_group.mut().add_item_listeners.add(() -> {
//
//            });
//            ordered_group_visual.visuals_in_group.mut().remove_item_listeners(() -> {
//
//            });
//        }
    }

    public Listeners<Object> assign_visuals_in_group_listeners = new Listeners<>();
    public void assign_visuals_in_group(Object visuals_in_group) {
        ordered_group_visual.visuals_in_group = visuals_in_group;

        assign_visuals_in_group_listeners.runAll(visuals_in_group);
    }

    public Listeners<Object> unassign_visuals_in_group_listeners = new Listeners<>();
    public void unassign_visuals_in_group() {
        ordered_group_visual.visuals_in_group = null;

        assign_visuals_in_group_listeners.runAll(null);
    }
}
