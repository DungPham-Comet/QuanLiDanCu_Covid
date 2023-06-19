package MVC.controller;

import java.io.IOException;
import java.sql.SQLException;

import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import static MVC.constans.FXMLConstans.*;

public class HomeController {
    @FXML
    private AnchorPane basePane;
    
    private final ViewUtils viewUtils = new ViewUtils();
    
    public HomeController() throws SQLException{
    	
    }
	
    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, HOME_VIEW);
    }
    
    @FXML
    public void switchToHoKhau() throws IOException {
    	viewUtils.changeAnchorPane(basePane, HOKHAU_VIEW);
    }

    @FXML
    public void switchToNhanKhau() throws IOException {
    	viewUtils.changeAnchorPane(basePane, NHANKHAU_VIEW);
    }

    @FXML
    public void switchToTamTru() throws IOException {
    	viewUtils.changeAnchorPane(basePane, TAMTRU_VIEW);
    }

    @FXML
    public void switchToTamVang() throws IOException {
    	viewUtils.changeAnchorPane(basePane, TAMVANG_VIEW);
    }
    
    @FXML
    public void switchToKhaiTu() throws IOException {
    	viewUtils.changeAnchorPane(basePane, KHAITU_VIEW);
    }
    
    @FXML
    public void switchToLichTrinh() throws IOException {
    	viewUtils.changeAnchorPane(basePane, LICHTRINH_VIEW);
    }
    
    @FXML
    public void switchToCachLy() throws IOException {
    	viewUtils.changeAnchorPane(basePane, CACHLY_VIEW);
    }
    
    @FXML
    public void switchToXetNghiem() throws IOException {
    	viewUtils.changeAnchorPane(basePane, XETNGHIEM_VIEW);
    }
    public AnchorPane getAnchorPane() {
    	return this.basePane;
    }
}
