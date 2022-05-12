package com.example.optovisualtesting.Geometry;

public interface Curve {
    int rayIntersect(Point point);

    int distanceToPoint(Point point);
}
