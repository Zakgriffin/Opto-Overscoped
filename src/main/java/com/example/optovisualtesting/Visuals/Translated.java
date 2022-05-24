package com.example.optovisualtesting.Visuals;

import com.example.optovisualtesting.Geometry.Point;

import static com.example.optovisualtesting.Geometry.Geometry.*;

public class Translated implements ShapeInSpace {
    ShapeInSpace visual;
    Point translation;



    public Translated(ShapeInSpace visual, Point position) {
        this.visual = visual;
        this.translation = position;
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
        return pointDifference(point, translation);
    }
}
