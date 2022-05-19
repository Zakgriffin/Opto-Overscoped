package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;

public class ColorRGBMatrix {
    public int[] compactColorRGBs;
    public Point size;

    public ColorRGBMatrix(Point size) {
        this.compactColorRGBs = new int[size.x * size.y];
        this.size = size;
    }

    public void setAtPointIndex(Point pointIndex, Color colorRGB) {
        compactColorRGBs[pointToIndex(pointIndex)] = colorRGBToCompact(colorRGB);
    }

    public Color atPointIndex(Point pointIndex) {
        return compactToColorRGB(compactColorRGBs[pointToIndex(pointIndex)]);
    }

    public int pointToIndex(Point point) {
        return point.x + point.y * size.x;
    }

    // precondition - all range 0 - 255
    public int colorRGBToCompact(Color colorRGB) {
        return 0xFF000000 | (colorRGB.red << 16) | (colorRGB.green << 8) | colorRGB.blue;
    }

    public Color compactToColorRGB(int compactColorRGB) {
        return new Color(
                (compactColorRGB >> 16) & 0x000000FF,
                (compactColorRGB >> 8) & 0x000000FF,
                compactColorRGB & 0x000000FF
        );
    }
}
