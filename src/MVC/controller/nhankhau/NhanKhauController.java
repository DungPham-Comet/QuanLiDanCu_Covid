package MVC.controller.nhankhau;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MVC.model.NhanKhau;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.sql.*;

import MVC.services.NhanKhauServices;
import static MVC.utils.Utils.*;
import MVC.utils.ViewUtils;
import static MVC.constans.DBConstans.*;
import static MVC.constans.FXMLConstans.*;

public class NhanKhauController implements Initializable {
	
    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<NhanKhau, String> cccdColumn;

    @FXML
    private TableColumn<NhanKhau, String> danTocColumn;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private ToggleGroup filterCategory1;

    @FXML
    private ToggleGroup filterCategory11;

    @FXML
    private TableColumn<NhanKhau, String> gioiTinhColumn;

    @FXML
    private TableColumn<NhanKhau, String> hoVaTenColumn;

    @FXML
    private TableColumn  indexColumn;

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
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private RadioButton radioBtnFilterTitle1;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<NhanKhau> tableView;

    @FXML
    private TableColumn<NhanKhau, String> tonGiaoColumn;

    private ObservableList<NhanKhau> nhanKhauList = FXCollections.observableArrayList();
    
    private final ViewUtils viewUtils = new ViewUtils();
    
    @FXML
    void add(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, ADD_NHAN_KHAU_VIEW);
    }

    void detail(ActionEvent event) throws IOException {
    	NhanKhau selected = tableView.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một nhân khẩu");
    	}
    	else {
    		viewUtils.changeScene(event, DETAIL_NHANKHAU_VIEW);
    	}
    }
    
    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ResultSet result = NhanKhauServices.getAllNhanKhau();
			while (result.next()) {
				nhanKhauList.add(new NhanKhau(result.getInt("IdNhanKhau"), result.getString("MaCccd"), result.getString("HoTen"), convertDate(result.getString("DOB")), result.getString("GioiTinh"), result.getString("DanToc"), result.getString("QuocTich"), result.getString("TonGiao"), result.getString("NguyenQuan"), result.getString("ThuongTru"), result.getString("NgheNghiep")));
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
        // Add nhankhau to table
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

}
