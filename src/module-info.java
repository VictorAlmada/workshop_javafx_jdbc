module workshop_javafx_jdbc {
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires lombok;
	requires transitive java.sql;
	requires transitive javafx.base;
	requires transitive javafx.graphics;


	
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.fxml;
	opens model.entities to javafx.base;

    exports gui;
	exports application;
	exports db;
	exports gui.util;
	exports model.dao;
	exports model.dao.impl;
	exports model.entities;
	exports model.services;
}
