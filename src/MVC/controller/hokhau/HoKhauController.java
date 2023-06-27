package MVC.controller.hokhau;

import static MVC.constans.DBConstans.ROWS_PER_PAGE;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.controller.nhankhau.DetailNhanKhauController;
import MVC.model.NhanKhau;
import MVC.model.SoHoKhau;
import MVC.services.HoKhauServices;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class HoKhauController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<SoHoKhau, String> diaChiColumn;

    @FXML
    private TableColumn indexColumn;

    @FXML
    private TableColumn<SoHoKhau, String> ngayTaoColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<SoHoKhau, Integer> soLuongColumn;

    @FXML
    private TableView<SoHoKhau> tableView;

    @FXML
    private TableColumn<SoHoKhau, String> tenChuHoColumn;
    
    @FXML
    private ToggleGroup group;
    
    @FXML
    private RadioButton diaChiFilterBtn;
    
    @FXML
    private RadioButton tenChuHoFilterBtn;
    
    private ObservableList<SoHoKhau> hoKhauList = FXCollections.observableArrayList();
    
    private final ViewUtils viewUtils = new ViewUtils();

    @FXML
    void add(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, ADD_HOKHAU_VIEW);
    }

    @FXML
    void delete(ActionEvent event) {
    	SoHoKhau selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) createDialog(Alert.AlertType.WARNING,
                "Cảnh báo",
                "Vui lòng chọn nhân khẩu để tiếp tục", "");
        else {
            	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            	alert.setTitle("Xác nhận xóa hộ khẩu");
            	alert.setContentText("Đồng chí muốn xóa hộ khẩu này?");
            	ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            	ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            	alert.getButtonTypes().setAll(okButton, noButton);
            	alert.showAndWait().ifPresent(type -> {
            		if(type == okButton) {
            			try {
            				int idHoKhau = selected.getIdHoKhau();
            				int result = HoKhauServices.deleteHoKhau(idHoKhau);
                            if (result == 1) createDialog(Alert.AlertType.INFORMATION, "Thông báo", "Xóa thành công!", "");
                            else createDialog(Alert.AlertType.WARNING, "Thông báo", "Có lỗi, thử lại sau!", "");
                            ViewUtils viewUtils = new ViewUtils();
                            try {
								viewUtils.backToView(event, HOKHAU_VIEW);
							} catch (IOException e) {
								throw new RuntimeException(e);
							}
            			}
            			catch (SQLException e) {
							e.printStackTrace();
						}
            		}
            	});
            }
        }

    @SuppressWarnings("unchecked")
	@FXML
    void search(MouseEvent event) {
    	FilteredList<SoHoKhau> filteredData = new FilteredList<>(hoKhauList, p -> true);
    	searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = searchTextField.getText().toLowerCase();
                String filterType = "";
                if(diaChiFilterBtn.isSelected()) {
                		filterType = person.getDiaChi().toLowerCase();
                }
                else if(tenChuHoFilterBtn.isSelected()) {
                	filterType = person.getTenChuHo().toLowerCase();
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
            pagination.setPageFactory(pageIndex ->{
        		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<SoHoKhau, SoHoKhau>, ObservableValue<SoHoKhau>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
                indexColumn.setCellFactory(new Callback<TableColumn<SoHoKhau, SoHoKhau>, TableCell<SoHoKhau, SoHoKhau>>() {
                    @Override
                    public TableCell<SoHoKhau, SoHoKhau> call(TableColumn<SoHoKhau, SoHoKhau> param) {
                        return new TableCell<SoHoKhau, SoHoKhau>() {
                            @Override
                            protected void updateItem(SoHoKhau item, boolean empty) {
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
                ngayTaoColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, String>("ngayTao"));
                diaChiColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, String>("diaChi"));
                tenChuHoColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, String>("tenChuHo"));
                soLuongColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, Integer>("soThanhVen"));
                int lastIndex = 0;
                int displace = filteredData.size() % ROWS_PER_PAGE;
                if (displace > 0) {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE;
                } else {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE - 1;
                }
                if (filteredData.isEmpty()) tableView.setItems(FXCollections.observableArrayList(filteredData));
                else {
                    if (lastIndex == pageIndex && displace > 0) {
                        tableView.setItems(FXCollections.observableArrayList(filteredData.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
                    } else {
                        tableView.setItems(FXCollections.observableArrayList(filteredData.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
                    }
                }
        		return tableView;            	
            });
    	});
    }

    void detail(MouseEvent event) throws IOException {
    	SoHoKhau selected = tableView.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một nhân khẩu");
    	}
    	else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(DETAIL_HOKHAU_VIEW));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            DetailHoKhauController controller = loader.getController();
            controller.setId(selected.getIdHoKhau());
            controller.setHoKhau(selected);
            stage.setScene(scene);
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ResultSet result = HoKhauServices.getAllHoKhau();
			while(result.next()) {
				hoKhauList.add(new SoHoKhau(result.getInt("IdHoKhau"), result.getString("NgayTao"), result.getString("DiaChi"), result.getString("HoTen"), result.getInt("SoThanhVien")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        int soDu = hoKhauList.size() % ROWS_PER_PAGE;
        if (soDu != 0) pagination.setPageCount(hoKhauList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(hoKhauList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);
        
        tableView.setRowFactory(tv -> {
            TableRow<SoHoKhau> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    try {
                        detail(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            return row ;
        });
	}
	@SuppressWarnings("unchecked")
	public Node createTableView(int pageIndex) {
		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<SoHoKhau, SoHoKhau>, ObservableValue<SoHoKhau>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
        indexColumn.setCellFactory(new Callback<TableColumn<SoHoKhau, SoHoKhau>, TableCell<SoHoKhau, SoHoKhau>>() {
            @Override
            public TableCell<SoHoKhau, SoHoKhau> call(TableColumn<SoHoKhau, SoHoKhau> param) {
                return new TableCell<SoHoKhau, SoHoKhau>() {
                    @Override
                    protected void updateItem(SoHoKhau item, boolean empty) {
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
        ngayTaoColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, String>("ngayTao"));
        diaChiColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, String>("diaChi"));
        tenChuHoColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, String>("tenChuHo"));
        soLuongColumn.setCellValueFactory(new PropertyValueFactory<SoHoKhau, Integer>("soThanhVen"));
        int lastIndex = 0;
        int displace = hoKhauList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = hoKhauList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = hoKhauList.size() / ROWS_PER_PAGE - 1;
        }
        if (hoKhauList.isEmpty()) tableView.setItems(FXCollections.observableArrayList(hoKhauList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
                tableView.setItems(FXCollections.observableArrayList(hoKhauList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                tableView.setItems(FXCollections.observableArrayList(hoKhauList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
		return tableView;
	}

}
