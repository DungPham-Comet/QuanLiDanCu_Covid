package MVC.controller.hokhau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AddHoKhauController {

    @FXML
    private Button add_btn;

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<?, ?> cccdColumn;

    @FXML
    private TableColumn<?, ?> danTocColumn;

    @FXML
    private TextField diaChiTextField;

    @FXML
    private TableColumn<?, ?> gioiTinhColumn;

    @FXML
    private TableColumn<?, ?> hoVaTenColumn;

    @FXML
    private TableColumn<?, ?> indexColumn;

    @FXML
    private Text luaChonLabel;

    @FXML
    private Text luaChonLabel1;

    @FXML
    private TextField maChuHoTextField;

    @FXML
    private TableColumn<?, ?> ngaySinhColumn;

    @FXML
    private TableColumn<?, ?> ngheNghiepColumn;

    @FXML
    private TableColumn<?, ?> nguyenQuanColumn;

    @FXML
    private TableColumn<?, ?> noiThuongTruColumn;

    @FXML
    private TableColumn<?, ?> quocTichColumn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Text tenChuHoLabel;

    @FXML
    private TextField tenChuHoTextField;

    @FXML
    private Text title;

    @FXML
    private TableColumn<?, ?> tonGiaoColumn;

    @FXML
    void addnew(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }

}
