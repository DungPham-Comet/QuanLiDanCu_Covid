package MVC.controller.khaitu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import MVC.controller.nhankhau.ChonNhanKhauController;
import MVC.controller.nhankhau.ChonNhanKhauController2;
import MVC.model.NhanKhau;
import MVC.services.HoKhauServices;
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

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.createDialog;

public class AddKhaiTuController implements Initializable{

    @FXML
    private Button addKhaiTuButton;

    @FXML
    private TextField lyDoChetTextField;

    @FXML
    private DatePicker ngayChetDatePicker;

    @FXML
    private DatePicker ngayKhaiDatePicker;

    @FXML
    private Button nguoiChetButton;

    @FXML
    private Button nguoiKhaiButton;
    
    @FXML
    private TextField tenNguoiChetTextField;
    
    @FXML
    private TextField tenNguoiKhaiTextField;

    @FXML
    private Button returnToKhaiTuButton;
    
    private NhanKhau nguoiChet = ChonNhanKhauController.getSelectedNhanKhau();
    
    @FXML
    void chonNguoiChet(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_NHAN_KHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonNhanKhauController controller = loader.getController();
        controller.setPreviousPage(ADD_KHAITU_VIEW);
        stage.setScene(scene);
    }
    
    private NhanKhau nguoiKhai = ChonNhanKhauController2.selectedNhanKhau;

    @FXML
    void chonNguoiKhai(ActionEvent event) throws IOException {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_NHAN_KHAU_VIEW2));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonNhanKhauController2 controller = loader.getController();
        controller.setPreviousPage(ADD_KHAITU_VIEW);
        stage.setScene(scene);
    }
    
    @FXML
    void addKhaiTu(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String tenNguoiChet = tenNguoiChetTextField.getText();
    	String tenNguoiKhai = tenNguoiKhaiTextField.getText();
    	String lyDoChet = lyDoChetTextField.getText();
    	String ngayChet = ngayChetDatePicker.getValue().toString();
    	String ngayKhai = ngayKhaiDatePicker.getValue().toString();
    	if(tenNguoiChet.trim().equals("") || tenNguoiKhai.trim().equals("") || lyDoChet.trim().equals("")) {
			createDialog(
					Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	else {
    		try {
    			Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    			int result = KhaiTuServices.addKhaiTu(conn, nguoiChet.getIdNhanKhau(), nguoiKhai.getIdNhanKhau(), lyDoChet, ngayChet, ngayKhai);
    			if(result == 1) {
					createDialog(
							Alert.AlertType.CONFIRMATION,
                            "Thành công",
                            "", "Xin vĩnh biệt cụ!");
					viewUtils.backToView(event, KHAITU_VIEW);
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
    void returnToKhaiTu(ActionEvent event) throws IOException {
    	System.out.println(nguoiChet.getHoTen());
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, KHAITU_VIEW);
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	tenNguoiChetTextField.setText(nguoiChet.getHoTen());
		tenNguoiKhaiTextField.setText(nguoiKhai.getHoTen());
	}

}


    
    

