package com.example.optovisualtesting.Geometry;

public class Rectangle {
    public Integer width;
    public Integer height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean point_is_within(Point point) {
        return point.x >= 0 && point.y >= 0 && point.x <= width && point.y <= height;
    }
}
