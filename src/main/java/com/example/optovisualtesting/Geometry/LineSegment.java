package com.example.optovisualtesting.Geometry;

public class LineSegment implements Curve {
    Point start;
    Point end;

    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int rayIntersect(Point point) {
        LineSegment newSeg = Geometry.lineSegmentTranslate(this, Geometry.pointOpposite(point));
        boolean onBothSides = (newSeg.start.y < 0) ^ (newSeg.end.y < 0);
        if (onBothSides) {
            int verticalTrend = newSeg.start.y - newSeg.end.y;
            int orientationWithOrigin = newSeg.start.x * newSeg.end.y - newSeg.start.y * newSeg.end.x;
            if (verticalTrend > 0 ^ orientationWithOrigin > 0) {
                if (verticalTrend > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    @Override
    public Number distanceToPoint(Point point) {
        Function pointOnLineAtTime = lerp(start, end);
        Variable t = variable();
        Expression toMinimize = distanceBetweenPoints(point, pointOnLineAtTime(t));
        return minimum(toMinimize, set(t));
    }
}
