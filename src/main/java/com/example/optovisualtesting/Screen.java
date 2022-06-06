package com.example.optovisualtesting;

import com.example.optovisualtesting.Visuals.Visual;
import javafx.scene.image.*;

import java.nio.IntBuffer;

import static com.example.optovisualtesting.StructureType.SCREEN;

public class Screen implements DeclareNode {
    Visual full_visual;
    WritablePixelFormat<IntBuffer> pixel_format = PixelFormat.getIntArgbPreInstance();
    PixelWriter pixel_writer;

    public Screen(PixelWriter pixel_writer) {
        this.pixel_writer = pixel_writer;
    }

    public void set_pixels() {
        pixel_writer.setPixels(0, 0, WIDTH, HEIGHT, pixel_format, pixels, 0, WIDTH);
    }

    @Override
    public StructureType structure_type() {
        return SCREEN;
    }
//        Proposition v = for_all(pair(0..width, 0..height), (x, y) -> screen_pixels.at(x, y) = visual.color(x, y));
}
