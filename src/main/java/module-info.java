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
    exports com.example.optovisualtesting.Expression;
    opens com.example.optovisualtesting.Expression to javafx.fxml;
    exports com.example.optovisualtesting.Emulator;
    opens com.example.optovisualtesting.Emulator to javafx.fxml;
    exports com.example.optovisualtesting.Observe;
    opens com.example.optovisualtesting.Observe to javafx.fxml;
}