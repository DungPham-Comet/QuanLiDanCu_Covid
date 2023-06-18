package MVC;
	
import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import ConnectDatabase.ConnectMySql;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Connection connect =ConnectMySql.connectMysql();
			if(connect != null) {
				System.out.println("thanh cmnr");
			}
			else {
				System.out.println("ngu vcl");
			}
			Parent root = FXMLLoader.load(getClass().getResource("/MVC/views/view/Scene.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/MVC/views/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}