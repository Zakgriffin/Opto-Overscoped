package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.*;
import com.example.optovisualtesting.Math.IntegerO;
import com.example.optovisualtesting.Visuals.*;
import com.example.optovisualtesting.Visuals.Screen;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.*;

import java.util.*;

public class OptoApplication extends Application {
    final int WIDTH = 1400;
    final int HEIGHT = 800;

    PixelWriter pixel_writer;
    PixelReader reader;

    Point mouse_position = new Point();

    @Override
    public void start(Stage stage) {
        WritableImage image = new WritableImage(WIDTH, HEIGHT);
        pixel_writer = image.getPixelWriter();
        ImageView image_view = new ImageView(image);
        Group root = new Group(image_view);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.snapshot(image);
        stage.setScene(scene);
        stage.setTitle("Opto");


        pixel_writer.setPixels(0, 0, WIDTH, HEIGHT, pixel_format, pixels, 0, WIDTH);

        setup_visual_stuff();

        stage.show();
    }

    void setup_visual_stuff() {
        IntegerO circle_radius = new IntegerO(40);
        Circle circle = new Circle();
        circle.assign_radius(circle_radius);

        Map<ShapePlacement, ColorRGB> solid_red_color_map = new EnumMap<>(Map.of(
                ShapePlacement.EDGE, new ColorRGB(0xFF, 0x00, 0x00)
        ));
        SolidShapePainter solid_red_painter = new SolidShapePainter();
        solid_painter.assign_shape_placement_to_colors(solid_circle_color_map);

        PaintedShape painted_circle = new PaintedShape();
        painted_circle.assign_shape(circle);
        painted_circle.assign_shape_painter(solid_red_color_map);

        TranslatedVisual translated_circle = new TranslatedVisual();
        translated_circle.assign_painted_visual(circle_1);
        translated_circle.assign_translation(mouse_position);

        // ----

        IntegerO width = new IntegerO(10);
        IntegerO height = new IntegerO(20);
        Rectangle rectangle = new Rectangle();
        rectangle.assign_width(width);
        rectangle.assign_height(height);

        Map<ShapePlacement, ColorRGB> solid_green_color_map = new EnumMap<>(Map.of(
                ShapePlacement.EDGE, new ColorRGB(0x00, 0xFF, 0x00)
        ));
        SolidShapePainter solid_painter = new SolidShapePainter();
        solid_painter.assign_shape_placement_to_colors(solid_green_color_map);

        PaintedShape painted_rectangle = new PaintedShape();
        painted_rectangle.assign_shape(rectangle);
        painted_rectangle.assign_shape_painter(solid_green_color_map);

        OrderedSet<Visual> in_group = new OrderedSet<>();
        in_group.add_item(painted_circle);
        in_group.add_item(painted_rectangle);

        OrderedGroupVisual ordered_group_visual = new OrderedGroupVisual();
        group_visual.set_visual(ordered_group_visual);

        Screen screen = new Screen();
        screen.assign_visual(ordered_group_visual);
    }

    public static void main(String[] args) {
        launch();
    }
}