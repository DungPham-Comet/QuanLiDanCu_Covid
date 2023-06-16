package MVC.controller;

import java.io.IOException;

import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import static MVC.constans.FXMLConstans.*;

public class HomeController {
    @FXML
    private AnchorPane basePane;
    
    private final ViewUtils viewUtils = new ViewUtils();
	
    @FXML
    void switchToDashboard(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, HOME_VIEW);
    }
    
    @FXML
    void switchToHoKhau() throws IOException {
    	viewUtils.changeAnchorPane(basePane, HOKHAU_VIEW);
    }

    @FXML
    void switchToNhanKhau() throws IOException {
    	viewUtils.changeAnchorPane(basePane, NHANKHAU_VIEW);
    }

    @FXML
    void switchToTamTru() throws IOException {
    	viewUtils.changeAnchorPane(basePane, TAMTRU_VIEW);
    }

    @FXML
    void switchToTamVang() throws IOException {
    	viewUtils.changeAnchorPane(basePane, TAMVANG_VIEW);
    }
}
