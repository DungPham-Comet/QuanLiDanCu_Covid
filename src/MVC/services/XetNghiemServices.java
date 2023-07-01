package MVC.services;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XetNghiemServices {
	public static ResultSet getAllXetNghiem() throws SQLException {
    	String SELECT_QUERY = "SELECT A.HoTen AS TenNguoiXetNghiem, xetnghiem.IdXetNghiem, xetnghiem.HinhThuc, xetnghiem.ThoiGian, xetnghiem.KetQua from NhanKhau A, xetnghiem\n"
    			+ "WHERE A.IdNhanKhau = xetnghiem.IdNguoiXetNghiem;";
    	Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }

	public static int deleteXetNghiem(int idXetNghiem) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY =
                "DELETE FROM cnpm2023.xetnghiem " +
                        "WHERE IdXetNghiem = ?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idXetNghiem);
        return preparedStatement.executeUpdate();
    }
	
	public static int addXetNghiem(Connection conn, int idNguoiXetNghiem, String hinhThuc, String thoiGian, String ketQua) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO xetnghiem (IdNguoiXetNghiem, HinhThuc, ThoiGian, KetQua) VALUES (?, ?, ?, ?);";
    	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
    	preparedStatement.setInt(1, idNguoiXetNghiem);
    	preparedStatement.setString(2, hinhThuc);
    	preparedStatement.setString(3, thoiGian);
    	preparedStatement.setString(4, ketQua);
    	return preparedStatement.executeUpdate();
    }
	
	public static int updateXetNghiem(Connection conn, String hinhThuc, String thoiGian,String ketQua, int idXetNghiem) throws SQLException {
    	String UPDATE_QUERY = "UPDATE `xetnghiem` SET  `ThoiGian` = ?, `KetQua` = ?, `HinhThuc` = ?" +
				"WHERE `IdXetNghiem` = ?";
    	PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
    	preparedStatement.setString(1, thoiGian);
    	preparedStatement.setString(2, ketQua);
    	preparedStatement.setString(3, hinhThuc);
    	preparedStatement.setInt(4, idXetNghiem);
    	preparedStatement.execute();
    	return preparedStatement.executeUpdate();
    }
}
