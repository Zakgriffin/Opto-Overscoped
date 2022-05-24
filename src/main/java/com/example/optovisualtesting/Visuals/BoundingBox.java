package com.example.optovisualtesting.Visuals;

import com.example.optovisualtesting.Geometry.Point;

import static com.example.optovisualtesting.Geometry.Geometry.pointDifference;

public class BoundingBox {
    public Point minimum;
    public Point maximum;

    public BoundingBox(Point minimum, Point maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Point size() {
        return pointDifference(maximum, minimum);
    }
}
