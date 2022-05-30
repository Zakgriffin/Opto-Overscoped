package com.example.optovisualtesting.Geometry.Variations.Mut;

import com.example.optovisualtesting.Geometry.Point;
import com.example.optovisualtesting.Procedural.Listeners;

public class PointMut {
    Point point;

    Listeners<Integer> assign_x_listeners = new Listeners<>();
    public void assign_x(int x) {
        point.x = x;

        assign_x_listeners.runAll(x);
    }

    Listeners<Integer> assign_y_listeners = new Listeners<>();
    public void assign_y(int y) {
        point.y = y;

        assign_y_listeners.runAll(y);
    }
}
