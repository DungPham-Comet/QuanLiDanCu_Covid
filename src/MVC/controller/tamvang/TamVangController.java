package MVC.controller.tamvang;

import static MVC.constans.DBConstans.*;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.model.TamTru;
import MVC.model.TamVang;
import MVC.services.TamVangServices;
import MVC.utils.ViewUtils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class TamVangController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<TamVang, String> diaDiemColumn;

    @FXML
    private TableColumn indexColumn;

    @FXML
    private TableColumn<TamVang, String> ngayBatDauColumn;

    @FXML
    private TableColumn<TamVang, String> ngayKetThucColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<TamVang> tableView;

    @FXML
    private TableColumn<TamVang, String> tenTamVangColumn;
    
    private ObservableList<TamVang> tamVangList = FXCollections.observableArrayList();

    @FXML
    void add(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	viewUtils.changeScene(event, ADD_TAMVANG_VIEW);
    }

    @FXML
    void delete(ActionEvent event) {
    	TamVang selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) createDialog(Alert.AlertType.WARNING,
                "Cảnh báo",
                "Vui lòng chọn để tiếp tục", "");
        else {
            	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            	alert.setTitle("Xác nhận xóa tạm vắng");
            	alert.setContentText("Đồng chí muốn xóa tạm vắng này?");
            	ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            	ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            	alert.getButtonTypes().setAll(okButton, noButton);
            	alert.showAndWait().ifPresent(type -> {
            		if(type == okButton) {
            			try {
            				int idTamVang = selected.getIdTamVang();
            				int result = TamVangServices.deleteTamVang(idTamVang);
                            if (result == 1) createDialog(Alert.AlertType.INFORMATION, "Thông báo", "Xóa thành công!", "");
                            else createDialog(Alert.AlertType.WARNING, "Thông báo", "Có lỗi, thử lại sau!", "");
                            ViewUtils viewUtils = new ViewUtils();
                            try {
								viewUtils.backToView(event, TAMTRU_VIEW);
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
    	FilteredList<TamVang> filteredData = new FilteredList<>(tamVangList, p -> true);
    	searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = searchTextField.getText().toLowerCase();
                if (person.getTenNguoiTamVang().toLowerCase().contains(lowerCaseFilter)) {
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
        		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<TamVang, TamVang>, ObservableValue<TamVang>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
                indexColumn.setCellFactory(new Callback<TableColumn<TamVang, TamVang>, TableCell<TamVang, TamVang>>() {
                    @Override
                    public TableCell<TamVang, TamVang> call(TableColumn<TamVang, TamVang> param) {
                        return new TableCell<TamVang, TamVang>() {
                            @Override
                            protected void updateItem(TamVang item, boolean empty) {
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
                tenTamVangColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("tenNguoiTamVang"));
                diaDiemColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("diaDiem"));
                ngayBatDauColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("ngayTao"));
                ngayKetThucColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("ngayKetThuc"));
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

    void detail (MouseEvent event) throws IOException {
    	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ResultSet result = TamVangServices.getAllTamVang();
			while(result.next()) {
				tamVangList.add(new TamVang(result.getInt("IdTamVang"), result.getString("HoTen"), result.getString("NgayTao"), result.getString("NgayKetThuc"), result.getString("DiaDiem")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        int soDu = tamVangList.size() % ROWS_PER_PAGE;
        if (soDu != 0) pagination.setPageCount(tamVangList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(tamVangList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);
        
        tableView.setRowFactory(tv -> {
            TableRow<TamVang> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    // Perform actions with rowData
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
		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<TamVang, TamVang>, ObservableValue<TamVang>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
        indexColumn.setCellFactory(new Callback<TableColumn<TamVang, TamVang>, TableCell<TamVang, TamVang>>() {
            @Override
            public TableCell<TamVang, TamVang> call(TableColumn<TamVang, TamVang> param) {
                return new TableCell<TamVang, TamVang>() {
                    @Override
                    protected void updateItem(TamVang item, boolean empty) {
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
        tenTamVangColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("tenNguoiTamVang"));
        diaDiemColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("diaDiem"));
        ngayBatDauColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("ngayTao"));
        ngayKetThucColumn.setCellValueFactory(new PropertyValueFactory<TamVang, String>("ngayKetThuc"));
        int lastIndex = 0;
        int displace = tamVangList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = tamVangList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = tamVangList.size() / ROWS_PER_PAGE - 1;
        }
        if (tamVangList.isEmpty()) tableView.setItems(FXCollections.observableArrayList(tamVangList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
                tableView.setItems(FXCollections.observableArrayList(tamVangList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                tableView.setItems(FXCollections.observableArrayList(tamVangList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
		return tableView;
	}

}
