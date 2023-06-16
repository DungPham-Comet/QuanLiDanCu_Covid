package MVC.controller.tamvang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TamVangController {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<?, ?> diaChiColumn;

    @FXML
    private TableColumn<?, ?> indexColumn;

    @FXML
    private TableColumn<?, ?> maHoKhauColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tenChuHoColumn;

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
