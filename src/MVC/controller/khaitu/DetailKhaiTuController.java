package MVC.controller.khaitu;

import java.io.IOException;

import MVC.model.KhaiTu;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static MVC.constans.FXMLConstans.*;

public class DetailKhaiTuController {

    @FXML
    private TextField lyDoTextField;

    @FXML
    private TextField ngayChetTextField;

    @FXML
    private TextField ngayKhaiTextField;

    @FXML
    private Button returnToKhaiTuButton;

    @FXML
    private TextField tenNguoiChetTextField;

    @FXML
    private TextField tenNguoiKhaiTextField;

    @FXML
    private Button updateKhaiTuButton;

    @FXML
    void returnToKhaiTu(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, KHAITU_VIEW);
    }
    
    public void setKhaiTu(KhaiTu khaiTu) {
    	ngayChetTextField.setText((khaiTu.getNgayChet()));
    	ngayKhaiTextField.setText((khaiTu.getNgayKhai()));
    	tenNguoiChetTextField.setText(khaiTu.getTenNguoiChet());
    	tenNguoiKhaiTextField.setText(khaiTu.getTenNguoiKhai());
    	lyDoTextField.setText(khaiTu.getLyDoChet());
    	lyDoTextField.setText(khaiTu.getLyDoChet());
    }
    
    @FXML
    void updateKhaiTu(ActionEvent event) throws IOException {
    	
    }

}
