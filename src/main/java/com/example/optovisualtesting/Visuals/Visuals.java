package com.example.optovisualtesting.Visuals;

import com.example.optovisualtesting.*;
import com.example.optovisualtesting.Geometry.Circle;
import com.example.optovisualtesting.Geometry.Variations.Mut.CircleMut;
import com.example.optovisualtesting.Math.IntegerO;
import com.example.optovisualtesting.Visuals.Variations.Mut.OrderedGroupVisualMut;
import com.example.optovisualtesting.Visuals.Variations.Mut.ScreenMut;
import com.example.optovisualtesting.Visuals.Variations.Vis.OrderedGroupVisualVis;
import com.example.optovisualtesting.Visuals.Variations.Vis.ScreenVis;
import javafx.scene.image.PixelWriter;

public class Visuals {
    public static DeclareMutMap declare_to_mut_map = new DeclareMutMap();
    public static DeclareVisMap declare_to_vis_map = new DeclareVisMap();


    public static OrderedGroupVisual make_ordered_group_visual() {
        OrderedGroupVisual ordered_group_visual = new OrderedGroupVisual();
        OrderedGroupVisualMut ordered_group_visual_mut = new OrderedGroupVisualMut();
        OrderedGroupVisualVis ordered_group_visual_vis = new OrderedGroupVisualVis();

        return ordered_group_visual;
    }

    public static Screen make_screen(PixelWriter pixel_writer) {
        Screen screen = new Screen(pixel_writer);
        ScreenMut screen_mut = new ScreenMut();
        ScreenVis screen_vis = new ScreenVis();

        declare_to_mut_map.link(screen, screen_mut);
        declare_to_vis_map.link(screen, screen_vis);

        screen_mut.assign_full_visual_listeners.add((full_visual) -> {
            on_assign_full_visual_for_screen_vis(full_visual, screen_vis);
        });

        return screen;
    }

    public static void on_assign_full_visual_for_screen_vis(DeclareNode full_visual, ScreenVis screen_vis) {
        switch (full_visual.structure_type()) {
            case ORDERED_GROUP_VISUAL -> {
                OrderedGroupVisualMut ordered_group_visual_mut = (OrderedGroupVisualMut) mut_for_declare(full_visual, OrderedGroupVisualMut::new);
                OrderedGroupVisualVis ordered_group_visual_vis = (OrderedGroupVisualVis) vis_for_declare(full_visual, OrderedGroupVisualVis::new);

                ordered_group_visual_mut.assign_visuals_in_group_listeners.add_maybe_existing((visuals_in_group) -> {
                    on_assign_visuals_in_group_for_ordered_group_visual_for_screen_vis(visuals_in_group, screen_vis);
                });
            }
            default -> {

            }
        }
    }

    public static void on_assign_visuals_in_group_for_ordered_group_visual_for_screen_vis(DeclareNode visuals_in_group, ScreenVis screen_vis) {
        switch (visuals_in_group.structure_type()) {
            case ORDERED_SET -> {
                OrderedSet visuals_in_group_typed = (OrderedSet) visuals_in_group;
                visuals_in_group_typed.add_item_listeners.add_maybe_for_each_existing((visual_item) -> {
                    on_add_item_for_ordered_set_for_ordered_group_visual_for_screen_vis(visual_item, screen_vis);
                });
            }
            default -> {
            }
        }
    }

    public static void on_add_item_for_ordered_set_for_ordered_group_visual_for_screen_vis(DeclareNode visual_item, OrderedGroupVisualVis ordered_group_visual_vis) {
        switch (visual_item.structure_type()) {
            case TRANSLATED_VISUAL -> {
                TranslatedVisualVis translated_visual_vis = vis_for_declare(visual_item, () -> new TranslatedVisualVis());
                TranslatedVisualMut translated_visual_mut = mut_for_declare(visual_item, () -> new TranslatedVisualMut());

                translated_visual_vis.redraw_listeners.add((translated_visual) -> {
                    ordered_group_visual_vis.redraw_item_changed(translated_visual);
                });

                translated_visual_mut.assign_visual_listeners.add_maybe_existing((visual) -> {
                    on_assigned_as_visual_to_translated_visual(visual, translated_visual_vis);
                });

                translated_visual_mut.assign_translation_listeners.add_maybe_existing((translation) -> {
                    on_assign_point_for_translated_visual(translation, translated_visual_vis);
                });
            }
            case SHAPE_VISUAL -> {
                ShapeVisual shape_visual = (ShapeVisual) visual_item;

                ShapeVisualVis shape_visual_vis = vis_for_declare(shape_visual, () -> new ShapeVisualVis());
                ShapeVisualMut shape_visual_mut = mut_for_declare(shape_visual, () -> new ShapeVisualMut());

                shape_visual_vis.redraw_listeners.add((shape_visual) -> {
                    ordered_group_visual_vis.redraw_item_changed(shape_visual);
                });

                shape_visual_mut.assign_shape_listeners.add_maybe_existing((shape) -> {
                    on_assign_shape_for_shape_visual(shape, shape_visual_vis);
                });

                shape_visual_mut.assign_shape_painter_listeners.add_maybe_existing((shape_painter) -> {
                    on_assign_shape_painter_for_shape_visual(shape_painter, shape_visual_vis);
                });
            }
            default -> {
            }
        }
    }

