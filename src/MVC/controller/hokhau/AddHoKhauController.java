package MVC.controller.hokhau;

import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import MVC.controller.nhankhau.ChonNhanKhauController;
import MVC.model.NhanKhau;
import MVC.services.HoKhauServices;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.*;
import static MVC.constans.DBConstans.*;

public class AddHoKhauController implements Initializable{

    @FXML
    private Button add_btn;
 
    @FXML
    private AnchorPane basePane;

    @FXML
    private Button chonBtn;

    @FXML
    private TextField diaChiTextField;

    @FXML
    private TextField ngayTaoTextField;

    @FXML
    private Text tenChuHoLabel;

    @FXML
    private TextField tenChuHoTextField;

    @FXML
    private Text title;
    
    private NhanKhau chuHoKhau = ChonNhanKhauController.getSelectedNhanKhau();

    @FXML
    void chonChuHo(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_NHAN_KHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonNhanKhauController controller = loader.getController();
        controller.setPreviousPage(ADD_HOKHAU_VIEW);
        stage.setScene(scene);
    }
    
    @FXML
    void addnew(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String tenChuHo = tenChuHoTextField.getText();
    	String diaChi = diaChiTextField.getText();
    	String ngayTao = LocalDate.now().toString();
    	ngayTaoTextField.setText(ngayTao);
    	if(tenChuHo.trim().equals("") || diaChi.trim().equals("")) {
			createDialog(
					Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	else {
    		try {
    			Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    			int result = HoKhauServices.addHoKhau(conn, ngayTao, diaChi, chuHoKhau.getIdNhanKhau());
    			int result2 = HoKhauServices.addThanhVienHo(conn, chuHoKhau.getIdNhanKhau(), HoKhauServices.getHoKhauByChuHo(conn, chuHoKhau.getIdNhanKhau()), "Chủ hộ");
    			if(result == 1 && result2 == 1) {
					createDialog(
							Alert.AlertType.CONFIRMATION,
                            "Thành công",
                            "", "Đồng chí vất vả rồi!");
					viewUtils.backToView(event, HOKHAU_VIEW);
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
    void goBack(ActionEvent event) throws IOException {
    	ChonNhanKhauController.DeleteSelectedNhanKhau();
    	ViewUtils viewUtils = new ViewUtils();
    	viewUtils.backToView(event, HOKHAU_VIEW);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tenChuHoTextField.setText(chuHoKhau.getHoTen());
    	String ngayTao = LocalDate.now().toString();
    	ngayTaoTextField.setText(ngayTao);
	}

}