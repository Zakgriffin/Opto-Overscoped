package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.BoundingBox;
import com.example.optovisualtesting.Shape;

import static com.example.optovisualtesting.Geometry.Geometry.*;

public class PositionedVisual implements Shape {
    Shape visual;
    Point position;

    public PositionedVisual(Shape visual, Point position) {
        this.visual = visual;
        this.position = position;
    }


    @Override
    public int distanceToPoint(Point point) {
        return visual.distanceToPoint(translatedPoint(point));
    }

    @Override
    public ShapePlacement shapePlacementOfPoint(Point point) {
        return visual.shapePlacementOfPoint(translatedPoint(point));
    }

    @Override
    public BoundingBox boundingBox() {
        BoundingBox localBoundingBox = visual.boundingBox();
        return new BoundingBox(
                translatedPoint(localBoundingBox.minimum),
                translatedPoint(localBoundingBox.maximum)
        );
    }

    Point translatedPoint(Point point) {
        return pointDifference(point, position);
    }
}
