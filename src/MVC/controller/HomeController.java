package MVC.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import MVC.services.CachLyServices;
import MVC.services.HoKhauServices;
import MVC.services.NhanKhauServices;
import MVC.services.TamTruServices;
import MVC.services.TamVangServices;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static MVC.constans.FXMLConstans.*;

public class HomeController implements Initializable {
    @FXML
    private AnchorPane basePane;
    
    private final ViewUtils viewUtils = new ViewUtils();
    
    @FXML
    private Label covidLabel;
    
    @FXML
    private Label truVangLabel;

    @FXML
    private Label hokhauLabel;
    
    @FXML
    private Label roleLabel;
    
    @FXML
    private Label nhankhauLabel;
    
    @FXML
    private Label usernameLabel;
    
    private static Preferences userPreferences;
    public static String userRole;
    public static String userName;
    
    public static void setUserPreferences(Preferences userPreferences) {
		HomeController.userPreferences = userPreferences;
	}

	public static void setUserRole(String userRole) {
		HomeController.userRole = userRole;
	}

	public static void setUserName(String userName) {
		HomeController.userName = userName;
	}

	public HomeController() throws SQLException{
    	
    }
    
    @FXML
    void logOut(ActionEvent event) throws IOException, BackingStoreException {
        String[] keys = userPreferences.keys();
        for (String key : keys) {
        	System.out.println(key);
            System.out.println(userPreferences.get(key, ""));
            userPreferences.remove(key);
        }
        userPreferences.flush();
        viewUtils.changeScene(event, LOGIN_VIEW);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setUserPreferences(Preferences.userRoot());
		setUserName(userPreferences.get("username", ""));
		setUserRole(userPreferences.get("role", ""));
		if(userRole.equals("1")) {
			roleLabel.setText("Trưởng thôn");
		}
		else {
			roleLabel.setText("Cán bộ");
		}
		usernameLabel.setText(userName);
		nhankhauLabel.setText(""+NhanKhauServices.getTotalNhanKhau("2023"));
		hokhauLabel.setText(""+HoKhauServices.getTotalSoHoKhau());
		covidLabel.setText(""+CachLyServices.getTotalCovid(LocalDate.now().toString()));
		truVangLabel.setText(""+(TamTruServices.getTotalTamTruByDate(LocalDate.now().toString(), LocalDate.now().toString())+TamVangServices.getTotalTamVangByDate(LocalDate.now().toString(), LocalDate.now().toString())));
	}
	
    @FXML
    void swichToThongKeNhanKhau(MouseEvent event) throws IOException {
    	viewUtils.changeAnchorPane(basePane, THONGKE_NHANKHAU_VIEW);
    }

    @FXML
    void switchToThongKeCovid(MouseEvent event) throws IOException {
    	viewUtils.changeAnchorPane(basePane, THONGKE_COVID_VIEW);
    }

    @FXML
    void switchToThongKeHoKhau(MouseEvent event) throws IOException {
    	viewUtils.changeAnchorPane(basePane, THONGKE_HOKHAU_VIEW);
    }

    @FXML
    void switchToThongKeTruVang(MouseEvent event) throws IOException {
    	viewUtils.changeAnchorPane(basePane, THONGKE_TRU_VANG_VIEW);
    }
}
