package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;


public class VisualProceduralNestedCached implements VisualContext {
    SetO<RelativeCachedVisual> relativeCachedVisuals;
    ColorRGBMatrix cachedPixels;

    public VisualProceduralNestedCached(Visual Visual, ColorRGBMatrix cachedPixels) {
        this.relativeCachedVisuals = new SetO<>();
        this.cachedPixels = cachedPixels;

        relativeCachedVisuals.addProcedures.add(this::redrawInnerCached);
    }

    ProcedurePaths<Void> redrawInnerCachedProcedures = new ProcedurePaths<>();
    public void redrawInnerCached(RelativeCachedVisual relativeCachedVisual) {
        Point size = relativeCachedVisual.cachedPixels.size;
        for(int x = 0; x < size.x; x++) {
            for(int y = 0; y < size.y; y++) {
                cachedPixels.setAtPointIndex(
                        new Point(
                                relativeCachedVisual.translation.x + x,
                                relativeCachedVisual.translation.y + y),
                        relativeCachedVisual.cachedPixels.atPointIndex(new Point(x, y)));
            }
        }

        redrawInnerCachedProcedures.runAll();
    }
}
