package MVC.controller.ttdichuyen;

import static MVC.constans.DBConstans.ROWS_PER_PAGE;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.convertDate;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.model.ThongTinDiChuyen;
import MVC.model.LichTrinh;
import MVC.model.ThongTinDiChuyen;
import MVC.services.DiChuyenServices;
import MVC.services.DiChuyenServices;
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
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TTDiChuyenController{

	@FXML
    private Button addTTDiChuyenButton;

    @FXML
    private Button deleteTTDiChuyenButton;

    @FXML
    private TableColumn<ThongTinDiChuyen, String> diaDiemCol;

    @FXML
    private TableColumn indexCol;

    @FXML
    private TextField lichTrinhTextField;

    @FXML
    private TextField nguoiKhaiTextField;

    @FXML
    private Pagination pagination;
    
    @FXML
    private TableView<ThongTinDiChuyen> diChuyenTable;

    @FXML
    private TableColumn<ThongTinDiChuyen, String> phuongTienCol;

    @FXML
    private Button returnButton;

    @FXML
    private TableColumn<ThongTinDiChuyen, String> thoiGianCol;
    
    @FXML
    private URL location;
	
    @FXML
    private ResourceBundle resources;
    
	private ObservableList<ThongTinDiChuyen> diChuyenList = FXCollections.observableArrayList();
	
    private final ViewUtils viewUtils = new ViewUtils();
    
    private LichTrinh lichTrinh;
    
    public void setLichTrinh(LichTrinh lichTrinh) {
    	this.lichTrinh = lichTrinh;
    	nguoiKhaiTextField.setText(lichTrinh.getTenNguoiKhai());
    	lichTrinhTextField.setText(lichTrinh.getTenLichTrinh());
        try {
        	System.out.println(lichTrinh.getIdLichTrinh());
            ResultSet result = DiChuyenServices.getAllDiChuyen(lichTrinh.getIdLichTrinh());
            while (result.next()) {
            	diChuyenList.add(new ThongTinDiChuyen(result.getInt("IdThongTin"), result.getString("PhuongTien"), result.getString("ThoiGian"), result.getString("DiaDiem"),result.getInt("IdLichTrinh") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int soDu = diChuyenList.size() % ROWS_PER_PAGE;
        
        if (soDu != 0) pagination.setPageCount(diChuyenList.size() / ROWS_PER_PAGE + 1);
        else pagination.setPageCount(diChuyenList.size() / ROWS_PER_PAGE);
        pagination.setMaxPageIndicatorCount(5);
        pagination.setPageFactory(this::createTableView);

        diChuyenTable.setRowFactory(tv -> {
            TableRow<ThongTinDiChuyen> row = new TableRow<>();
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
    	
//    	ThongTinDiChuyen selected = tableThongTinDiChuyen.getSelectionModel().getSelectedItem();
//    	if(selected == null) {
//    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một mục");
//    	}
//    	else {
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource(DETAIL_ThongTinDiChuyen_VIEW));
//            Parent studentViewParent = loader.load();
//            Scene scene = new Scene(studentViewParent);
//            DetailThongTinDiChuyenController controller = loader.getController();
//            controller.setThongTinDiChuyen(selected);
//            controller.setIdThongTinDiChuyen(selected.getIdThongTinDiChuyen());
//            //System.out.println("ID: " + selected.getIdThongTinDiChuyen());
//            stage.setScene(scene);
//    	}
		
	}

	@SuppressWarnings("unchecked")
	public Node createTableView(Integer pageIndex) {
		indexCol.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ThongTinDiChuyen, ThongTinDiChuyen>, ObservableValue<ThongTinDiChuyen>>) p -> new ReadOnlyObjectWrapper(p.getValue()));
        indexCol.setCellFactory(new Callback<TableColumn<ThongTinDiChuyen, ThongTinDiChuyen>, TableCell<ThongTinDiChuyen, ThongTinDiChuyen>>() {
            @Override
            public TableCell<ThongTinDiChuyen, ThongTinDiChuyen> call(TableColumn<ThongTinDiChuyen, ThongTinDiChuyen> param) {
                return new TableCell<ThongTinDiChuyen, ThongTinDiChuyen>() {
                    @Override
                    protected void updateItem(ThongTinDiChuyen item, boolean empty) {
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
        diaDiemCol.setCellValueFactory(new PropertyValueFactory<ThongTinDiChuyen, String>("diaDiem"));
        thoiGianCol.setCellValueFactory(new PropertyValueFactory<ThongTinDiChuyen, String>("thoiGian"));
        phuongTienCol.setCellValueFactory(new PropertyValueFactory<ThongTinDiChuyen, String>("phuongTien"));
        
        int lastIndex = 0;
        int displace = diChuyenList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = diChuyenList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = diChuyenList.size() / ROWS_PER_PAGE - 1;
        }
        if (diChuyenList.isEmpty()) diChuyenTable.setItems(FXCollections.observableArrayList(diChuyenList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
            	diChuyenTable.setItems(FXCollections.observableArrayList(diChuyenList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                diChuyenTable.setItems(FXCollections.observableArrayList(diChuyenList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
        return diChuyenTable;
	}

    @FXML
    void addTTDiChuyen(ActionEvent event) {

    }

    @FXML
    void deleteTTDiChuyen(ActionEvent event) {

    }

    @FXML
    void returnToLichTrinh(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.backToView(event, LICHTRINH_VIEW);
    }

}
