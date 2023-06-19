package MVC.controller.khaitu;

import static MVC.utils.Utils.LOCAL_DATE;

import java.io.IOException;

import MVC.model.KhaiTu;
import MVC.utils.ViewAddKhaiTuUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DetailKhaiTuController {

    @FXML
    private TableColumn<?, ?> cccdColumn;

    @FXML
    private TableColumn<?, ?> danTocColumn;

    @FXML
    private TableColumn<?, ?> gioiTinhColumn;

    @FXML
    private TableColumn<?, ?> hoVaTenColumn;

    @FXML
    private TableColumn<?, ?> indexColumn;

    @FXML
    private TextField lyDoTextField;

    @FXML
    private DatePicker ngayChetDatePicker;
    
    @FXML
    private DatePicker ngayKhaiDatePicker;

    @FXML
    private TableColumn<?, ?> ngaySinhColumn;

    @FXML
    private TableColumn<?, ?> ngheNghiepColumn;

    @FXML
    private TableColumn<?, ?> nguyenQuanColumn;

    @FXML
    private TableColumn<?, ?> noiThuongTruColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TableColumn<?, ?> quocTichColumn;

    @FXML
    private Button returnToKhaiTuButton;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tonGiaoColumn;

    @FXML
    private Button updateKhaiTuButton;

    @FXML
    void returnToKhaiTu(ActionEvent event) throws IOException {
    	ViewAddKhaiTuUtils viewAddKhaiTuUtils = new ViewAddKhaiTuUtils();
    	viewAddKhaiTuUtils.switchToKhaiTu_HomeView(event);
    }
    
    public void setKhaiTu(KhaiTu khaiTu) {
    	ngayChetDatePicker.setValue(LOCAL_DATE(khaiTu.getNgayChet()));
    	ngayKhaiDatePicker.setValue(LOCAL_DATE(khaiTu.getNgayKhai()));
    	lyDoTextField.setText(khaiTu.getLyDoChet());
    }

}
