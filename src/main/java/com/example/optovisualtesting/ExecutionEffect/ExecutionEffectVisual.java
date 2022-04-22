package com.example.optovisualtesting.ExecutionEffect;

import com.example.optovisualtesting.Geometry.Point;
import com.example.optovisualtesting.Visual;
import javafx.scene.paint.Color;

public class ExecutionEffectVisual implements Visual {

    @Override
    public boolean isWithin(Point point) {
        return false;
    }

    @Override
    public Color colorAtPoint(Point point) {
        return null;
    }
}
