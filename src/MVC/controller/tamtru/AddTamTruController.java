package MVC.controller.tamtru;

import static MVC.constans.FXMLConstans.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MVC.controller.nhankhau.ChonNhanKhauController;
import MVC.model.NhanKhau;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddTamTruController implements Initializable {

    @FXML
    private Button add_btn;

    @FXML
    private AnchorPane basePane;

    @FXML
    private DatePicker ngayBatDauDatePicker;

    @FXML
    private DatePicker ngayKetThucDatePicker;

    @FXML
    private TextField tenChuHoTextField;

    @FXML
    private TextField tenTamTruTextField;

    @FXML
    private Text title;
    

    @FXML
    void addnew(ActionEvent event) {

    }

    @FXML
    void chonHoKhau(ActionEvent event) {

    }

    @FXML
    void chonTamTru(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CHON_NHAN_KHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        ChonNhanKhauController controller = loader.getController();
        controller.setPreviousPage(ADD_TAMTRU_VIEW);
        stage.setScene(scene);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
