package MVC.services;

import static MVC.constans.DBConstans.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanKhauServices {
    public static ResultSet getAllNhanKhau() throws SQLException {
        // Connecting Database
        String SELECT_QUERY = "SELECT nhankhau.*\n" +
                "FROM nhankhau\n";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }
    public static int deleteNhanKhau(int ID) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY =
                "DELETE FROM nhankhau " +
                        "WHERE IdNhanKhau =?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, ID);
        return preparedStatement.executeUpdate();
    }
    public static int deleteNhanKhauViaCCCD(int ID) throws SQLException {
        String DELETE_QUERY = "DELETE FROM cccd " +
                "WHERE idNhankhau =?";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, ID);
        return preparedStatement.executeUpdate();
    }
}
