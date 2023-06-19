package MVC.controller.khaitu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import MVC.model.KhaiTu;
import MVC.model.NhanKhau;
import MVC.services.KhaiTuServices;
import MVC.utils.ViewUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import static MVC.constans.FXMLConstans.*;
import static MVC.constans.DBConstans.*;

public class KhaiTuController implements Initializable{
	
	@FXML
    private AnchorPane basePane;
	
	@FXML
	private TableColumn<KhaiTu, Integer> idKhaiTuCol;

	@FXML
	private TableColumn<KhaiTu, String> lyDoCol;

	@FXML
	private TableColumn<KhaiTu, String> ngayChetCol;

	@FXML
	private TableColumn<KhaiTu, String> ngayKhaiCol;

	@FXML
	private TableColumn<KhaiTu, String> nguoiChetCol;

	@FXML
	private Pagination pagination;

	@FXML
	private TextField searchTextField;

	@FXML
	private TableView<KhaiTu> tableKhaiTu;
	
	@FXML
    private URL location;
	
    @FXML
    private ResourceBundle resources;
    
	private ObservableList<KhaiTu> khaiTuList = FXCollections.observableArrayList();
	
	private Connection conn;

    private PreparedStatement preparedStatement = null;
    
    private final ViewUtils viewUtils = new ViewUtils();
    
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        try {
            conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            ResultSet result = KhaiTuServices.getAllFacility(conn);
            while (result.next()) {
            	String deadName = KhaiTuServices.getTenNguoiChet(conn, result.getInt("idNguoiChet"));
                String khaiName = KhaiTuServices.getTenNguoiKhai(conn, result.getInt("idNguoiKhai"));
                khaiTuList.add(new KhaiTu(result.getInt("idKhaiTu"), deadName, khaiName,
                		result.getString("ngayKhai"), result.getString("ngayChet"), result.getString("lyDoChet")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int soDu = khaiTuList.size() % ROWS_PER_PAGE;
        
        if (soDu != 0) pagination.setPageCount(khaiTuList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(khaiTuList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);

        tableKhaiTu.setRowFactory(tv -> {
            TableRow<KhaiTu> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    detail(event);
                }
            });
            return row;
        });
    }
    
    public void detail(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

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

	public Node createTableView(Integer pageIndex) {
		
        idKhaiTuCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, Integer>("idKhaiTu"));
        nguoiChetCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("tenNguoiChet"));
        ngayChetCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("ngayChet"));
        lyDoCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("lyDoChet"));
        ngayKhaiCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("ngayKhai"));
        
        int lastIndex = 0;
        int displace = khaiTuList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = khaiTuList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = khaiTuList.size() / ROWS_PER_PAGE - 1;
        }
        if (khaiTuList.isEmpty()) tableKhaiTu.setItems(FXCollections.observableArrayList(khaiTuList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
                tableKhaiTu.setItems(FXCollections.observableArrayList(khaiTuList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                tableKhaiTu.setItems(FXCollections.observableArrayList(khaiTuList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
        return tableKhaiTu;
	}
}
