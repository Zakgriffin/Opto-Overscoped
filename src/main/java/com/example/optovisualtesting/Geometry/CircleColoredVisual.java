package com.example.optovisualtesting.Geometry;

import com.example.optovisualtesting.ColorRGBMatrix;

public class CircleColoredVisual implements ColoredVisual{
    ColoredVisual coloredVisual;
    Painter
    @Override
    public void drawWithinBoundingBox(ColorRGBMatrix colorRGBMatrix) {
        sampleByLineScan(coloredVisual, colorRGBMatrix);
    }
}
