package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.Listener;
import com.example.optovisualtesting.ProcedurePaths;

import java.util.HashSet;
import java.util.Set;
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

    ProcedurePaths<Integer> setXListeners = new ProcedurePaths<>();
    public void setX(int x) {
        this.x = x;

        setXListeners.runAll(x);
    }

    ProcedurePaths<Integer> setYProcedures = new ProcedurePaths<>();
    public void setY(int y) {
        this.y = y;

        setYProcedures.runAll(y);
    }
}
