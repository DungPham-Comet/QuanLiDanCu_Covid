package MVC.services;

import static MVC.constans.DBConstans.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhaiTuServices {

    public static ResultSet getAllKhaiTu() throws SQLException {
    	String SELECT_QUERY = "SELECT A.HoTen AS TenNguoiChet, B.HoTen AS TenNguoiKhai, khaitu.IdKhaiTu, khaitu.NgayChet, khaitu.LyDoChet, khaitu.NgayKhai FROM nhankhau A, nhankhau B, khaitu\n"
    			+ "WHERE A.IdNhanKhau = khaitu.IdNguoiChet AND B.IdNhanKhau = khaitu.IdNguoiKhai;";
    	Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }
    
    public static int deleteKhaiTu(int idKhaiTu) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY =
                "DELETE FROM cnpm2023.khaitu " +
                        "WHERE IdKhaiTu =?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idKhaiTu);
        return preparedStatement.executeUpdate();
    }
}
