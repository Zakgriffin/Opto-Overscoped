package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.Geometry.Variations.RectangleV;
import com.example.optovisualtesting.Math.IntegerO;
import com.example.optovisualtesting.Procedural.Listeners;
import com.example.optovisualtesting.Visuals.ShapeInSpace;
import com.example.optovisualtesting.Visuals.ShapePlacement;

import static com.example.optovisualtesting.Geometry.Geometry.point;
import static com.example.optovisualtesting.Visuals.ShapePlacement.*;

public class Circle implements ShapeInSpace {
    IntegerO radius;

    Listeners<IntegerO> assign_radius_listeners = new Listeners<>();
    public void assign_radius(IntegerO radius) {
        this.radius = radius;

        assign_radius_listeners.runAll(radius);
    }

    public int squared_distance_to_point(Point point) {
        return (point.x * point.x + point.y * point.y) - (radius.i * radius.i);
    }

    @Override
    public int distance_to_point(Point point) {
        return (int) Math.sqrt(distance_to_point(point));
    }

    @Override
    public ShapePlacement shape_placement_of_point(Point point) {
        int distanceSquared = squared_distance_to_point(point);
        int radiusSquared = radius.i * radius.i;
        if(distanceSquared < radiusSquared) {
            return INSIDE;
        } else if(distanceSquared > radiusSquared) {
            return OUTSIDE;
        } else {
            return EDGE;
        }
    }

    @Override
    public RectangleV bounding_rectangle() {
        return new RectangleV(
                point(-radius.i, -radius.i),
                point(radius.i, radius.i)
        );
    }
}
