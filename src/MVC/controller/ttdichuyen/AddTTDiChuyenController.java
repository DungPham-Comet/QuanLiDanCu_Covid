package MVC.controller.ttdichuyen;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import MVC.controller.hokhau.DetailHoKhauController;
import MVC.model.LichTrinh;
import MVC.model.SoHoKhau;
import MVC.model.ThongTinDiChuyen;
import MVC.services.DiChuyenServices;
import MVC.services.KhaiTuServices;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static MVC.constans.FXMLConstans.*;

public class AddTTDiChuyenController {

    @FXML
    private Button addButton;

    @FXML
    private TextField diaDiemTextField;

    @FXML
    private TextField phuongTienTextField;

    @FXML
    private Button returnButton;

    @FXML
    private DatePicker thoiGianDatePicker;

    private LichTrinh lichTrinh;
    
    public LichTrinh getLichTrinh() {
		return lichTrinh;
	}

	public void setLichTrinh(LichTrinh a) {
		lichTrinh = a;
	}

    @FXML
    void addTTDiChuyen(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String phuongTien = phuongTienTextField.getText();
    	String thoiGian = thoiGianDatePicker.getValue().toString();
    	String diaDiem = diaDiemTextField.getText();
    	if(phuongTien.trim().equals("") || thoiGian.trim().equals("") || diaDiem.trim().equals("")) {
			createDialog(
					Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	else {
    		try {
    			Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    			int result = DiChuyenServices.addDiChuyen(conn, lichTrinh.getIdLichTrinh(), phuongTien, thoiGian, diaDiem);
    			if(result == 1) {
					createDialog(
							Alert.AlertType.CONFIRMATION,
                            "Thành công",
                            "", "Đồng chí vất vả rồi!");
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			        FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(getClass().getResource(TTDICHUYEN_VIEW));
			        Parent studentViewParent = loader.load();
			        Scene scene = new Scene(studentViewParent);
			        TTDiChuyenController controller = loader.getController();
			        controller.setLichTrinh(lichTrinh);
			        stage.setScene(scene);
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
    void returnToTTDiChuyen(ActionEvent event) throws IOException {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(TTDICHUYEN_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        TTDiChuyenController controller = loader.getController();
        controller.setLichTrinh(lichTrinh);
        stage.setScene(scene);
    }

}
