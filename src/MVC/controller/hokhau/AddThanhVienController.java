package MVC.controller.hokhau;

import static MVC.constans.DBConstans.*;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.convertDate;
import static MVC.utils.Utils.createDialog;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import MVC.model.NhanKhau;
import MVC.model.SoHoKhau;
import MVC.services.HoKhauServices;
import MVC.services.NhanKhauServices;
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
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AddThanhVienController implements Initializable {
    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<NhanKhau, String> cccdColumn;

    @FXML
    private TableColumn<NhanKhau, String> danTocColumn;

    @FXML
    private TableColumn<NhanKhau, String> gioiTinhColumn;

    @FXML
    private TableColumn<NhanKhau, String> hoVaTenColumn;

    @FXML
    private TableColumn indexColumn;

    @FXML
    private TableColumn<NhanKhau, String> ngaySinhColumn;

    @FXML
    private TableColumn<NhanKhau, String> ngheNghiepColumn;

    @FXML
    private TableColumn<NhanKhau, String> nguyenQuanColumn;

    @FXML
    private TableColumn<NhanKhau, String> noiThuongTruColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TableColumn<NhanKhau, String> quocTichColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<NhanKhau> tableView;

    @FXML
    private TableColumn<NhanKhau, String> tonGiaoColumn;
    
    private ObservableList<NhanKhau> nhanKhauList = FXCollections.observableArrayList();
    
    private SoHoKhau hoKhau;
    
    public SoHoKhau getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(SoHoKhau hoKhau) {
		this.hoKhau = hoKhau;
	}

	@FXML
    void chon(ActionEvent event) throws IOException {
    	NhanKhau selected = tableView.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một nhân khẩu");
    	}
    	else {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Nhập thông tin Quan hệ với chủ hộ");
            dialog.setHeaderText("Quan hệ với chủ hộ:");
            dialog.setContentText("Quan hệ với chủ hộ:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(quanhe -> {
            	try {
                    Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
                    int rs = HoKhauServices.addThanhVienHo(conn, selected.getIdNhanKhau(), hoKhau.getIdHoKhau(), quanhe);
                    if(rs == 1) {
    					createDialog(
    							Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đồng chí vất vả rồi!");
                    }
                    else {
    					createDialog(
    							Alert.AlertType.ERROR,
                                "Thất bại",
                                "", "Oops, mời đồng chí nhập lại thông tin!");
                    }
                    conn.close();
                    
				} catch (SQLException e) {
					e.printStackTrace();
				}
            });
    	}
    }

    @SuppressWarnings("unchecked")
	@FXML
    public void search() {
    	FilteredList<NhanKhau> filteredData = new FilteredList<>(nhanKhauList, p -> true);
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = searchTextField.getText().toLowerCase();
                if (person.getHoTen().toLowerCase().contains(lowerCaseFilter)) {
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
        		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<NhanKhau, NhanKhau>, ObservableValue<NhanKhau>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
                indexColumn.setCellFactory(new Callback<TableColumn<NhanKhau, NhanKhau>, TableCell<NhanKhau, NhanKhau>>() {
                    @Override
                    public TableCell<NhanKhau, NhanKhau> call(TableColumn<NhanKhau, NhanKhau> param) {
                        return new TableCell<NhanKhau, NhanKhau>() {
                            @Override
                            protected void updateItem(NhanKhau item, boolean empty) {
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
                hoVaTenColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("hoTen"));
                ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngaySinh"));
                gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("gioiTinh"));
                danTocColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("danToc"));
                quocTichColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("quocTich"));
                tonGiaoColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("tonGiao"));
                nguyenQuanColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("nguyenQuan"));
                noiThuongTruColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("thuongTru"));
                ngheNghiepColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngheNghiep"));
                cccdColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("maCccd"));
                int lastIndex = 0;
                int displace = filteredData.size() % ROWS_PER_PAGE;
                if (displace > 0) {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE;
                } else {
                    lastIndex = filteredData.size() / ROWS_PER_PAGE - 1;
                }
                // Add nhankhau to table
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ResultSet result = NhanKhauServices.getAllNhanKhau();
			while (result.next()) {
				String gioitinhString;
				if(result.getBoolean("GioiTinh")) {
					gioitinhString = "Nam";
				}
				else {
					gioitinhString = "Nữ";
				}
				nhanKhauList.add(new NhanKhau(result.getInt("IdNhanKhau"), result.getString("MaCccd"), result.getString("HoTen"), convertDate(result.getString("DOB")), gioitinhString, result.getString("DanToc"), result.getString("QuocTich"), result.getString("TonGiao"), result.getString("NguyenQuan"), result.getString("ThuongTru"), result.getString("NgheNghiep")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        int soDu = nhanKhauList.size() % ROWS_PER_PAGE;
        if (soDu != 0) pagination.setPageCount(nhanKhauList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(nhanKhauList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);
	}
	@SuppressWarnings("unchecked")
	public Node createTableView(int pageIndex) {
		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<NhanKhau, NhanKhau>, ObservableValue<NhanKhau>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
        indexColumn.setCellFactory(new Callback<TableColumn<NhanKhau, NhanKhau>, TableCell<NhanKhau, NhanKhau>>() {
            @Override
            public TableCell<NhanKhau, NhanKhau> call(TableColumn<NhanKhau, NhanKhau> param) {
                return new TableCell<NhanKhau, NhanKhau>() {
                    @Override
                    protected void updateItem(NhanKhau item, boolean empty) {
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
        hoVaTenColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("hoTen"));
        ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngaySinh"));
        gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("gioiTinh"));
        danTocColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("danToc"));
        quocTichColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("quocTich"));
        tonGiaoColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("tonGiao"));
        nguyenQuanColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("nguyenQuan"));
        noiThuongTruColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("thuongTru"));
        ngheNghiepColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngheNghiep"));
        cccdColumn.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("maCccd"));
        int lastIndex = 0;
        int displace = nhanKhauList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = nhanKhauList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = nhanKhauList.size() / ROWS_PER_PAGE - 1;
        }
        if (nhanKhauList.isEmpty()) tableView.setItems(FXCollections.observableArrayList(nhanKhauList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
                tableView.setItems(FXCollections.observableArrayList(nhanKhauList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                tableView.setItems(FXCollections.observableArrayList(nhanKhauList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
		return tableView;
	}
	
    @FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(DETAIL_HOKHAU_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        DetailHoKhauController controller = loader.getController();
        controller.setHoKhau(hoKhau);
        stage.setScene(scene);   	
    }
}