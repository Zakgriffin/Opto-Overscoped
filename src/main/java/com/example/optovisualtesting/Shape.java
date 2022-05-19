package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;
import com.example.optovisualtesting.Geometry.ShapePlacement;

public interface Shape {
    int distanceToPoint(Point point);
    ShapePlacement shapePlacementOfPoint(Point point);
    BoundingBox boundingBox();
}
