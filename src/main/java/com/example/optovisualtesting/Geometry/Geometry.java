package com.example.optovisualtesting.Geometry;

public class Geometry {
    private static final double TWO_PI = Math.PI * 2;
    private static final double FOUR_PI = Math.PI * 4;

    public static Point pointOpposite(Point oldPoint) {
        return new Point(-oldPoint.x, -oldPoint.y);
    }

    public static LineSegment lineSegmentTranslate(LineSegment oldLineSeg, Point p) {
        return new LineSegment(
                new Point(oldLineSeg.start.x + p.x, oldLineSeg.start.y + p.y),
                new Point(oldLineSeg.end.x + p.x, oldLineSeg.end.y + p.y)
        );
    }

    public static double distance(Point point1, Point point2) {
        return Math.sqrt(
                Math.pow(point2.x - point1.x, 2) +
                        Math.pow(point2.y - point1.y, 2)
        );
    }

    public static Point sum(Point... points) {
        Point sum = new Point(0, 0);
        for (Point p : points) {
            sum.x += p.x;
            sum.y += p.y;
        }
        return sum;
    }

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static int lerp(int a, int b, double t) {
        return (int) (a + (b - a) * t);
    }

    public static Point lerpPoint(Point a, Point b, double t) {
        return new Point(lerp(a.x, b.x, t), lerp(a.y, b.y, t));
    }

    public static double[] solveCubic(double co3, double co2, double co1, double co0) {
        // normalize coefficients.
        double denominator = co3;
        co3 = co2 / denominator;
        co2 = co1 / denominator;
        co1 = co0 / denominator;

        double a_over_3 = co3 / 3.0;
        double q = (3 * co2 - co3 * co3) / 9.0;
        double qCube = q * q * q;
        double r = (9 * co3 * co2 - 27 * co1 - 2 * co3 * co3 * co3) / 54.0;
        double rSqr = r * r;
        double idk = qCube + rSqr;

        if (idk < 0.0) {
            // three unequal real roots.
            double theta = Math.acos(r / Math.sqrt(-qCube));
            double SQRT_Q = Math.sqrt(-q);
            return new double[]{
                    2.0 * SQRT_Q * Math.cos(theta / 3.0) - a_over_3,
                    2.0 * SQRT_Q * Math.cos((theta + TWO_PI) / 3.0) - a_over_3,
                    2.0 * SQRT_Q * Math.cos((theta + FOUR_PI) / 3.0) - a_over_3
            };
        } else if (idk > 0.0) {
            // One real root.
            double SQRT_D = Math.sqrt(idk);
            double S = Math.cbrt(r + SQRT_D);
            double T = Math.cbrt(r - SQRT_D);
            return new double[]{
                    (S + T) - a_over_3
            };
        } else {
            // Three real roots, at least two equal.
            double cbrt_r = Math.cbrt(r);
            return new double[]{
                    2 * cbrt_r - a_over_3,
                    cbrt_r - a_over_3
            };
        }
    }

    public static double[] solveQuadratic(double a, double b, double c) {
        if(a <= 0) {
            return new double[] {};
        }
        double p = b * b - (4 * a * c);
        if(p < 0) {
            return new double[] {};
        }
        double x = Math.sqrt(p);
        return new double[]{
                (-b + x) / (2 * a),
                (-b - x) / (2 * a)
        };
    }
}
