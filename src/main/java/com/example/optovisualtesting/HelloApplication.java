package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.*;

import java.nio.IntBuffer;
import java.util.*;

public class HelloApplication extends Application {
    final int WIDTH = 1400;
    final int HEIGHT = 800;

    PixelWriter pixelWriter;
    PixelReader reader;

    Point mouse = new Point(0, 0);

    SetO<Visual> visuals = new SetO<>(new HashSet<>());
    Map<Visual, BoundingBox> cachedBoundingBoxes = new HashMap<>();
    Map<Visual, ColorRGBMatrix> cachedShapePixelColors = new HashMap<>();

    java.util.Set mouseListeners = new HashSet<>();

    java.util.Set clickables = new HashSet<>();
    Queue<Runnable> drawQueue = new LinkedList<>();

    int[] pixels = new int[WIDTH * HEIGHT];

    public void updateScreen() {

    }

    @Override
    public void start(Stage stage) {
        WritableImage image = new WritableImage(WIDTH, HEIGHT);
        pixelWriter = image.getPixelWriter();
        ImageView imageView = new ImageView(image);
        Group root = new Group(imageView);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.snapshot(image);
        stage.setScene(scene);
        stage.setTitle("Opto");

        visuals.addAddListener((visual) -> {
            BoundingBox boundingBox = visual.boundingBox();
            cachedBoundingBoxes.put(visual, boundingBox);
            ColorRGBMatrix cachedColorRGBMatrix = new ColorRGBMatrix(boundingBox.size());
            visual.drawWithinBoundingBox(cachedColorRGBMatrix);

        });

        scene.setOnMouseClicked((e) -> clickables.forEach(clickable -> clickable.onClick(e)));

        scene.setOnMouseMoved((e) -> mouseListeners.forEach((listener) -> listener.notify(e)));



        Point mousePosition = a(new Point(0, 0));

        PointObserve pointObserve = new PointObserve(mousePosition);

        mouseListeners.add((e) -> {
            mousePosition.x =
            observables.update(mousePosition);
        });




        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0x22FF0000;
        }

        WritablePixelFormat<IntBuffer> pixelFormat = PixelFormat.getIntArgbPreInstance();
        pixelWriter.setPixels(0, 0, WIDTH, HEIGHT, pixelFormat, pixels, 0, WIDTH);

        doStuff();

        stage.show();
    }

    void doStuff() {
        CircleShapeInSpace circleShapeInSpace = new CircleShapeInSpace(new Circle(40));
        CircleShapeInSpace circleShapeInSpace2 = new CircleShapeInSpace(new Circle(50));

        ShapeInSpace circle = new Translated(circleShapeInSpace, mousePosition);
        Point pos2;

        ShapeInSpace circle2 = new Translated(circleShapeInSpace, pos2);

        SolidShapePainter solidPainter = new SolidShapePainter(new EnumMap<>(Map.of(
                ShapePlacement.EDGE, new ColorRGB(255, 0, 0)
        )));

        PaintedVisualInSpace paintedCircleInSpace = new PaintedShapeInSpace(circle, solidPainter);

        SetO<PaintedVisualInSpace> visualsInScene = new SetO<>();
        shapesInScene.add(paintedCircleInSpace);

        Painter groupBlending = new OrderedLayeringPriority();

        ShapeInSpaceGroup group = new ShapeInSpaceGroup(shapesInScene, groupBlendPainter);

        ColorRGBMatrix mat = new ColorRGBMatrix();
        VisualContext v = new VisualProceduralNestedCached(paintedCircleInSpace, mat);

        Visual circleVisual = new BufferedVisual(circlePainter);

        screen.addPaintedShapeInSpace(paintedCircleInSpace);

        Screen screen = new Screen(group);

        if(circleVisual.hasWorkToPaint()) {
            circleVisual.paint(matrix);
        }
    }

    //    private void writePixel(int x, int y, Color color) {
//        if (!reader.getColor(x, HEIGHT - y - 1).equals(color)) {
//            writer.setColor(x, HEIGHT - y - 1, color);
//        }
//    }
    public static void main(String[] args) {
        launch();
    }
}