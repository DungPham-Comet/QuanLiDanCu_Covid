package MVC.controller.xetnghiem;

import static MVC.constans.DBConstans.ROWS_PER_PAGE;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.convertDate;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.model.XetNghiem;
import MVC.model.XetNghiem;
import MVC.model.XetNghiem;
import MVC.services.XetNghiemServices;
import MVC.services.XetNghiemServices;
import MVC.services.XetNghiemServices;
import MVC.utils.ViewUtils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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

public class XetNghiemController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ToggleGroup gr;

    @FXML
    private TableColumn<XetNghiem, String> hinhThucCol;

    @FXML
    private TableColumn indexCol;

    @FXML
    private TableColumn<XetNghiem, String> ketQuaCol;

    @FXML
    private RadioButton ketQuaRadioButton;

    @FXML
    private RadioButton nameRadioButton;

    @FXML
    private TableColumn<XetNghiem, String> nguoiXetNghiemCol;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<XetNghiem> tableXetNghiem;

    @FXML
    private TableColumn<XetNghiem, String> thoiGianCol;
    
    @FXML
    private URL location;
	
    @FXML
    private ResourceBundle resources;
    
	private ObservableList<XetNghiem> xetNghiemList = FXCollections.observableArrayList();
	
    private final ViewUtils viewUtils = new ViewUtils();
    
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        try {
            ResultSet result = XetNghiemServices.getAllXetNghiem();
            while (result.next()) {
            	xetNghiemList.add(new XetNghiem(result.getInt("IdXetNghiem"), result.getString("HinhThuc"), result.getString("ThoiGian"), result.getString("KetQua"), result.getString("TenNguoiXetNghiem")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int soDu = xetNghiemList.size() % ROWS_PER_PAGE;
        
        if (soDu != 0) pagination.setPageCount(xetNghiemList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(xetNghiemList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);

        tableXetNghiem.setRowFactory(tv -> {
            TableRow<XetNghiem> row = new TableRow<>();
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
    	
    	XetNghiem selected = tableXetNghiem.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một mục");
    	}
    	else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(DETAIL_XETNGHIEM_VIEW));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            DetailXetNghiemController controller = loader.getController();
            controller.setXetNghiem(selected);
            controller.setIdXetNghiem(selected.getIdXetNghiem());
            //System.out.println("ID: " + selected.getIdXetNghiem());
            stage.setScene(scene);
    	}
		
	}
    
    @SuppressWarnings("unchecked")
	public Node createTableView(Integer pageIndex) {
		indexCol.setCellValueFactory((Callback<TableColumn.CellDataFeatures<XetNghiem, XetNghiem>, ObservableValue<XetNghiem>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
		indexCol.setCellFactory(new Callback<TableColumn<XetNghiem, XetNghiem>, TableCell<XetNghiem, XetNghiem>>() {
        @Override
        public TableCell<XetNghiem, XetNghiem> call(TableColumn<XetNghiem, XetNghiem> param) {
            return new TableCell<XetNghiem, XetNghiem>() {
                @Override
                protected void updateItem(XetNghiem item, boolean empty) {
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
		nguoiXetNghiemCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("tenNguoiXetNghiem"));
		hinhThucCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("hinhThuc"));
		thoiGianCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("thoiGian"));
		ketQuaCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("ketQua"));
    
		int lastIndex = 0;
		int displace = xetNghiemList.size() % ROWS_PER_PAGE;
		if (displace > 0) {
			lastIndex = xetNghiemList.size() / ROWS_PER_PAGE;
		} else {
        lastIndex = xetNghiemList.size() / ROWS_PER_PAGE - 1;
    }
    if (xetNghiemList.isEmpty()) tableXetNghiem.setItems(FXCollections.observableArrayList(xetNghiemList));
    else {
        if (lastIndex == pageIndex && displace > 0) {
            tableXetNghiem.setItems(FXCollections.observableArrayList(xetNghiemList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
        	} 	else 	{
            	tableXetNghiem.setItems(FXCollections.observableArrayList(xetNghiemList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
        	}
    	}
    	return tableXetNghiem;
	}

    @FXML
    void addXetNghiem(ActionEvent event) throws IOException {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ADD_XETNGHIEM_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        stage.setScene(scene);
    }

    @FXML
    void deleteXetNghiem(ActionEvent event) {
    	XetNghiem selected = tableXetNghiem.getSelectionModel().getSelectedItem();
        if (selected == null) createDialog(Alert.AlertType.WARNING,
                "Cảnh báo",
                "Vui lòng chọn một mục để tiếp tục", "");
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận xóa thông tin");
            alert.setContentText("Đồng chí muốn xóa thông tin xét nghiệm này?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    // Delete in Database
                    try {
                        int ID = selected.getIdXetNghiem();
                        int result1 = XetNghiemServices.deleteXetNghiem(ID);
                        if (result1 == 1) createDialog(Alert.AlertType.INFORMATION, "Thông báo", "Xóa thành công!", "");
                        else createDialog(Alert.AlertType.WARNING, "Thông báo", "Có lỗi, thử lại sau!", "");
                        ViewUtils viewUtils = new ViewUtils();
                        viewUtils.backToView(event, XETNGHIEM_VIEW);
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
    	FilteredList<XetNghiem> filteredData = new FilteredList<>(xetNghiemList, p -> true);
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(XetNghiem -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = searchTextField.getText().toLowerCase();
                String filterType = "";
                if(nameRadioButton.isSelected()) {
                	if(XetNghiem.getTenNguoiXetNghiem() == null) {
                		filterType = "";
                	}
                	else {
                		filterType = XetNghiem.getTenNguoiXetNghiem().toLowerCase();
                	}
                }
                else if(ketQuaRadioButton.isSelected()) {
                	filterType = XetNghiem.getKetQua().toLowerCase();
                }
                if (filterType.contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
            int soDu = filteredData.size() % ROWS_PER_PAGE;
            if (soDu != 0) pagination.setPageCount(filteredData.size() / ROWS_PER_PAGE + 1);
            else pagination.setPageCount(filteredData.size() / ROWS_PER_PAGE);
            pagination.setMaxPageIndicatorCount(5);
            pagination.setPageFactory(pageIndex->{
        		indexCol.setCellValueFactory((Callback<TableColumn.CellDataFeatures<XetNghiem, XetNghiem>, ObservableValue<XetNghiem>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
                indexCol.setCellFactory(new Callback<TableColumn<XetNghiem, XetNghiem>, TableCell<XetNghiem, XetNghiem>>() {
                    @Override
                    public TableCell<XetNghiem, XetNghiem> call(TableColumn<XetNghiem, XetNghiem> param) {
                        return new TableCell<XetNghiem, XetNghiem>() {
                            @Override
                            protected void updateItem(XetNghiem item, boolean empty) {
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
        		nguoiXetNghiemCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("tenNguoiXetNghiem"));
        		hinhThucCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("hinhThuc"));
        		thoiGianCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("thoiGian"));
        		ketQuaCol.setCellValueFactory(new PropertyValueFactory<XetNghiem, String>("ketQua"));
   
                int lastIndex = 0;
                int displace = filteredData.size() % ROWS_PER_PAGE;
                if (displace > 0) {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE;
                } else {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE - 1;
                }
                // Add XetNghiem to table
                if (filteredData.isEmpty()) tableXetNghiem.setItems(FXCollections.observableArrayList(filteredData));
                else {
                    if (lastIndex == pageIndex && displace > 0) {
                        tableXetNghiem.setItems(FXCollections.observableArrayList(filteredData.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
                    } else {
                        tableXetNghiem.setItems(FXCollections.observableArrayList(filteredData.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
                    }
                }
                return tableXetNghiem;
            });
        }); 
    }

}
