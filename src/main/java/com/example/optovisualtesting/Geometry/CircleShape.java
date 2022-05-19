package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.BoundingBox;
import com.example.optovisualtesting.Shape;

import static com.example.optovisualtesting.Geometry.ShapePlacement.*;

public class CircleShape implements Shape {
    Circle circle;

    public CircleShape(Circle circle) {
        this.circle = circle;
    }

    public int squaredDistanceToPoint(Point point) {
        return (point.x * point.x + point.y * point.y) - (circle.radius * circle.radius);
    }

    @Override
    public int distanceToPoint(Point point) {
        return (int) Math.sqrt(distanceToPoint(point));
    }

    @Override
    public ShapePlacement shapePlacementOfPoint(Point point) {
        int distanceSquared = squaredDistanceToPoint(point);
        int radiusSquared = circle.radius * circle.radius;
        if(distanceSquared < radiusSquared) {
            return INSIDE;
        } else if(distanceSquared > radiusSquared) {
            return OUTSIDE;
        } else {
            return EDGE;
        }
    }

    @Override
    public BoundingBox boundingBox() {
        return new BoundingBox(
                new Point(-circle.radius, -circle.radius),
                new Point(circle.radius, circle.radius)
        );
    }
}
