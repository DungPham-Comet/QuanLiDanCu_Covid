package MVC.utils;

import java.io.IOException;
import MVC.constans.FXMLConstans;
import MVC.controller.HomeController;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewAddKhaiTuUtils {
	
	public void switchToKhaiTu_HomeView(Event event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLConstans.HOME_VIEW));
        root = loader.load();
        HomeController controller = loader.getController();
        controller.switchToKhaiTu();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
