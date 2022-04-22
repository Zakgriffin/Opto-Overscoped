package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;
import javafx.scene.paint.Color;

public interface Visual {
    boolean isWithin(Point point);

    Color colorAtPoint(Point point);
}
