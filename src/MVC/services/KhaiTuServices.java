package MVC.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhaiTuServices {

    public static ResultSet getAllFacility(Connection conn) throws SQLException {
        String SELECT_QUERY = "SELECT * FROM cnpm2023.khaitu";
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }

    public static String getTenNguoiChet(Connection conn, int idNguoiChet) throws SQLException {
        String tenNguoiChet = null;
        String SELECT_QUERY = "SELECT HoTen FROM cnpm2023.nhankhau WHERE IdNhanKhau = ? ";
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        preparedStatement.setInt(1, idNguoiChet);
        ResultSet rs = preparedStatement.executeQuery();
        
        if (rs.next()) {
            tenNguoiChet = rs.getString("HoTen");
        }
        
        return tenNguoiChet;
    }

    public static String getTenNguoiKhai(Connection conn, int idNguoiKhai) throws SQLException {
        String tenNguoiKhai = null;
        String SELECT_QUERY = "SELECT HoTen FROM cnpm2023.nhankhau WHERE IdNhanKhau = ? ";
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        preparedStatement.setInt(1, idNguoiKhai);
        ResultSet rs = preparedStatement.executeQuery();
        
        if (rs.next()) {
            tenNguoiKhai = rs.getString("HoTen");
        }
        
        return tenNguoiKhai;
    }
}
