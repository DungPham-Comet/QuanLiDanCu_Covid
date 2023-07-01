package MVC.controller.xetnghiem;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.LOCAL_DATE;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import MVC.model.CachLy;
import MVC.model.XetNghiem;
import MVC.services.CachLyServices;
import MVC.services.XetNghiemServices;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DetailXetNghiemController {

    @FXML
    private Button addButton;

    @FXML
    private TextField hinhThucTextField;

    @FXML
    private TextField ketQuaTextField;

    @FXML
    private TextField nguoiXetNghiemTextField;

    @FXML
    private Button returnButton;

    @FXML
    private TextField thoiGianTextField;
    
    private int idXetNghiem;
    
    public int getIdXetNghiem() {
    	return this.idXetNghiem;
    }
    
    public void setIdXetNghiem(int id) {
    	this.idXetNghiem = id;
    }
    
    public void setXetNghiem(XetNghiem xetNghiem) {
    	thoiGianTextField.setText(xetNghiem.getThoiGian());
    	nguoiXetNghiemTextField.setText(xetNghiem.getTenNguoiXetNghiem());
    	hinhThucTextField.setText(xetNghiem.getHinhThuc());
    	ketQuaTextField.setText(xetNghiem.getKetQua());
    }

    @FXML
    void addXetNghiemButton(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String tenNguoiXetNghiem = nguoiXetNghiemTextField.getText();
    	String hinhThuc = hinhThucTextField.getText();
    	String thoiGian = thoiGianTextField.getText();
    	String ketQua = ketQuaTextField.getText();
    	if(thoiGian.trim().equals("") || hinhThuc.trim().equals("") || ketQua.trim().equals("")) {
    		createDialog(
    				Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	try {
    		Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			int result = XetNghiemServices.updateXetNghiem(conn, hinhThuc, thoiGian, ketQua, idXetNghiem);
			System.out.println("Id: " + idXetNghiem);
    		if(result == 1) {
    			createDialog(
    					Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đồng chí vất vả rồi!");
    			viewUtils.backToView(event, XETNGHIEM_VIEW);
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

    @FXML
    void returnToXetNghiem(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, XETNGHIEM_VIEW);
    }

}
