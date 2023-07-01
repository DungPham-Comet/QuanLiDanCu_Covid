package MVC.controller.cachly;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.controller.nhankhau.ChonNhanKhauController;
import MVC.model.NhanKhau;
import MVC.services.CachLyServices;
import MVC.services.KhaiTuServices;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCachLyController implements Initializable{

    @FXML
    private Button addButton;

    @FXML
    private Button chooseButton;

    @FXML
    private TextField diaDiemTextField;

    @FXML
    private TextField mucDoTextField;

    @FXML
    private TextField nguoiCachLyTextField;

    @FXML
    private Button returnButton;

    @FXML
    private DatePicker thoiGianDatePicker;
    
    private NhanKhau nguoiCachLy = ChonNhanKhauController.getSelectedNhanKhau();

    @FXML
    void chonNguoiCachLy(ActionEvent event) throws IOException {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_NHAN_KHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonNhanKhauController controller = loader.getController();
        controller.setPreviousPage(ADD_CACHLY_VIEW);
        stage.setScene(scene);
    }

    @FXML
    void addCachLy(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String nguoiCachLy = nguoiCachLyTextField.getText();
    	String mucDo = mucDoTextField.getText();
    	String thoiGian = thoiGianDatePicker.getValue().toString();
    	String diaDiem = diaDiemTextField.getText();
    	if(nguoiCachLy.trim().equals("") || mucDo.trim().equals("") || diaDiem.trim().equals("")|| thoiGian.trim().equals("")) {
			createDialog(
					Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	else {
    		try {
    			Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    			int result = CachLyServices.addCachLy(conn, this.nguoiCachLy.getIdNhanKhau(), mucDo, thoiGian, diaDiem);
    			if(result == 1) {
					createDialog(
							Alert.AlertType.CONFIRMATION,
                            "Thành công",
                            "", "Đồng chí vất vả rồi!");
					viewUtils.backToView(event, CACHLY_VIEW);
    			}
    			else {
					createDialog(
							Alert.AlertType.ERROR,
                            "Thất bại",
                            "", "Oops, mời đồng chí nhập lại thông tin!");
				}
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
    	}
    }
    

    @FXML
    void returnToCachLy(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, CACHLY_VIEW);
    }
    
    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
       	nguoiCachLyTextField.setText(this.nguoiCachLy.getHoTen());
       	
   	}

}