    public static void on_assign_point_for_translated_visual(DeclareNode translation, TranslatedVisualVis translated_visual_vis) {
        switch (translation.structure_type()) {
            case POINT -> {
                Point point = (Point) translation;

                point.assign_x_listeners.add_maybe_existing((x) -> {
                    op(x, translated_visual_vis);
                });
                point.assign_y_listeners.add_maybe_existing((y) -> {
                    op(x, translated_visual_vis);
                });
            }
            default -> {
            }
        }
    }

    public static void op(DeclareNode x, TranslatedVisualVis translated_visual_vis) {
        switch (x.structure_type()) {
            case INTEGER -> {
                IntegerO integer = (IntegerO) x;
                integer_mut.update_listeners.add((i) -> {
                    translated_visual_vis.update_translation();
                });
            }
        }
    }

    public static void on_assigned_as_visual_to_translated_visual(DeclareNode visual, TranslatedVisualVis translated_visual_vis) {
        switch (visual.structure_type()) {
            case SHAPE_VISUAL -> {
                ShapeVisual shape_visual = (ShapeVisual) visual;

                ShapeVisualVis shape_visual_vis = vis_for_declare(shape_visual, () -> new ShapeVisualVis());
                ShapeVisualMut shape_visual_mut = mut_for_declare(shape_visual, () -> new ShapeVisualMut());

                shape_visual_vis.redraw_listeners.add(() -> {
                    translated_visual_vis.redraw_in_place();
                });

                shape_visual_mut.assign_shape_listeners.add_maybe_existing((shape) -> {
                    on_assign_shape_for_shape_visual(shape, shape_visual_vis);
                });

                shape_visual_mut.assign_shape_painter_listeners.add_maybe_existing((shape_painter) -> {
                    on_assign_shape_painter_for_shape_visual(shape_painter, shape_visual_vis);
                });
            }
            default -> {
            }
        }
    }

    public static void on_assign_shape_painter_for_shape_visual(DeclareNode shape_painter, ShapeVisualVis shape_visual_vis) {
        switch(shape_painter.structure_type()) {
            case SOLID_SHAPE_PAINTER -> {
                SolidShapePainter solid_shape_painter = (SolidShapePainter) shape_painter;

                solid_shape_painter_mut.assign_solid_color_listeners.add_maybe_existing((solid_color) -> {
                    on_assign_solid_color_for_solid_shape_painter_for_shape_visual(solid_color, shape_visual_vis);
                });
            }
            default -> {}
        }
    }

    public static void on_assign_solid_color_for_solid_shape_painter_for_shape_visual(DeclareNode solid_color, ShapeVisualVis shape_visual_vis) {
        switch (solid_color.structure_type()) {
            case RED_GREEN_BLUE_COLOR -> {
                RedGreenBlueColor red_green_blue_color = (RedGreenBlueColor) solid_color;

                red_green_blue_color_mut.update_listeners.add((red_green_blue_color_integer) -> {
                    shape_visual_vis.redraw_color_changed();
                });
            }
        }
    }

    public static void on_assign_shape_for_shape_visual(DeclareNode shape, ShapeVisualVis shape_visual_vis) {
        switch(shape.structure_type()) {
            case CIRCLE -> {
                Circle circle = (Circle) shape;

                circle_mut.assign_radius_listeners.add_maybe_existing((radius) -> {
                    lpo(radius, shape_visual_vis);
                });
            }
            default -> {}
        }
    }

    public static void lpo(DeclareNode radius, ShapeVisualVis shape_visual_vis) {
        switch (radius.structure_type()) {
            case INTEGER -> {
                IntegerO integer = (IntegerO) radius;
                integer_mut.update_listeners.add((i) -> {
                    shape_visual_vis.redraw_shape_changed();
                });
            }
        }
    }

    public static VisNode vis_for_declare(DeclareNode declare, VisGenerator vis_generator) {
        if (!declare_to_vis_map.declare_to_vis.containsKey(declare)) {
            declare_to_vis_map.link(declare, vis_generator.generate());
        }
        return declare_to_vis_map.to_vis(declare);
    }

    public static MutNode mut_for_declare(DeclareNode declare, MutGenerator mut_generator) {
        if (!declare_to_mut_map.declare_to_mut.containsKey(declare)) {
            declare_to_mut_map.link(declare, mut_generator.generate());
        }
        return declare_to_mut_map.to_mut(declare);
    }
}
