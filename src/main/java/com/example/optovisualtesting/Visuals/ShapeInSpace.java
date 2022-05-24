package com.example.optovisualtesting.Visuals;

import com.example.optovisualtesting.Geometry.*;
import com.example.optovisualtesting.Geometry.Variations.RectangleV;

public interface ShapeInSpace {
    int distance_to_point(Point point);
    ShapePlacement shape_placement_of_point(Point point);
    RectangleV bounding_rectangle();
}
