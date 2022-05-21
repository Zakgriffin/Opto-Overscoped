package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Color;

public class ColorRGB implements Color {
    int red;
    int green;
    int blue;

    public ColorRGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static ColorRGB compactToColorRGB(int compactColorRGB) {
        return new ColorRGB(
                (compactColorRGB >> 16) & 0x000000FF,
                (compactColorRGB >> 8) & 0x000000FF,
                compactColorRGB & 0x000000FF
        );
    }

    @Override
    public ColorRGB toRGB() {
        return this;
    }
}
