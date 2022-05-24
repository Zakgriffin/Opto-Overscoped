module com.example.optovisualtesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.optovisualtesting to javafx.fxml;
    exports com.example.optovisualtesting;
    exports com.example.optovisualtesting.ExecutionEffect;
    opens com.example.optovisualtesting.ExecutionEffect to javafx.fxml;
    exports com.example.optovisualtesting.Polygon;
    opens com.example.optovisualtesting.Polygon to javafx.fxml;
    exports com.example.optovisualtesting.VerticalSpacedGroup;
    opens com.example.optovisualtesting.VerticalSpacedGroup to javafx.fxml;
    exports com.example.optovisualtesting.Constraint;
    opens com.example.optovisualtesting.Constraint to javafx.fxml;
    exports com.example.optovisualtesting.Geometry;
    opens com.example.optovisualtesting.Geometry to javafx.fxml;
    exports com.example.optovisualtesting.Math;
    opens com.example.optovisualtesting.Math to javafx.fxml;
    exports com.example.optovisualtesting.Emulator;
    opens com.example.optovisualtesting.Emulator to javafx.fxml;
    exports com.example.optovisualtesting.Observe;
    opens com.example.optovisualtesting.Observe to javafx.fxml;
    exports com.example.optovisualtesting.Visuals;
    opens com.example.optovisualtesting.Visuals to javafx.fxml;
    exports com.example.optovisualtesting.Interaction;
    opens com.example.optovisualtesting.Interaction to javafx.fxml;
    exports com.example.optovisualtesting.Procedural;
    opens com.example.optovisualtesting.Procedural to javafx.fxml;
}