package MVC.controller.nhankhau;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.services.NhanKhauServices;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.*;
import static MVC.constans.DBConstans.*;

public class AddNhanKhauController implements Initializable {

    @FXML
    private Button add_btn;

    @FXML
    private TextField cccdTextField;

    @FXML
    private TextField danTocTextField;

    @FXML
    private ChoiceBox<String> gioiTinhChoiceBox;

    @FXML
    private TextField hoVaTenTextField;

    @FXML
    private DatePicker ngaySinhDatePicker;

    @FXML
    private TextField ngheNghiepTextField;

    @FXML
    private TextField nguyenQuanTextField;

    @FXML
    private TextField noiThuongTruTextField;

    @FXML
    private TextField quocTichTextField;

    @FXML
    private Text title;

    @FXML
    private TextField tonGiaoTextField;
    
    @FXML
    private Text dacDiemLabel;
    
    @FXML
    private TextField dacDiemTextField;
    
    @FXML
    private DatePicker ngayCapDatePicker;

    @FXML
    private Text ngayCapLabel;
    
    @FXML
    private DatePicker ngayHetDatePicker;

    @FXML
    private Text ngayHetLabel;
    
    @FXML
    private Text noiCapLabel;

    @FXML
    private TextField noiCapTextField;

    @FXML
    void add(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	if(ngaySinhDatePicker.getValue() == null) createDialog(
    			Alert.AlertType.WARNING,
    			"Đồng chí giữ bình tĩnh",
    			"", "Vui lòng nhập đủ thông tin!");
    	else {
    		String hoTen = hoVaTenTextField.getText();
    		String ngaySinh = ngaySinhDatePicker.getValue().toString();
    		String cccd = cccdTextField.getText();
    		String gioiTinh = gioiTinhChoiceBox.getValue();
    		String nguyenQuan = nguyenQuanTextField.getText();
    		String danToc = danTocTextField.getText();
    		String thuongTru = noiThuongTruTextField.getText();
    		String tonGiao = tonGiaoTextField.getText();
    		String quocTich = quocTichTextField.getText();
    		String ngheNghiep = ngheNghiepTextField.getText();
    		String ngayCap;
    		String ngayHetHan;
    		if(cccd.equals("")) {
    			ngayCap = "";
    			ngayHetHan = "";
    		}
    		else {
				ngayCap = ngayCapDatePicker.getValue().toString();
				ngayHetHan = ngayHetDatePicker.getValue().toString();
			}
    		String noiCap = noiCapTextField.getText();
    		String dacDiem = dacDiemTextField.getText();
    		if(hoTen.trim().equals("") || ngaySinh.trim().equals("") || gioiTinh.trim().equals("") || nguyenQuan.trim().equals("") || thuongTru.trim().equals("")) {
    			createDialog(
    					Alert.AlertType.WARNING,
                        "Đồng chí giữ bình tĩnh",
                        "", "Vui lòng nhập đủ thông tin!");
    		}
    		else {
    			boolean gioitinh;
    			if(gioiTinh.equals("Nam")) {
    				gioitinh = true;
    			}
    			else gioitinh = false;
    			try {
    				Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    				int result = NhanKhauServices.addNhanKhau(conn, hoTen, ngaySinh, nguyenQuan, gioitinh, danToc, thuongTru, tonGiao, quocTich, ngheNghiep, cccd);
    				if(cccd.equals("") == false) {
    					int result2 = NhanKhauServices.addCccd(conn, cccd, ngayCap, ngayHetHan, noiCap, dacDiem);
    				}
    				if(result == 1) {
    					createDialog(
    							Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đồng chí vất vả rồi!");
    					viewUtils.backToView(event, NHANKHAU_VIEW);
    				}
    				else {
    					createDialog(
    							Alert.AlertType.ERROR,
                                "Thất bại",
                                "", "Oops, mời đồng chí nhập lại thông tin!");
    				}
    				conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}
    	}
    }

    @FXML
    void addCccd(ActionEvent event) {
    	ngayCapLabel.setVisible(true);
    	ngayCapDatePicker.setVisible(true);
    	ngayHetLabel.setVisible(true);
    	ngayHetDatePicker.setVisible(true);
    	noiCapLabel.setVisible(true);
    	noiCapTextField.setVisible(true);
    	dacDiemLabel.setVisible(true);
    	dacDiemTextField.setVisible(true);
    }
    
    @FXML
    void goBack(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	viewUtils.backToView(event, NHANKHAU_VIEW);
    }

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
        gioiTinhChoiceBox.getItems().add("Nam");
        gioiTinhChoiceBox.getItems().add("Nữ");
        gioiTinhChoiceBox.setValue("Nam");
		
	}

}
