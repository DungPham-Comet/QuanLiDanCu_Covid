package MVC.services;

import static MVC.constans.DBConstans.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LichTrinhServices {
	public static ResultSet getAllLichTrinh() throws SQLException {
    	String SELECT_QUERY = "SELECT  IdLichTrinh, IdNguoiKhai, TenLichTrinh, nhankhau.HoTen AS TenNguoiKhai FROM lichtrinh , nhankhau\n"
    			+"WHERE lichtrinh.IdNguoiKhai = nhankhau.IdNhanKhau";
    	Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }
}
