module com.homework.multilayerprog {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.dz.mlayerlev to javafx.fxml;
    exports com.dz.mlayerlev;
}