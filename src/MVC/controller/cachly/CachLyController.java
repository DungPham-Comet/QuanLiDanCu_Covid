package MVC.controller.cachly;

import static MVC.constans.DBConstans.ROWS_PER_PAGE;
import static MVC.utils.Utils.convertDate;
import static MVC.utils.Utils.createDialog;
import static MVC.constans.FXMLConstans.*;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.model.CachLy;
import MVC.model.KhaiTu;
import MVC.model.CachLy;
import MVC.services.CachLyServices;
import MVC.services.KhaiTuServices;
import MVC.services.CachLyServices;
import MVC.utils.ViewUtils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CachLyController implements Initializable{

    @FXML
    private Button addCachLyButton;

    @FXML
    private Button deleteCachLyButton;

    @FXML
    private TableColumn<CachLy, String> diaDiemCol;

    @FXML
    private TableColumn indexCol;

    @FXML
    private TableColumn<CachLy, String> mucDoCol;

    @FXML
    private RadioButton mucDoRadioButton;

    @FXML
    private RadioButton nameRadioButton;

    @FXML
    private TableColumn<CachLy, String> nguoiCachLyCol;

    @FXML
    private Pagination pagination;
    
    @FXML
    private ToggleGroup group;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<CachLy> tableCachLy;

    @FXML
    private TableColumn<CachLy, String> thoiGianCol;
    
    @FXML
    private URL location;
	
    @FXML
    private ResourceBundle resources;
    
	private ObservableList<CachLy> cachLyList = FXCollections.observableArrayList();
	
    private final ViewUtils viewUtils = new ViewUtils();
    
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        try {
            ResultSet result = CachLyServices.getAllCachLy();
            while (result.next()) {
            	cachLyList.add(new CachLy(result.getInt("IdCachLy"), convertDate(result.getString("ThoiGian")), result.getString("MucDo"), result.getString("DiaDiem"), result.getString("TenNguoiCachLy")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int soDu = cachLyList.size() % ROWS_PER_PAGE;
        
        if (soDu != 0) pagination.setPageCount(cachLyList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(cachLyList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);

        tableCachLy.setRowFactory(tv -> {
            TableRow<CachLy> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    try {
						detail(event);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
                }
            });
            return row;
        });
    }
    
public void detail(MouseEvent event) throws IOException {
    	
    	CachLy selected = tableCachLy.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một mục");
    	}
    	else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(DETAIL_CACHLY_VIEW));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            DetailCachLyController controller = loader.getController();
            controller.setCachLy(selected);
            controller.setIdCachLy(selected.getIdCachLy());
            //System.out.println("ID: " + selected.getIdCachLy());
            stage.setScene(scene);
    	}
		
	}

	@SuppressWarnings("unchecked")
	public Node createTableView(Integer pageIndex) {
		indexCol.setCellValueFactory((Callback<TableColumn.CellDataFeatures<CachLy, CachLy>, ObservableValue<CachLy>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
		indexCol.setCellFactory(new Callback<TableColumn<CachLy, CachLy>, TableCell<CachLy, CachLy>>() {
        @Override
        public TableCell<CachLy, CachLy> call(TableColumn<CachLy, CachLy> param) {
            return new TableCell<CachLy, CachLy>() {
                @Override
                protected void updateItem(CachLy item, boolean empty) {
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
		indexCol.setSortable(false);
		nguoiCachLyCol.setCellValueFactory(new PropertyValueFactory<CachLy, String>("nguoiCachLy"));
		mucDoCol.setCellValueFactory(new PropertyValueFactory<CachLy, String>("mucDo"));
		diaDiemCol.setCellValueFactory(new PropertyValueFactory<CachLy, String>("diaDiem"));
		thoiGianCol.setCellValueFactory(new PropertyValueFactory<CachLy, String>("thoiGian"));
    
		int lastIndex = 0;
		int displace = cachLyList.size() % ROWS_PER_PAGE;
		if (displace > 0) {
			lastIndex = cachLyList.size() / ROWS_PER_PAGE;
		} else {
        lastIndex = cachLyList.size() / ROWS_PER_PAGE - 1;
    }
    if (cachLyList.isEmpty()) tableCachLy.setItems(FXCollections.observableArrayList(cachLyList));
    else {
        if (lastIndex == pageIndex && displace > 0) {
            tableCachLy.setItems(FXCollections.observableArrayList(cachLyList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
        	} 	else 	{
            	tableCachLy.setItems(FXCollections.observableArrayList(cachLyList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
        	}
    	}
    	return tableCachLy;
	}
    
    @FXML
    void addCachLy(ActionEvent event) {

    }

    @FXML
    void deleteCachLy(ActionEvent event) {
    	CachLy selected = tableCachLy.getSelectionModel().getSelectedItem();
        if (selected == null) createDialog(Alert.AlertType.WARNING,
                "Cảnh báo",
                "Vui lòng chọn một mục để tiếp tục", "");
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận xóa thông tin");
            alert.setContentText("Đồng chí muốn xóa thông tin cách ly này?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    // Delete in Database
                    try {
                        int ID = selected.getIdCachLy();
                        int result1 = CachLyServices.deleteCachLy(ID);
                        if (result1 == 1) createDialog(Alert.AlertType.INFORMATION, "Thông báo", "Xóa thành công!", "");
                        else createDialog(Alert.AlertType.WARNING, "Thông báo", "Có lỗi, thử lại sau!", "");
                        ViewUtils viewUtils = new ViewUtils();
                        viewUtils.backToView(event, CACHLY_VIEW);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    @FXML
    void search(MouseEvent event) {

    }

}
