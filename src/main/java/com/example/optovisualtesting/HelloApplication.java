package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.BezierCurve;
import com.example.optovisualtesting.Geometry.Curve;
import com.example.optovisualtesting.Geometry.LineSegment;
import com.example.optovisualtesting.Geometry.Point;
import com.example.optovisualtesting.Glyphigon.Glyphigon;
import com.example.optovisualtesting.Glyphigon.GlyphigonVisual;
import com.example.optovisualtesting.Polygon.Polygon;
import com.example.optovisualtesting.Rectangle.Rectangle;
import com.example.optovisualtesting.Rectangle.RectangleVisual;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.*;

public class HelloApplication extends Application {
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;

    private PixelWriter writer;
    private PixelReader reader;

    private Point mouse = new Point(0, 0);

    private final Set<Visual> visuals = new HashSet<>();
    private final Set<Clickable> clickables = new HashSet<>();
    private final Queue<Runnable> drawQueue = new LinkedList<>();

    // NO
    private Polygon testPolygon;

    @Override
    public void start(Stage stage) {
        WritableImage image = new WritableImage(WIDTH, HEIGHT);
        writer = image.getPixelWriter();
        reader = image.getPixelReader();
        ImageView imageView = new ImageView(image);
        Group root = new Group(imageView);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.snapshot(image);
        stage.setScene(scene);
        stage.setTitle("Opto Testing");

        scene.setOnMouseClicked((e) -> clickables.forEach(clickable -> clickable.onClick(e)));

        scene.setOnMouseMoved((e) -> {
            mouse = new Point((int) e.getX(), (int) e.getY());
//            updateView();
        });

        initView();
//        updateView();

        stage.show();
    }

    private void initView() {
//        testPolygon = new Polygon(new LineSegment[]{});
//        visuals.add(new PolygonVisual(testPolygon, Color.RED));
//
//        visuals.add(new GlyphigonVisual(new Glyphigon(new Curve[] {
//                new BezierCurve(
//                        new Point(50, 50),
//                        new Point(100, 250),
//                        new Point(550, -150),
//                        new Point(600, 50)
//                ),
//                new LineSegment(new Point(600, 50), new Point(600, 600)),
//                new LineSegment(new Point(600, 600), new Point(50, 50))
//        }), Color.rgb(0, 0, 255)));

//        Curve[] gCurves = new Curve[]{
//                new LineSegment(new Point(50, 0), new Point(100, 100)),
//                new LineSegment(new Point(100, 100), new Point(0, 100)),
//                new LineSegment(new Point(0, 100), new Point(50, 0)),
//                // subtract
//                new LineSegment(new Point(50, 25), new Point(75, 75)),
//                new LineSegment(new Point(75, 75), new Point(25, 75)),
//                new LineSegment(new Point(25, 75), new Point(50, 25)),
//        };
//        Glyphigon g = new Glyphigon(gCurves);
//        GlyphigonVisual poo = new GlyphigonVisual(g, Color.rgb(0, 255, 255));

//        visuals.add(poo);

//        visuals.add(new GlyphigonVisual(new Glyphigon(new Curve[] {
//                new LineSegment(new Point(50, 25), new Point(75, 75)),
//                new LineSegment(new Point(75, 75), new Point(25, 75)),
//                new LineSegment(new Point(25, 75), new Point(50, 25)),
//        }), Color.rgb(255, 0, 255)));
    }

    private void updateView() {
        Point p0 = new Point(40, 40);
        Point p1 = new Point(180, 40);
        Point p2 = new Point(mouse.x, mouse.y);
        Point p3 = new Point(40, 180);

        LineSegment lineSegment0 = new LineSegment(p0, p1);
        LineSegment lineSegment1 = new LineSegment(p1, p2);
        LineSegment lineSegment2 = new LineSegment(p2, p3);
        LineSegment lineSegment3 = new LineSegment(p3, p0);

        testPolygon.setLineSegments(new LineSegment[]{
                lineSegment0,
                lineSegment1,
                lineSegment2,
                lineSegment3
        });

        for (int x = 0; x < WIDTH; x++) {
            h:
            for (int y = 0; y < HEIGHT; y++) {
                Point point = new Point(x, y);
                for (Visual visual : visuals) {
                    if (visual.isWithin(point)) {
                        writePixel(x, y, visual.colorAtPoint(point));
                        continue h;
                    }
                }
                writePixel(x, y, Color.rgb(240, 240, 240));
            }
        }
    }

    private void writePixel(int x, int y, Color color) {
        if (!reader.getColor(x, HEIGHT - y - 1).equals(color)) {
            writer.setColor(x, HEIGHT - y - 1, color);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}