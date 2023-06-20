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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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
import MVC.controller.nhankhau.DetailNhanKhauController;
import MVC.model.KhaiTu;
import MVC.model.NhanKhau;
import MVC.services.KhaiTuServices;
import MVC.services.NhanKhauServices;
import MVC.utils.ViewUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import static MVC.utils.Utils.*;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.createDialog;
import static com.quartermanagement.Constants.DBConstants.ROWS_PER_PAGE;
import static MVC.constans.DBConstans.*;

public class KhaiTuController implements Initializable{
	
	@FXML
  private AnchorPane basePane;
  
    @FXML
    private TableColumn<KhaiTu, Integer> indexColumn;

	@FXML
	private TableColumn<KhaiTu, String> lyDoCol;

	@FXML
	private TableColumn<KhaiTu, String> ngayChetCol;

	@FXML
	private TableColumn<KhaiTu, String> ngayKhaiCol;

	@FXML
	private TableColumn<KhaiTu, String> nguoiChetCol;
	
    @FXML
    private TableColumn<KhaiTu, String> nguoiKhaiCol;

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
            ResultSet result = KhaiTuServices.getAllKhaiTu();
            while (result.next()) {
            	khaiTuList.add(new KhaiTu(result.getInt("IdKhaiTu"), result.getString("TenNguoiChet"), result.getString("TenNguoiKhai"), convertDate(result.getString("NgayKhai")),convertDate(result.getString("NgayChet")), result.getString("LyDoChet")));
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
                    try {
						detail(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            });
            return row;
        });
    }
    
    public void detail(MouseEvent event) throws IOException {
    	
    	KhaiTu selected = tableKhaiTu.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một mục");
    	}
    	else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(DETAIL_KHAITU_VIEW));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            DetailKhaiTuController controller = loader.getController();
            controller.setKhaiTu(selected);
            stage.setScene(scene);
    	}
		
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
    	KhaiTu selected = tableKhaiTu.getSelectionModel().getSelectedItem();
        if (selected == null) createDialog(Alert.AlertType.WARNING,
                "Cảnh báo",
                "Vui lòng chọn một mục để tiếp tục", "");
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận xóa thông tin");
            alert.setContentText("Đồng chí muốn xóa thông tin khai tử này?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    // Delete in Database
                    try {
                        int ID = selected.getIdKhaiTu();
                        int result1 = KhaiTuServices.deleteKhaiTu(ID);
                        if (result1 == 1) createDialog(Alert.AlertType.INFORMATION, "Thông báo", "Xóa thành công!", "");
                        else createDialog(Alert.AlertType.WARNING, "Thông báo", "Có lỗi, thử lại sau!", "");
                        ViewUtils viewUtils = new ViewUtils();
                        viewUtils.backToView(event, KHAITU_VIEW);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
    
	@SuppressWarnings("unchecked")
	public Node createTableView(Integer pageIndex) {
		indexColumn.setCellValueFactory(new PropertyValueFactory<KhaiTu, Integer>("idKhaiTu"));
        nguoiChetCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("tenNguoiChet"));
        nguoiKhaiCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("tenNguoiKhai"));
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
	
	public void search() {
        FilteredList<KhaiTu> filteredData = new FilteredList<>(khaiTuList, p -> true);
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(khaiTu -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (khaiTu.getTenNguoiChet().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
            int soDu = filteredData.size() % ROWS_PER_PAGE;
            if (soDu != 0) pagination.setPageCount(filteredData.size() / ROWS_PER_PAGE + 1);
            else pagination.setPageCount(filteredData.size() / ROWS_PER_PAGE);
            pagination.setMaxPageIndicatorCount(5);
            pagination.setPageFactory(pageIndex -> {
                indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<KhaiTu, KhaiTu>, ObservableValue<KhaiTu>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
                indexColumn.setCellFactory(new Callback<TableColumn<KhaiTu, KhaiTu>, TableCell<KhaiTu, KhaiTu>>() {
                    @Override
                    public TableCell<KhaiTu, KhaiTu> call(TableColumn<KhaiTu, KhaiTu> param) {
                        return new TableCell<KhaiTu, KhaiTu>() {
                            @Override
                            protected void updateItem(KhaiTu item, boolean empty) {
                                super.updateItem(item, empty);

                                if (this.getTableRow() != null && item != null) {
                                    setText(this.getTableRow().getIndex() + 1 + pageIndex * ROWS_PER_PAGE + "");
                                } else {
                                    setText("");
                                }
                            }
                        };
                    }
                });

                indexColumn.setCellValueFactory(new PropertyValueFactory<KhaiTu, Integer>("idKhaiTu"));
                nguoiChetCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("tenNguoiChet"));
                nguoiKhaiCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("tenNguoiKhai"));
                ngayChetCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("ngayChet"));
                lyDoCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("lyDoChet"));
                ngayKhaiCol.setCellValueFactory(new PropertyValueFactory<KhaiTu, String>("ngayKhai"));
                int lastIndex = 0;
                int displace = filteredData.size() % ROWS_PER_PAGE;
                if (displace > 0) {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE;
                } else {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE - 1;
                }
                if (filteredData.isEmpty()) tableKhaiTu.setItems(FXCollections.observableArrayList(filteredData));
                else {
                    if (lastIndex == pageIndex && displace > 0) {
                        tableKhaiTu.setItems(FXCollections.observableArrayList(filteredData.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
                    } else {
                        tableKhaiTu.setItems(FXCollections.observableArrayList(filteredData.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
                    }
                }
                return tableKhaiTu;
            });
        });
    }
	
	
}
