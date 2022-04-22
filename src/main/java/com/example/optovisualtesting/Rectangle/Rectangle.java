package com.example.optovisualtesting.Rectangle;

import com.example.optovisualtesting.Geometry.Point;

public class Rectangle {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean pointIsWithin(Point point) {
        return point.x >= 0 && point.y >= 0 && point.x <= width && point.y <= height;
    }
}
