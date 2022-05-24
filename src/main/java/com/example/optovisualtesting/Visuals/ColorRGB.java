package com.example.optovisualtesting.Visuals;

public class ColorRGB implements Color {
    Integer red;
    Integer green;
    Integer blue;

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
