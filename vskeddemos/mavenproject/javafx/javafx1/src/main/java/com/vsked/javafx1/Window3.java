package com.vsked.javafx1;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Window3 extends Application{
	
	TextField tf1=new TextField();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        try {
        	URL basePath=getClass().getResource("/MyScene1.fxml");
        	System.out.println(basePath);
        	 // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(basePath);

            primaryStage.setTitle("My Application");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }		
	}

}
