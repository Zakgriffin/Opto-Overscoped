package com.example.optovisualtesting;

import com.example.optovisualtesting.Geometry.Point;

import java.util.Set;

public class SpaceGroup {
    public Set<ShapeInSpace> inSpaces;
    public Point origin;

    ProcedurePaths<ShapeInSpace> addToGroupProcedures;
    public void addToGroup(ShapeInSpace shapeInSpace) {
        inSpaces.add(shapeInSpace);

        addToGroupProcedures.runAll(shapeInSpace);
    }
}
