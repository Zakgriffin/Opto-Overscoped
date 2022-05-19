package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.Shape;

import java.util.Map;

public class SolidPainter implements Painter {
    Shape visual;
    Map<ShapePlacement, Color> shapePlacementToColors;

    // precondition - must be exhaustive map
    public SolidPainter(Map<ShapePlacement, Color> shapePlacementToColors) {
        this.shapePlacementToColors = shapePlacementToColors;
    }

    @Override
    public Color colorRGBAtPoint(Point point) {
        return shapePlacementToColors.get(visual.shapePlacementOfPoint(point));
    }
}
