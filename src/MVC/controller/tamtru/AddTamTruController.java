package MVC.controller.tamtru;

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

import MVC.controller.hokhau.ChonHoKhauController;
import MVC.controller.nhankhau.ChonNhanKhauController;
import MVC.model.NhanKhau;
import MVC.model.SoHoKhau;
import MVC.model.ThanhVienCuaHo;
import MVC.services.TamTruServices;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddTamTruController implements Initializable {

    @FXML
    private Button add_btn;

    @FXML
    private AnchorPane basePane;

    @FXML
    private DatePicker ngayBatDauDatePicker;

    @FXML
    private DatePicker ngayKetThucDatePicker;

    @FXML
    private TextField tenChuHoTextField;

    @FXML
    private TextField tenTamTruTextField;

    @FXML
    private Text title;
    
    private NhanKhau nguoiTamTru = ChonNhanKhauController.getSelectedNhanKhau();
    
    private SoHoKhau hoKhau = ChonHoKhauController.getSelectedHoKhau();
    

    @FXML
    void addnew(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String tenTamTru = tenTamTruTextField.getText();
    	String tenChuHo = tenChuHoTextField.getText();
    	String ngayTao = ngayBatDauDatePicker.getValue().toString();
    	String ngayKet = ngayKetThucDatePicker.getValue().toString();
    	if(tenTamTru.trim().equals("") || tenChuHo.trim().equals("") || ngayTao.trim().equals("") || ngayKet.trim().equals("")) {
			createDialog(
					Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	else {
    		try {
    			Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    			int result = TamTruServices.addTamTru(conn, ngayTao, ngayKet, nguoiTamTru.getIdNhanKhau(), hoKhau.getIdHoKhau());
    			if(result == 1) {
					createDialog(
							Alert.AlertType.CONFIRMATION,
                            "Thành công",
                            "", "Đồng chí vất vả rồi!");
					viewUtils.backToView(event, TAMTRU_VIEW);
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
    void chonHoKhau(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_HO_KHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonHoKhauController controller = loader.getController();
        controller.setPreviousPage(ADD_TAMTRU_VIEW);
        stage.setScene(scene);
    }

    @FXML
    void chonTamTru(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_NHAN_KHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonNhanKhauController controller = loader.getController();
        controller.setPreviousPage(ADD_TAMTRU_VIEW);
        stage.setScene(scene);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	ChonNhanKhauController.DeleteSelectedNhanKhau();
    	ViewUtils viewUtils = new ViewUtils();
    	viewUtils.backToView(event, TAMTRU_VIEW);    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tenTamTruTextField.setText(nguoiTamTru.getHoTen());
		tenChuHoTextField.setText(hoKhau.getTenChuHo());
	}

}
