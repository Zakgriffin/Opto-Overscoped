package com.example.optovisualtesting.VerticalSpacedGroup;

import com.example.optovisualtesting.Geometry.Geometry;
import com.example.optovisualtesting.Geometry.Point;
import com.example.optovisualtesting.Visual;
import javafx.scene.paint.Color;

public class VerticalSpacedGroupVisual implements Visual {
    private final Visual[] children;
    int spacingPixels;

    public VerticalSpacedGroupVisual(Visual[] children, int spacingPixels) {
        this.children = children;
        this.spacingPixels = spacingPixels;
    }

    @Override
    public boolean isWithin(Point point) {
        for (int i = 0; i < children.length; i++) {
            Visual child = children[i];
            Point translatedPoint = Geometry.sum(point, new Point(0, -spacingPixels * i));
            if(child.isWithin(translatedPoint)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Color colorAtPoint(Point point) {
        for (int i = 0; i < children.length; i++) {
            Visual child = children[i];
            Point translatedPoint = Geometry.sum(point, new Point(0, -spacingPixels * i));
            if (child.isWithin(translatedPoint)) {
                return child.colorAtPoint(translatedPoint);
            }
        }
        return null;
    }
}
