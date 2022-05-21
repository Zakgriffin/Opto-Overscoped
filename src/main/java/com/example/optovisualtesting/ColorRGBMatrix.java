package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;

public class ColorRGBMatrix {
    public int[] compactColorRGBs;
    public Point size;

    public ColorRGBMatrix(Point size) {
        this.compactColorRGBs = new int[size.x * size.y];
        this.size = size;
    }

    public void setAtPointIndex(Point pointIndex, ColorRGB colorRGB) {
        compactColorRGBs[pointToIndex(pointIndex)] = colorRGBToCompact(colorRGB);
    }

    public ColorRGB atPointIndex(Point pointIndex) {
        return ColorRGB.compactToColorRGB(compactColorRGBs[pointToIndex(pointIndex)]);
    }

    public int pointToIndex(Point point) {
        return point.x + point.y * size.x;
    }

    // precondition - all range 0 - 255
    public int colorRGBToCompact(ColorRGB colorRGB) {
        return 0xFF000000 | (colorRGB.red << 16) | (colorRGB.green << 8) | colorRGB.blue;
    }
}
