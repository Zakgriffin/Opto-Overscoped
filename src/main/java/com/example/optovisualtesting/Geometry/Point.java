package com.example.optovisualtesting.Geometry;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + " )";
    }

    public static Point forBothComponents(Point p1, Point p2, BiFunction<Integer, Integer, Integer> f) {
        return new Point(f.apply(p1.x, p2.x), f.apply(p1.y, p2.y));
    }

}
