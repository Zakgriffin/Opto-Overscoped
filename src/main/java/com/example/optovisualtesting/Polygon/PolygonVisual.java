//package com.example.optovisualtesting.Polygon;
//
//import com.example.optovisualtesting.Geometry.Point;
//import com.example.optovisualtesting.Visual;
//import javafx.scene.paint.Color;
//
//public class PolygonVisual implements Visual {
//    private final Polygon polygon;
//    private final Color color;
//
//    public PolygonVisual(Polygon polygon, Color color) {
//        this.polygon = polygon;
//        this.color = color;
//    }
//
//    @Override
//    public boolean isWithin(Point point) {
//        return polygon.isInside(point);
//    }
//
//    @Override
//    public Color colorAtPoint(Point point) {
//        return color;
//    }
//}
