package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;

public class RectangularRegion {
    Point topLeft;
    Point bottomRight;

    public RectangularRegion(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public int getWidth() {
        return bottomRight.x - topLeft.y;
    }

    public int getHeight() {
        return bottomRight.y - topLeft.y;
    }
}
