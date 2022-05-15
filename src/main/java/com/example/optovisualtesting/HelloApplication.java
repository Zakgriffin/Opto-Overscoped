package com.example.optovisualtesting;

import com.example.optovisualtesting.Example.SimpleExpression.SimpleExpression;
import com.example.optovisualtesting.Geometry.Point;
import javafx.application.Application;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.stage.Stage;

import java.util.*;

public class HelloApplication extends Application {
//    private final int WIDTH = 1400;
//    private final int HEIGHT = 800;
//
//    private PixelWriter writer;
//    private PixelReader reader;
//
//    private Point mouse = new Point(0, 0);
//
//    private final Set<Visual> visuals = new HashSet<>();
//    private final Set<Clickable> clickables = new HashSet<>();
//    private final Queue<Runnable> drawQueue = new LinkedList<>();
//
//    private Polygon testPolygon;

    @Override
    public void start(Stage stage) {
//        WritableImage image = new WritableImage(WIDTH, HEIGHT);
//        writer = image.getPixelWriter();
//        reader = image.getPixelReader();
//        ImageView imageView = new ImageView(image);
//        Group root = new Group(imageView);
//        Scene scene = new Scene(root, WIDTH, HEIGHT);
//
//        scene.snapshot(image);
//        stage.setScene(scene);
//        stage.setTitle("Opto Testing");
//
//        scene.setOnMouseClicked((e) -> clickables.forEach(clickable -> clickable.onClick(e)));
//
//        scene.setOnMouseMoved((e) -> {
//            mouse = new Point((int) e.getX(), (int) e.getY());
////            updateView();
//        });
//
//        initView();
////        updateView();
//
//        stage.show();
    }

//    private void updateView() {
//        Point p0 = new Point(40, 40);
//        Point p1 = new Point(180, 40);
//        Point p2 = new Point(mouse.x, mouse.y);
//        Point p3 = new Point(40, 180);
//
//        LineSegment lineSegment0 = new LineSegment(p0, p1);
//        LineSegment lineSegment1 = new LineSegment(p1, p2);
//        LineSegment lineSegment2 = new LineSegment(p2, p3);
//        LineSegment lineSegment3 = new LineSegment(p3, p0);
//
//        testPolygon.setLineSegments(new LineSegment[]{
//                lineSegment0,
//                lineSegment1,
//                lineSegment2,
//                lineSegment3
//        });
//
//        for (int x = 0; x < WIDTH; x++) {
//            h:
//            for (int y = 0; y < HEIGHT; y++) {
//                Point point = new Point(x, y);
//                for (Visual visual : visuals) {
//                    if (visual.isWithin(point)) {
//                        writePixel(x, y, visual.colorAtPoint(point));
//                        continue h;
//                    }
//                }
//                writePixel(x, y, Color.rgb(240, 240, 240));
//            }
//        }
//    }

    //    private void writePixel(int x, int y, Color color) {
//        if (!reader.getColor(x, HEIGHT - y - 1).equals(color)) {
//            writer.setColor(x, HEIGHT - y - 1, color);
//        }
//    }
    public static void main(String[] args) {
//        launch();
        SimpleExpression.doStuff();
    }
}