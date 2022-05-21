package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.ShapeInSpace;

import java.util.Map;

public class SolidShapePainter implements Painter {
    ShapeInSpace shapeInSpace;
    Map<ShapePlacement, Color> shapePlacementToColors;

    // precondition - must be exhaustive map
    public SolidShapePainter(ShapeInSpace shapeInSpace, Map<ShapePlacement, Color> shapePlacementToColors) {
        this.shapePlacementToColors = shapePlacementToColors;
    }

    @Override
    public Color colorAtPoint(Point point) {
        return shapePlacementToColors.get(shapeInSpace.shapePlacementOfPoint(point));
    }
}
