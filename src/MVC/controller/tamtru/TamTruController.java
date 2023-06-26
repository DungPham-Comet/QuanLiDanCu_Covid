package MVC.controller.tamtru;

import static MVC.constans.DBConstans.*;
import static MVC.constans.FXMLConstans.*;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.model.TamTru;
import MVC.services.TamTruServices;
import MVC.utils.ViewUtils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

public class TamTruController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn indexColumn;

    @FXML
    private TableColumn<TamTru, String> ngayBatDauColumn;

    @FXML
    private TableColumn<TamTru, String> ngayKetThucColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<TamTru> tableView;

    @FXML
    private TableColumn<TamTru, String> tenChuHoColumn;

    @FXML
    private TableColumn<TamTru, String> tenTamTruColumn;
    
    private ObservableList<TamTru> tamTruList = FXCollections.observableArrayList();

    @FXML
    void add(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	viewUtils.changeScene(event, ADD_TAMTRU_VIEW);
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }
    
    void detail(MouseEvent event) throws IOException {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ResultSet result = TamTruServices.getAllTamTru();
			while(result.next()) {
				tamTruList.add(new TamTru(result.getInt("IdTamTru"), result.getString("TenTamTru"), result.getString("TenChuHo"), result.getString("NgayTao"), result.getString("NgayKetThuc")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        int soDu = tamTruList.size() % ROWS_PER_PAGE;
        if (soDu != 0) pagination.setPageCount(tamTruList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(tamTruList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);
        
        tableView.setRowFactory(tv -> {
            TableRow<TamTru> row = new TableRow<>();
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
		indexColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<TamTru, TamTru>, ObservableValue<TamTru>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
        indexColumn.setCellFactory(new Callback<TableColumn<TamTru, TamTru>, TableCell<TamTru, TamTru>>() {
            @Override
            public TableCell<TamTru, TamTru> call(TableColumn<TamTru, TamTru> param) {
                return new TableCell<TamTru, TamTru>() {
                    @Override
                    protected void updateItem(TamTru item, boolean empty) {
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
        tenTamTruColumn.setCellValueFactory(new PropertyValueFactory<TamTru, String>("tenNguoiTamTru"));
        tenChuHoColumn.setCellValueFactory(new PropertyValueFactory<TamTru, String>("tenChuHo"));
        ngayBatDauColumn.setCellValueFactory(new PropertyValueFactory<TamTru, String>("ngayTao"));
        ngayKetThucColumn.setCellValueFactory(new PropertyValueFactory<TamTru, String>("ngayKetThuc"));
        int lastIndex = 0;
        int displace = tamTruList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = tamTruList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = tamTruList.size() / ROWS_PER_PAGE - 1;
        }
        if (tamTruList.isEmpty()) tableView.setItems(FXCollections.observableArrayList(tamTruList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
                tableView.setItems(FXCollections.observableArrayList(tamTruList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                tableView.setItems(FXCollections.observableArrayList(tamTruList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
		return tableView;
	}

}
