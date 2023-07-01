package MVC.controller;

import static MVC.constans.FXMLConstans.*;
import static MVC.constans.DBConstans.*;
import static MVC.utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MVC.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SignupController implements Initializable{

    @FXML
    private Button backButton;

    @FXML
    private RadioButton isAdmin;

    @FXML
    private RadioButton isOfficer;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private TextField signUpUsername;
    
    private final ToggleGroup toggleRole = new ToggleGroup();

    @FXML
    void backToLogin(ActionEvent event) throws IOException {
    	ViewUtils a = new ViewUtils();
    	a.changeScene(event, LOGIN_VIEW);
    	}

    @FXML
    void handleSignUp(ActionEvent event) {
    	String inputUsername = signUpUsername.getText();
        String inputPassword = signUpPassword.getText();
        int role = 1;

        if (inputUsername.trim().equals("") || inputPassword.trim().equals("")) {
            createDialog(
                    Alert.AlertType.WARNING,
                    "Khoan nào cán bộ",
                    "", "Vui lòng nhập đủ username và password!"
            );

        }   else {
            if (!isOfficer.isSelected() && !isAdmin.isSelected()) {
                createDialog(
                        Alert.AlertType.WARNING,
                        "Khoan nào cán bộ",
                        "", "Vui lòng chọn role cho username!"
                );
            }   else {
                if (isOfficer.isSelected()) role = 0;
                if (isAdmin.isSelected()) role = 1;
                String CREATE_QUERY = "INSERT INTO user (username, password, role) VALUES (?,?,?)";
                try {
                    Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
                    PreparedStatement preparedStatement = conn.prepareStatement(CREATE_QUERY);
                    preparedStatement.setString(1, inputUsername);
                    preparedStatement.setString(2, inputPassword);
                    preparedStatement.setInt(3, role);
                    int result = preparedStatement.executeUpdate();
                    if (result == 1) {
                        signUpPassword.clear();
                        signUpUsername.clear();
                        isAdmin.setSelected(false);
                        isOfficer.setSelected(false);
                        createDialog(
                                Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Đăng ký người dùng mới thành công!"
                        );
                    }   else {
                        createDialog(
                                Alert.AlertType.ERROR,
                                "Thất bại",
                                "", "Đăng ký người dùng mới thất bại!"
                        );
                    }
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isAdmin.setToggleGroup(toggleRole);
        isOfficer.setToggleGroup(toggleRole);
    }

}
