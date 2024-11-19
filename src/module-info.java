module workshop_javafx_jdbc {
	requires javafx.controls;
	requires javafx.fxml;
	requires lombok;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.fxml;
	opens model.entities to javafx.base;

    exports gui;
	
}
