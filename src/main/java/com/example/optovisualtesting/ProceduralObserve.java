package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Circle;

public class ProceduralObserve {
    public static Circle circle(Int radius) {
        Circle circle = new Circle(radius);

        radius.changePaths.add(() -> {
            circle.setRadius(radius);
        });

        return circle;
    }
}
