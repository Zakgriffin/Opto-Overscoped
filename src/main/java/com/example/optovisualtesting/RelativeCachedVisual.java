package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;

public class RelativeCachedVisual {
    Visual visual;
    ColorRGBMatrix cachedPixels;
    Point translation;

    public RelativeCachedVisual(Visual visual) {
        this.visual = visual;

    }
}
