package com.example.optovisualtesting.Visuals;

import com.example.optovisualtesting.Procedural.Listeners;
import javafx.scene.image.*;

import java.nio.IntBuffer;

public class Screen {
    Visual visual;
    ColorRGBMatrix screen_pixels;
    WritablePixelFormat<IntBuffer> pixel_format = PixelFormat.getIntArgbPreInstance();

    public Screen() {
        assign_visual_listeners.add((visual) -> {
            for(Object reference : visual.references()) {
                reference.
            }
        });
    }

    public Listeners<Visual> assign_visual_listeners = new Listeners<>();
    public void assign_visual(Visual visual) {
        this.visual = visual;


    }
}
