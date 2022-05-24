package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.Procedural.Listeners;

public class Point {
    public Integer x;
    public Integer y;

    Listeners<Integer> assign_x_listeners = new Listeners<>();
    public void assign_x(int x) {
        this.x = x;

        assign_x_listeners.runAll(x);
    }

    Listeners<Integer> assign_y_listeners = new Listeners<>();
    public void assign_y(int y) {
        this.y = y;

        assign_y_listeners.runAll(y);
    }
}
