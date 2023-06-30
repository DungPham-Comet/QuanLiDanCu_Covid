package MVC.controller.cachly;

import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.LOCAL_DATE;

import java.io.IOException;

import MVC.model.CachLy;
import MVC.model.KhaiTu;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void updateCachLy(ActionEvent event) {

    }

}
