package com.example.optovisualtesting.Visuals;

import com.example.optovisualtesting.Visuals.Variations.Mut.OrderedGroupVisualMut;

public class Visuals {
    public static OrderedGroupVisual make_ordered_group_visual() {
        OrderedGroupVisual ordered_group_visual = new OrderedGroupVisual();
        OrderedGroupVisualMut ordered_group_visual_mut = new OrderedGroupVisualMut(ordered_group_visual);

//        OrderedGroupVisualVis = new OrderedGroupVisualVis();



        return ordered_group_visual;
    }

    public static Screen screen() {
        Screen screen = new Screen();

        return screen;
    }
}
