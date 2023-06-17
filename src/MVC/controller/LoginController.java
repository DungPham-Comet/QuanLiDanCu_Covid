package MVC.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.prefs.Preferences;
import static MVC.constans.FXMLConstans.*;
import static MVC.constans.DBConstans.*;
import MVC.utils.ViewUtils;
import static MVC.utils.Utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonSignup;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private TextField inputUsername;

    @FXML
    void handleLogin(ActionEvent event) {
        String SELECT_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";
        String Username = inputUsername.getText();
        String Password = inputPassword.getText();
        if (Username.trim().equals("") || Password.trim().equals("")) {
            createDialog(
                    Alert.AlertType.WARNING,
                    "Cảnh báo!",
                    "Khoan nào cán bộ!",
                    "Vui lòng nhập đầy đủ username và password!"
            );
        }   else {
            try {
                //Khai bao ket noi sql
                Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
                preparedStatement.setString(1, Username);
                preparedStatement.setString(2, Password);
                ResultSet result = preparedStatement.executeQuery();
                if (result.next()) {
                    Preferences userPreferences = Preferences.userRoot();
                    userPreferences.put("role", result.getString(4));
                    userPreferences.put("username", result.getString(2));
                    ViewUtils viewUtils = new ViewUtils();
                    viewUtils.changeScene(event, HOME_VIEW);
                }   else {
                    createDialog(
                            Alert.AlertType.ERROR,
                            "Cảnh báo!",
                            "Khoan nào cán bộ!",
                            "Sai username hoặc password!"
                    );
                }
            }   catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void signUpbtn(ActionEvent event) {

    }
}
