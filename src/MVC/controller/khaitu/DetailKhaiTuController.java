package MVC.controller.khaitu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import MVC.model.KhaiTu;
import MVC.services.KhaiTuServices;
import MVC.services.NhanKhauServices;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.LOCAL_DATE;
import static MVC.utils.Utils.createDialog;

public class DetailKhaiTuController {

    @FXML
    private TextField lyDoTextField;

    @FXML
    private DatePicker ngayChetDatePicker;

    @FXML
    private DatePicker ngayKhaiDatePicker;

    @FXML
    private Button returnToKhaiTuButton;

    @FXML
    private TextField tenNguoiChetTextField;

    @FXML
    private TextField tenNguoiKhaiTextField;

    @FXML
    private Button updateKhaiTuButton;
    
    private int idKhaiTu;
    
    public int getIdKhaiTu() {
    	return this.idKhaiTu;
    }
    
    public void setIdKhaiTu(int id) {
    	this.idKhaiTu = id;
    }

    @FXML
    void returnToKhaiTu(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, KHAITU_VIEW);
    }
    
    public void setKhaiTu(KhaiTu khaiTu) {
    	ngayChetDatePicker.setValue(LOCAL_DATE(khaiTu.getNgayChet()));
    	ngayKhaiDatePicker.setValue(LOCAL_DATE(khaiTu.getNgayKhai()));
    	tenNguoiChetTextField.setText(khaiTu.getTenNguoiChet());
    	tenNguoiKhaiTextField.setText(khaiTu.getTenNguoiKhai());
    	lyDoTextField.setText(khaiTu.getLyDoChet());
    }
    
    @FXML
    void updateKhaiTu(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String tenNguoiChet = tenNguoiChetTextField.getText();
    	String tenNguoiKhai = tenNguoiKhaiTextField.getText();
    	String lyDoChet = lyDoTextField.getText();
    	String ngayChet = ngayChetDatePicker.getValue().toString();
    	String ngayKhai = ngayKhaiDatePicker.getValue().toString();
    	if(tenNguoiChet.trim().equals("") || tenNguoiKhai.trim().equals("") || lyDoChet.trim().equals("")) {
    		createDialog(
    				Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	try {
    		Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			int result = KhaiTuServices.updateKhaiTu(conn, lyDoChet, ngayChet, ngayKhai, idKhaiTu);
			System.out.println("Id: " + idKhaiTu);
    		if(result == 1) {
    			createDialog(
    					Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đồng chí vất vả rồi!");
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
					e.printStackTrace();
				}
    		}
    }

