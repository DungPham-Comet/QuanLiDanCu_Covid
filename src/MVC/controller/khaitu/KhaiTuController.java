package MVC.controller.khaitu;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import MVC.model.KhaiTu;
import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static MVC.constans.FXMLConstans.*;


public class KhaiTuController {
	
	@FXML
    private AnchorPane basePane;
	
	@FXML
	private TableColumn<KhaiTu, ?> idKhaiTu;

	@FXML
	private TableColumn<?, ?> lyDo;

	@FXML
	private TableColumn<?, ?> ngayChet;

	@FXML
	private TableColumn<?, ?> ngayKhai;

	@FXML
	private TableColumn<?, ?> nguoiChet;

	@FXML
	private Pagination pagination;

	@FXML
	private TextField searchTextField;

	@FXML
	private TableView<KhaiTu> tableKhaiTu;
    
    private final ViewUtils viewUtils = new ViewUtils();
    
    @FXML
    public void addKhaiTu(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ADD_KHAITU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        stage.setScene(scene);
    }
    
    @FXML
    void deleteKhaiTu(ActionEvent event) {

    }
}
