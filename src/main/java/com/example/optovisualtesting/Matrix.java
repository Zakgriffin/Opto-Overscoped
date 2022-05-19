package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;

public interface Matrix<T> {
    void setElementAt(Point pointIndex);
    T getElementAt(Point pointIndex);
}
