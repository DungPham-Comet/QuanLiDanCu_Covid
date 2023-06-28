package MVC.controller.lichtrinh;

import static MVC.constans.DBConstans.ROWS_PER_PAGE;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.convertDate;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.controller.khaitu.DetailKhaiTuController;
import MVC.controller.ttdichuyen.TTDiChuyenController;
import MVC.model.KhaiTu;
import MVC.model.LichTrinh;
import MVC.model.LichTrinh;
import MVC.services.KhaiTuServices;
import MVC.services.LichTrinhServices;
import MVC.services.LichTrinhServices;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class LichTrinhController implements Initializable{

	@FXML
	private AnchorPane basePane;
	
    @FXML
    private Button addLichTrinhButton;

    @FXML
    private Button deleteLichTrinhButton;

    @FXML
    private TableColumn<LichTrinh, String> diChuyenColumn;

    @FXML
    private TableColumn indexColumn;

    @FXML
    private Pagination lichTrinhPagination;

    @FXML
    private TextField lichTrinhSearchTextField;

    @FXML
    private TableView<LichTrinh> lichTrinhTable;

    @FXML
    private TableColumn<LichTrinh, String> nguoiKhaiColumn;
    
    @FXML
    private URL location;
	
    @FXML
    private ResourceBundle resources;
    
    private ObservableList<LichTrinh> lichTrinhList = FXCollections.observableArrayList();
	
    private final ViewUtils viewUtils = new ViewUtils();
    
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        try {
            ResultSet result = LichTrinhServices.getAllLichTrinh();
            while (result.next()) {
            	lichTrinhList.add(new LichTrinh(result.getInt("IdLichTrinh"), result.getString("TenNguoiKhai"), result.getString("TenLichTrinh")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int soDu = lichTrinhList.size() % ROWS_PER_PAGE;
        
        if (soDu != 0) lichTrinhPagination.setPageCount(lichTrinhList.size() / ROWS_PER_PAGE + 1);
        else lichTrinhPagination.setPageCount(lichTrinhList.size() / ROWS_PER_PAGE);
        lichTrinhPagination.setMaxPageIndicatorCount(5);
        lichTrinhPagination.setPageFactory(this::createTableView);

        lichTrinhTable.setRowFactory(tv -> {
            TableRow<LichTrinh> row = new TableRow<>();
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

    	LichTrinh selected = lichTrinhTable.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một mục");
    	}
    	else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(TTDICHUYEN_VIEW));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            TTDiChuyenController controller = loader.getController();
            controller.setLichTrinh(selected);
            stage.setScene(scene);
    	}
		
	}
    
    @SuppressWarnings("unchecked")
	public Node createTableView(Integer pageIndex) {
		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<LichTrinh, LichTrinh>, ObservableValue<LichTrinh>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
        indexColumn.setCellFactory(new Callback<TableColumn<LichTrinh, LichTrinh>, TableCell<LichTrinh, LichTrinh>>() {
            @Override
            public TableCell<LichTrinh, LichTrinh> call(TableColumn<LichTrinh, LichTrinh> param) {
                return new TableCell<LichTrinh, LichTrinh>() {
                    @Override
                    protected void updateItem(LichTrinh item, boolean empty) {
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
        indexColumn.setSortable(false);
        nguoiKhaiColumn.setCellValueFactory(new PropertyValueFactory<LichTrinh, String>("tenNguoiKhai"));
        diChuyenColumn.setCellValueFactory(new PropertyValueFactory<LichTrinh, String>("tenLichTrinh"));
        
        int lastIndex = 0;
        int displace = lichTrinhList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = lichTrinhList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = lichTrinhList.size() / ROWS_PER_PAGE - 1;
        }
        if (lichTrinhList.isEmpty()) lichTrinhTable.setItems(FXCollections.observableArrayList(lichTrinhList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
                lichTrinhTable.setItems(FXCollections.observableArrayList(lichTrinhList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                lichTrinhTable.setItems(FXCollections.observableArrayList(lichTrinhList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
        return lichTrinhTable;
	}

    @FXML
    void addLichTrinh(ActionEvent event) {

    }

    @FXML
    void deleteLichTrinh(ActionEvent event) {
    	LichTrinh selected = lichTrinhTable.getSelectionModel().getSelectedItem();
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
                        int ID = selected.getIdLichTrinh();
                        int result1 = LichTrinhServices.deleteLichTrinh(ID);
                        if (result1 == 1) createDialog(Alert.AlertType.INFORMATION, "Thông báo", "Xóa thành công!", "");
                        else createDialog(Alert.AlertType.WARNING, "Thông báo", "Có lỗi, thử lại sau!", "");
                        ViewUtils viewUtils = new ViewUtils();
                        viewUtils.backToView(event, LICHTRINH_VIEW);
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
