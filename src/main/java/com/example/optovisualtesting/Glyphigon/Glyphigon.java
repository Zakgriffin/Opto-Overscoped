package com.example.optovisualtesting.Glyphigon;

import com.example.optovisualtesting.Geometry.Curve;
import com.example.optovisualtesting.Geometry.Point;

public class Glyphigon {
    private Curve[] curves;

    public Glyphigon(Curve[] curves) {
        this.curves = curves;
    }

    public boolean isInside(Point p) {
        int intersects = 0;
        for (Curve curve : curves) {
            intersects += curve.rayIntersect(p);
        }
        return intersects < 0;
    }
}
