package MVC.services;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiChuyenServices {
	public static ResultSet getAllDiChuyen(int idLichTrinh) throws SQLException {
    	String SELECT_QUERY = "SELECT * FROM thongtindichuyen WHERE thongtindichuyen.IdLichTrinh = ?";
    	Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        preparedStatement.setInt(1, idLichTrinh);
        return preparedStatement.executeQuery();
    }
	
	public static int deleteDiChuyen(int idLichTrinh) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY =
                "DELETE FROM cnpm2023.lichtrinh " +
                        "WHERE IdLichTrinh =?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idLichTrinh);
        return preparedStatement.executeUpdate();
    }
	
	public static int addDiChuyen(Connection conn, int idLichTrinh, String phuongTien, String thoiGian, String diaDiem) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO thongtindichuyen (IdLichTrinh, PhuongTien, ThoiGian, DiaDiem) VALUES (?, ?, ?, ?);";
    	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
    	preparedStatement.setInt(1, idLichTrinh);
    	preparedStatement.setString(2, phuongTien);
    	preparedStatement.setString(3, thoiGian);
    	preparedStatement.setString(4, diaDiem);
    	return preparedStatement.executeUpdate();
    }
	
	public static int deleteThongTin(int idThongTinDiChuyen) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY =
                "DELETE FROM cnpm2023.thongtindichuyen " +
                        "WHERE IdThongTin = ?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idThongTinDiChuyen);
        return preparedStatement.executeUpdate();
    }
}
