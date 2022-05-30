package com.example.optovisualtesting.Geometry.Variations.Mut;

import com.example.optovisualtesting.Geometry.Circle;
import com.example.optovisualtesting.Math.IntegerO;
import com.example.optovisualtesting.Procedural.Listeners;

public class CircleMut {
    Circle circle;

    Listeners<IntegerO> assign_radius_listeners = new Listeners<>();

    public void assign_radius(IntegerO radius) {
        circle.radius = radius;

        assign_radius_listeners.runAll(radius);
    }
}
