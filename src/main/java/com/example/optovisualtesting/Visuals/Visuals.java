package com.example.optovisualtesting.Visuals;

import com.example.optovisualtesting.DeclareMutMap;
import com.example.optovisualtesting.Geometry.Circle;
import com.example.optovisualtesting.Geometry.Variations.Mut.CircleMut;
import com.example.optovisualtesting.Screen;
import com.example.optovisualtesting.Visuals.Variations.Mut.OrderedGroupVisualMut;

public class Visuals {
    static DeclareMutMap declare_to_mut_map = new DeclareMutMap();
    static DeclareMutMap declare_to_vis_map = new DeclareVisMap();


    public static OrderedGroupVisual make_ordered_group_visual() {
        OrderedGroupVisual ordered_group_visual = new OrderedGroupVisual();
        OrderedGroupVisualMut ordered_group_visual_mut = new OrderedGroupVisualMut(ordered_group_visual);

        OrderedGroupVisualVis = new OrderedGroupVisualVis();



        return ordered_group_visual;
    }

    public static Screen make_screen() {
        Screen screen = new Screen();
        ScreenMut screen_mut = new ScreenMut();
        ScreenVis screen_vis = new ScreenVis();

        declare_to_mut_map.link(screen, screen_mut);
        declare_to_vis_map.link(screen, screen_vis);

        screen_mut.assign_visual_listeners.add((visual) -> {
            on_assigned_as_screen_visual(visual);
        });

        return screen;
    }

    public static void on_assigned_as_screen_visual(DeclareNode visual, ScreenVis screen_vis) {
        switch(visual.structure_type()) {
            case ORDERED_GROUP_VISUAL -> {
                OrderedGroupVisual visual_typed = (OrderedGroupVisual) visual;
                visual_typed.assign_visuals_in_group_listeners.add_maybe_existing((visuals_in_group) -> {
                    on_assigned_as_visuals_in_group(visuals_in_group, screen_vis);
                });
            }
            default -> {

            }
        }
    }

    public static void on_assigned_as_visuals_in_group(DeclareNode visuals_in_group, ScreenVis screen_vis) {
        switch(visuals_in_group.structure_type()) {
            case ORDERED_COLLECTION -> {
                OrderedSet visuals_in_group_typed = (OrderedSet) visuals_in_group;
                visuals_in_group_typed.add_item_listeners.add_maybe_for_each_existing((visual_item_with_index) -> {
                    on_assigned_as_visual_in_visuals_in_group(visual_item_with_index, screen_vis);
                });
            }
            default -> {}
        }
    }

    public static void on_assigned_as_visual_in_visuals_in_group(VisualItemWithIndex visual_item_with_index, ScreenVis screen_vis) {
        DeclareNode visual_item = visual_item_with_index.visual_item;
        int index = visual_item_with_index.index;
        switch(visual_item.structure_type()) {
            case TRANSLATED_VISUAL -> {
                TranslatedVisualVis translated_visual_vis = new TranslatedVisualVis();
                TranslatedVisualMut translated_visual_mut = declare_to_mut_map.to_mut(visual_item);
                declare_to_vis_map.link(translated_visual, translated_visual_vis);

                translated_visual_mut.update_painted_visual(() -> {

                })

                translated_visual_mut.assign_painted_visual_listeners.add_maybe_existing((painted_visual) -> {
                   on_assigned_as_visual_to_translated_visual(painted_visual, translated_visual);
                });
            }
            case PAINTED_SHAPE -> {
                // TODO -------
            }
        }
    }

    public static void on_assigned_as_visual_to_translated_visual(DeclareNode visual, TranslatedVisual translated_visual) {

    }

    public static Circle make_circle() {
        Circle circle = new Circle();
        CircleMut circle_mut = new CircleMut();
        declare_to_mut_map.link(circle, circle_mut);

        return circle;
    }
}
