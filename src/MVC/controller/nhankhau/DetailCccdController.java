package MVC.controller.nhankhau;

import static MVC.constans.FXMLConstans.DETAIL_NHANKHAU_VIEW;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.model.Cccd;
import MVC.model.NhanKhau;
import MVC.services.NhanKhauServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailCccdController {

    @FXML
    private TextField cccdTextField;

    @FXML
    private TextField dacDiemTextField;

    @FXML
    private TextField gioiTinhTextField;

    @FXML
    private TextField hoVaTenTextField;

    @FXML
    private TextField ngayCapTextField;

    @FXML
    private TextField ngayHetTextField;

    @FXML
    private TextField ngaySinhTextField;

    @FXML
    private TextField nguyenQuanTextField;

    @FXML
    private TextField noiCapTextField;

    @FXML
    private TextField noiThuongTruTextField;

    @FXML
    private Text title;
    
    private NhanKhau nhanKhau;
    
	public void setNhanKhau(NhanKhau nhanKhau) {
		this.nhanKhau = nhanKhau;
		try {
			System.out.println(nhanKhau.getHoTen());
			System.out.println(nhanKhau.getMaCccd());
			ResultSet result = NhanKhauServices.getCCCd(nhanKhau.getIdNhanKhau());
			while(result.next()) {
				hoVaTenTextField.setText(result.getString("HoTen"));
				ngaySinhTextField.setText(result.getString("DOB"));
				cccdTextField.setText(result.getString("MaCccd"));
				nguyenQuanTextField.setText(result.getString("NguyenQuan"));
				noiThuongTruTextField.setText(result.getString("ThuongTru"));
				ngayCapTextField.setText(result.getString("NgayCap"));
				ngayHetTextField.setText(result.getString("NgayHetHan"));
				noiCapTextField.setText(result.getString("NoiCap"));
				dacDiemTextField.setText(result.getString("DacDiem"));
				if(result.getBoolean("GioiTinh")) {
					gioiTinhTextField.setText("Nam");
				}
				else {
					gioiTinhTextField.setText("Nữ");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(DETAIL_NHANKHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        DetailNhanKhauController controller = loader.getController();
        controller.setNhanKhau(nhanKhau);
        controller.setId(nhanKhau.getIdNhanKhau());
        stage.setScene(scene);		
    }

}
