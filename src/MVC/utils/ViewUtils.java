package MVC.utils;


import java.io.IOException;
import java.util.Objects;

import MVC.controller.HomeController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static MVC.constans.FXMLConstans.*;

public class ViewUtils {
    public void changeScene(ActionEvent event, String viewSource) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(viewSource));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void changeAnchorPane(AnchorPane currentPane, String viewSource) throws IOException {
        Node node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewSource)));
        currentPane.getChildren().setAll(node);
    }
    public void backToView(Event event, String viewSource) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(HOME_VIEW));
        root = loader.load();
        HomeController controller = loader.getController();
        changeAnchorPane(controller.getAnchorPane(), viewSource);
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();    	
    }
}
