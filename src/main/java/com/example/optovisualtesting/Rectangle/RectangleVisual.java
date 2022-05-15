//package com.example.optovisualtesting.Rectangle;
//
//import com.example.optovisualtesting.Geometry.Point;
//import com.example.optovisualtesting.Visual;
//import javafx.scene.paint.Color;
//
//public class RectangleVisual implements Visual {
//    private final Rectangle rectangle;
//    private final Color color;
//
//    public RectangleVisual(Rectangle rectangle, Color color) {
//        this.rectangle = rectangle;
//        this.color = color;
//    }
//
//    @Override
//    public boolean isWithin(Point point) {
//        return rectangle.pointIsWithin(point);
//    }
//
//    @Override
//    public Color colorAtPoint(Point point) {
//        return color;
//    }
//}
