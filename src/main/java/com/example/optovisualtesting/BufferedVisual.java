package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Painter;
import com.example.optovisualtesting.Geometry.Point;

public class BufferedVisual {
    ColorRGBMatrix buffer;
    Painter painter;

    public BufferedVisual() {
        painter.on
    }

    public void redrawBuffer() {
        for(int x = 0; x < buffer.size.x; x++) {
            for(int y = 0; y < buffer.size.y; y++) {
                Point p = new Point(x, y);
                buffer.setAtPointIndex(p, painter.colorAtPoint(p).toRGB());
            }
        }
    }
}
