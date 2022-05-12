package com.example.optovisualtesting.Geometry;

public class BezierCurve implements Curve {
    private final Point a, b, c, d;

    public BezierCurve(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Point lerp(double t) {
        Point ab = Geometry.lerpPoint(a, b, t);
        Point bc = Geometry.lerpPoint(b, c, t);
        Point cd = Geometry.lerpPoint(c, d, t);

        Point abbc = Geometry.lerpPoint(ab, bc, t);
        Point bccd = Geometry.lerpPoint(bc, cd, t);

        return Geometry.lerpPoint(abbc, bccd, t);
    }

    @Override
    public int rayIntersect(Point point) {
        return rayIntersectionCount(point);
    }

    @Override
    public int distanceToPoint(Point point) {
        return 0;
    }

    public int rayIntersectionCount(Point point) {
        int sum = 0;
        for(double time : findTimesYieldingY(point.y)) {
            if(time < 0 || time > 1) continue;
            if(lerp(time).x < point.x) continue;

            double dy = findYDerivativeAtTime(time);
            if(dy > 0) {
                sum += 1;
            } else if(dy < 0) {
                sum -= 1;
            }
        }
        return sum;
    }

    private double findYDerivativeAtTime(double t) {
        int ay = this.a.y;
        int by = this.b.y;
        int cy = this.c.y;
        int dy = this.d.y;

        return (3 * dy - 9 * cy + 9 * by - 3 * ay) * t * t +
                (6 * cy - 12 * by + 6 * ay) * t +
                3 * by - 3 * ay;
    }

    public double[] findTimesYieldingY(int y) {
        int aCo = this.a.y - y;
        int bCo = this.b.y - y;
        int cCo = this.c.y - y;
        int dCo = this.d.y - y;

        return Geometry.solveCubic(
                dCo - 3 * cCo + 3 * bCo - aCo,
                3 * cCo - 6 * bCo + 3 * aCo,
                3 * bCo - 3 * aCo,
                aCo
        );
    }
}
