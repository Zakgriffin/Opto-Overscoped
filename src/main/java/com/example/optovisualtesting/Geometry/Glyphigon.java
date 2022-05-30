package com.example.optovisualtesting.Geometry;

public class Glyphigon {
    private Curve[] curves;

    public Glyphigon(Curve[] curves) {
        this.curves = curves;
    }

//    public int distanceToPoint(Point point) {
//        return H.findBest(curves, (curve) -> curve.distanceToPoint(point), Integer.MAX_VALUE);
//    }

//    public boolean isInside(Point p) {
//        int intersects = 0;
//        for (Curve curve : curves) {
//            intersects += curve.rayIntersect(p);
//        }
//        return intersects < 0;
//    }
}
