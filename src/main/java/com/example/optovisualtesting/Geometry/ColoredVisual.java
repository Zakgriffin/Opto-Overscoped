package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.*;

public interface ColoredVisual {

    ShapeInSpace visual;
    Painter colorizer;
    // precondition - colorRGBMatrix correct size
    void drawWithinBoundingBox(ColorRGBMatrix colorRGBMatrix);

    static void sampleByLineScan(ShapeInSpace visual, ColorRGBMatrix colorRGBMatrix) {
        for (int x = 0; x < colorRGBMatrix.size.x; x++) {
            for (int y = 0; y < colorRGBMatrix.size.y; y++) {
                colorRGBMatrix.setAtXYIndex(x, y, visual.col);
            }
        }
    }
}
