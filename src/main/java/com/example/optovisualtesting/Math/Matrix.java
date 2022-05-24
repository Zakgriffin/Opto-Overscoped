package com.example.optovisualtesting.Math;

import com.example.optovisualtesting.Geometry.Point;

public interface Matrix<T> {
    void setElementAt(Point pointIndex);
    T getElementAt(Point pointIndex);
}
