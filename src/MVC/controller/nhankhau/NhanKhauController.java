package MVC.controller.nhankhau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class NhanKhauController {

    @FXML
    private TableColumn<?, ?> cccdColumn;

    @FXML
    private TableColumn<?, ?> danTocColumn;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private ToggleGroup filterCategory1;

    @FXML
    private ToggleGroup filterCategory11;

    @FXML
    private TableColumn<?, ?> gioiTinhColumn;

    @FXML
    private TableColumn<?, ?> hoVaTenColumn;

    @FXML
    private TableColumn<?, ?> indexColumn;

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
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private RadioButton radioBtnFilterTitle1;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tonGiaoColumn;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

}
