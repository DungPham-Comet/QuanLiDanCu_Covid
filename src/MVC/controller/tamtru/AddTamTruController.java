package MVC.controller.tamtru;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AddTamTruController {

    @FXML
    private Button add_btn;

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<?, ?> biDanhColumn;

    @FXML
    private TableColumn<?, ?> cccd2Column;

    @FXML
    private TextField diaChiTextField1;

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
    private TableView<?> tableView;

    @FXML
    private Text tenChuHoLabel;

    @FXML
    private TextField tenChuHoTextField;

    @FXML
    private Text title;

    @FXML
    void addnew(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }

}
