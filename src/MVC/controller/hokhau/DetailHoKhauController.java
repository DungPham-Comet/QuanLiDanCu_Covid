package MVC.controller.hokhau;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;
import static MVC.constans.FXMLConstans.*;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import MVC.controller.nhankhau.ChonNhanKhauController;
import MVC.model.SoHoKhau;
import MVC.model.ThanhVienCuaHo;
import MVC.services.HoKhauServices;
import MVC.services.NhanKhauServices;
import MVC.utils.ViewUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailHoKhauController {

    @FXML
    private Button addThanhVienBtn;

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<ThanhVienCuaHo, String> cccdColumn;

    @FXML
    private Button deleteThanhVienBtn;

    @FXML
    private TextField diaChiTextField;

    @FXML
    private Button doiChuHoBtn;

    @FXML
    private TableColumn<ThanhVienCuaHo, String> hoTenColumn;

    @FXML
    private Text maHoKhauLabel;

    @FXML
    private TextField maHoKhauTextField;

    @FXML
    private Text ngayTaoLabel;

    @FXML
    private TextField ngayTaoTextField;

    @FXML
    private TableColumn<ThanhVienCuaHo, String> quanHeColumn;

    @FXML
    private Text tenChuHoLabel;

    @FXML
    private TextField tenChuHoTextField;

    @FXML
    private TableView<ThanhVienCuaHo> thanhVienTable;

    @FXML
    private Text title;

    @FXML
    private Button updateThanhVienBtn;

    @FXML
    private Button update_btn;
    
    private int id;
    
    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    private ObservableList<ThanhVienCuaHo> thanhVienList = FXCollections.observableArrayList();
    
    private SoHoKhau hoKhau;
    
    public void setHoKhau(SoHoKhau hoKhau) {
    	this.hoKhau = hoKhau;
    	maHoKhauTextField.setText(""+hoKhau.getIdHoKhau());
    	ngayTaoTextField.setText(hoKhau.getNgayTao());
    	diaChiTextField.setText(hoKhau.getDiaChi());
    	tenChuHoTextField.setText(hoKhau.getTenChuHo());
		try {
			ResultSet result = HoKhauServices.getAllThanhVien(hoKhau.getIdHoKhau());
			while(result.next()) {
				thanhVienList.add(new ThanhVienCuaHo(result.getInt("IdNhanKhau"), result.getString("HoTen"), result.getString("MaCccd"), result.getString("QuanHeChuHo")));
			}
			thanhVienTable.setItems(FXCollections.observableArrayList(thanhVienList));
			hoTenColumn.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("hoTen"));
			cccdColumn.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("cccd"));
			quanHeColumn.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("quanHeChuHo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void addthanhvien(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ADD_THANHVIEN_VIEW));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        AddThanhVienController controller = loader.getController();
        controller.setHoKhau(hoKhau);
        stage.setScene(scene);
    }

    @FXML
    void deletethanhvien(ActionEvent event) {
    	ThanhVienCuaHo selected = thanhVienTable.getSelectionModel().getSelectedItem();
        if (selected == null) createDialog(Alert.AlertType.WARNING,
                "Cảnh báo",
                "Vui lòng chọn nhân khẩu để tiếp tục", "");
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận xóa nhân khẩu");
            alert.setContentText("Đồng chí muốn xóa nhân khẩu này?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    // Delete in Database
                    try {
                        int idNhanKhau = selected.getIdNhanKhau();
                        int result1 = HoKhauServices.deleteThanhVien(idNhanKhau);
                        if (result1 == 1) createDialog(Alert.AlertType.INFORMATION, "Thông báo", "Xóa thành công!", "");
                        else createDialog(Alert.AlertType.WARNING, "Thông báo", "Có lỗi, thử lại sau!", "");
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource(DETAIL_HOKHAU_VIEW));
                        Parent studentViewParent = loader.load();
                        Scene scene = new Scene(studentViewParent);
                        DetailHoKhauController controller = loader.getController();
                        controller.setHoKhau(hoKhau);
                        stage.setScene(scene);
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
    void doiChuHo(ActionEvent event) {
    	ThanhVienCuaHo selected = thanhVienTable.getSelectionModel().getSelectedItem();
    	if(selected == null) {
    		createDialog(Alert.AlertType.WARNING, "Từ từ đã đồng chí", "", "Vui lòng chọn một nhân khẩu");
    	}
    	else {
            	try {
                    Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
                    int rs = HoKhauServices.updateThanhVien(selected.getIdNhanKhau(), "chủ hộ");
                    int rs3 = HoKhauServices.updateHoKhau(hoKhau.getIdHoKhau(), selected.getIdNhanKhau());
                    if(rs == 1) {
    					createDialog(
    							Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đồng chí vất vả rồi!");
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource(DETAIL_HOKHAU_VIEW));
                        Parent studentViewParent = loader.load();
                        Scene scene = new Scene(studentViewParent);
                        DetailHoKhauController controller = loader.getController();
                        hoKhau.setTenChuHo(selected.getHoTen());
                        controller.setHoKhau(hoKhau);
                        stage.setScene(scene);
                    }
                    else {
    					createDialog(
    							Alert.AlertType.ERROR,
                                "Thất bại",
                                "", "Oops, mời đồng chí nhập lại thông tin!");
                    }
                    conn.close();
                    
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
    	}   	
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
    	viewUtils.backToView(event, HOKHAU_VIEW);
    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void updatethanhvien(ActionEvent event) {
    	ThanhVienCuaHo selected = thanhVienTable.getSelectionModel().getSelectedItem();
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
                    int rs = HoKhauServices.updateThanhVien(selected.getIdNhanKhau(), quanhe);
                    if(rs == 1) {
    					createDialog(
    							Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đồng chí vất vả rồi!");
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource(DETAIL_HOKHAU_VIEW));
                        Parent studentViewParent = loader.load();
                        Scene scene = new Scene(studentViewParent);
                        DetailHoKhauController controller = loader.getController();
                        controller.setHoKhau(hoKhau);
                        stage.setScene(scene);
                    }
                    else {
    					createDialog(
    							Alert.AlertType.ERROR,
                                "Thất bại",
                                "", "Oops, mời đồng chí nhập lại thông tin!");
                    }
                    conn.close();
                    
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
            });
    	}
    }

    @FXML
    void tachHoKhau(ActionEvent event) {
    	ThanhVienCuaHo selected = thanhVienTable.getSelectionModel().getSelectedItem();
    	if (selected == null) createDialog(Alert.AlertType.WARNING,
                "Cảnh báo",
                "Vui lòng chọn nhân khẩu để tiếp tục", "");
    	else if(selected.getQuanHeChuHo().equals("chủ hộ")) {
    		createDialog(Alert.AlertType.WARNING,
                    "Cảnh báo",
                    "Vui lòng chọn nhân khẩu khác hoặc đổi chủ hộ để tiếp tục", "");
    	}
    	else {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Nhập thông tin địa chỉ mới");
            dialog.setHeaderText("Địa chỉ mới:");
            dialog.setContentText("Địa chỉ mới:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(diachi -> {
            	try {
                    Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
                    int delrs = HoKhauServices.deleteThanhVien(selected.getIdNhanKhau());
                    int rs = HoKhauServices.addHoKhau(conn, LocalDate.now().toString(), diachi, selected.getIdNhanKhau());
                    int addrs = HoKhauServices.addThanhVienHo(conn, selected.getIdNhanKhau(), HoKhauServices.getHoKhauByChuHo(conn, selected.getIdNhanKhau()), "chủ hộ");
                    if(rs == 1) {
    					createDialog( 
    							Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đồng chí vất vả rồi!");
    					SoHoKhau hokhaumoi = new SoHoKhau(HoKhauServices.getHoKhauByChuHo(conn, selected.getIdNhanKhau()), LocalDate.now().toString(), diachi, NhanKhauServices.getNhanKhauById(conn, selected.getIdNhanKhau()), 1);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource(DETAIL_HOKHAU_VIEW));
                        Parent studentViewParent = loader.load(); 
                        Scene scene = new Scene(studentViewParent);
                        DetailHoKhauController controller = loader.getController();
                        controller.setHoKhau(hokhaumoi);
                        stage.setScene(scene);
                    }
                    else {
    					createDialog(
    							Alert.AlertType.ERROR,
                                "Thất bại",
                                "", "Oops, mời đồng chí nhập lại thông tin!");
                    }
                    conn.close();
                    
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
            });    		
    	}
    }
}
