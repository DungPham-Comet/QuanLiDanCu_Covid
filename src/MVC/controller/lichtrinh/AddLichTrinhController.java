package MVC.controller.lichtrinh;

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
import MVC.controller.nhankhau.ChonNhanKhauController2;
import MVC.model.NhanKhau;
import MVC.services.KhaiTuServices;
import MVC.services.LichTrinhServices;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLichTrinhController implements Initializable {

    @FXML
    private Button addTTDiChuyenButton;

    @FXML
    private TextField lichTrinhTextField;

    @FXML
    private Button nguoiKhaiButton;

    @FXML
    private TextField nguoiKhaiTextField;

    @FXML
    private Button returnButton;

    @FXML
    void addTTDiChuyen(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String tenNguoiKhai = nguoiKhaiTextField.getText();
    	String tenLichTrinh = lichTrinhTextField.getText();
    	if(tenNguoiKhai.trim().equals("") || tenLichTrinh.trim().equals("")) {
			createDialog(
					Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	else {
    		try {
    			Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    			int result = LichTrinhServices.addLichTrinh(conn, nguoiKhai.getIdNhanKhau(), tenLichTrinh);
    			if(result == 1) {
					createDialog(
							Alert.AlertType.CONFIRMATION,
                            "Thành công",
                            "", "Đồng chí vất vả rồi!");
					viewUtils.backToView(event, LICHTRINH_VIEW);
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

    private NhanKhau nguoiKhai = ChonNhanKhauController.getSelectedNhanKhau();
    @FXML
    void chonNguoiKhai(ActionEvent event) throws IOException {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_NHAN_KHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonNhanKhauController controller = loader.getController();
        controller.setPreviousPage(ADD_LICHTRINH_VIEW);
        stage.setScene(scene);
    }

    @FXML
    void returnToLichTrinh(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, LICHTRINH_VIEW);
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nguoiKhaiTextField.setText(nguoiKhai.getHoTen());
	}

}
