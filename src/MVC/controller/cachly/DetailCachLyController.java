package MVC.controller.cachly;

import static MVC.constans.DBConstans.*;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.LOCAL_DATE;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import MVC.model.CachLy;
import MVC.model.KhaiTu;
import MVC.services.CachLyServices;
import MVC.services.KhaiTuServices;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DetailCachLyController {

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

    @FXML
    private Button updateButton;
    
    private int idCachLy;
    
    public int getIdCachLy() {
    	return this.idCachLy;
    }
    
    public void setIdCachLy(int id) {
    	this.idCachLy = id;
    }
    
    public void setCachLy(CachLy cachLy) {
    	thoiGianDatePicker.setValue(LOCAL_DATE(cachLy.getThoiGian()));
    	nguoiCachLyTextField.setText(cachLy.getNguoiCachLy());
    	mucDoTextField.setText(cachLy.getMucDo());
    	diaDiemTextField.setText(cachLy.getDiaDiem());
    }
    
    @FXML
    void returnToCachLy(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, CACHLY_VIEW);
    }

    @FXML
    void updateCachLy(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	String tenNguoiCachLy = nguoiCachLyTextField.getText();
    	String mucDo = mucDoTextField.getText();
    	String thoiGian = thoiGianDatePicker.getValue().toString();
    	String diaDiem = diaDiemTextField.getText();
    	if(mucDo.trim().equals("") || tenNguoiCachLy.trim().equals("") || diaDiem.trim().equals("")) {
    		createDialog(
    				Alert.AlertType.WARNING,
                    "Đồng chí giữ bình tĩnh",
                    "", "Vui lòng nhập đủ thông tin!");
    	}
    	try {
    		Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			int result = CachLyServices.updateCachLy(conn, mucDo, thoiGian, diaDiem, idCachLy);
			System.out.println("Id: " + idCachLy);
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
					e.printStackTrace();
				}
    	}
}