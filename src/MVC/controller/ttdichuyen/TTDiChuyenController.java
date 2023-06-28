package MVC.controller.ttdichuyen;

import static MVC.constans.FXMLConstans.*;

import java.io.IOException;

import MVC.model.LichTrinh;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TTDiChuyenController {

    @FXML
    private Button addTTDiChuyenButton;

    @FXML
    private Button deleteTTDiChuyenButton;

    @FXML
    private TextField lichTrinhTextField;

    @FXML
    private TextField nguoiKhaiTextField;

    @FXML
    private Button returnButton;
    
    private LichTrinh lichTrinh;
    
    public void setLichTrinh(LichTrinh lichTrinh) {
    	this.lichTrinh = lichTrinh;
    	nguoiKhaiTextField.setText(lichTrinh.getTenNguoiKhai());
    	lichTrinhTextField.setText(lichTrinh.getTenLichTrinh());
    }

    @FXML
    void addTTDiChuyen(ActionEvent event) {

    }

    @FXML
    void deleteTTDiChuyen(ActionEvent event) {

    }

    @FXML
    void returnToLichTrinh(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, LICHTRINH_VIEW);
    }

}
