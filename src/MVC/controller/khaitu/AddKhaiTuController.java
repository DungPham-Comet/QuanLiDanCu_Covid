package MVC.controller.khaitu;

import static MVC.constans.FXMLConstans.KHAITU_VIEW;

import java.io.IOException;

import MVC.utils.ViewAddKhaiTuUtils;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AddKhaiTuController {

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
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tonGiaoColumn;

    @FXML
    void returnToKhaiTu(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, KHAITU_VIEW);
    }

}
