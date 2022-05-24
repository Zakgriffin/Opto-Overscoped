package com.example.optovisualtesting.Visuals;

import javafx.scene.image.*;

import java.nio.IntBuffer;

public class Screen {
    ShapeInSpace visual;
    ColorRGBMatrix screenPixels;
    WritablePixelFormat<IntBuffer> pixel_format = PixelFormat.getIntArgbPreInstance();

    public void assign_visual(Visual visual) {

    }
}
