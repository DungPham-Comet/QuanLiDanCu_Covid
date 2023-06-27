package MVC.controller.hokhau;

import static MVC.constans.DBConstans.ROWS_PER_PAGE;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.model.NhanKhau;
import MVC.model.SoHoKhau;
import MVC.services.HoKhauServices;
import MVC.utils.ViewUtils;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class ChonHoKhauController implements Initializable {

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

    private ObservableList<SoHoKhau> hoKhauList = FXCollections.observableArrayList();
    
    private final ViewUtils viewUtils = new ViewUtils();
    
    private static SoHoKhau selectedHoKhau = new SoHoKhau();
    
    public static SoHoKhau getSelectedHoKhau() {
    	return selectedHoKhau;
    }
    
    public static void deleteSelectedHoKhau() {
    	selectedHoKhau = new SoHoKhau();
    }
    
    private String previousPage;
    
    public void setPreviousPage(String pre) {
    	this.previousPage = pre;
    }
    
    @FXML
    void chon(ActionEvent event) throws IOException {
    	SoHoKhau selected = tableView.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một nhân khẩu");
    	}
    	else {
    		selectedHoKhau = selected;
    		System.out.println(selectedHoKhau.getTenChuHo());
    		viewUtils.changeScene(event, previousPage);
    	}
    }

    @FXML
    void goBack(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

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
