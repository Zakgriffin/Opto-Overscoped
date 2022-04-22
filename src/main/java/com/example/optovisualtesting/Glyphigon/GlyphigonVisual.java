package com.example.optovisualtesting.Glyphigon;

import com.example.optovisualtesting.Geometry.Point;
import com.example.optovisualtesting.Visual;
import javafx.scene.paint.Color;

public class GlyphigonVisual implements Visual {
    private final Glyphigon glyphigon;
    private final Color color;

    public GlyphigonVisual(Glyphigon glyphigon, Color color) {
        this.glyphigon = glyphigon;
        this.color = color;
    }

    @Override
    public boolean isWithin(Point point) {
        return glyphigon.isInside(point);
    }

    @Override
    public Color colorAtPoint(Point point) {
        return color;
    }
}
