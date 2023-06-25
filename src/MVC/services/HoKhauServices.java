package MVC.services;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoKhauServices {
    public static ResultSet getAllHoKhau() throws SQLException {
        // Connecting Database
        String SELECT_QUERY = "SELECT sohokhau.IdHoKhau, sohokhau.DiaChi, nhankhau.HoTen, COUNT(thanhvienho.IdNhanKhau) AS SoThanhVien\r\n"
        		+ "FROM sohokhau, nhankhau, thanhvienho\r\n"
        		+ "WHERE sohokhau.IdHoKhau = thanhvienho.IdHoKhau AND sohokhau.IdChuHo = nhankhau.IdNhanKhau\r\n"
        		+ "GROUP BY (thanhvienho.IdHoKhau);";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }
    public static int addHoKhau(Connection conn, String ngayTao, String diaChi, int idChuHo) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO sohokhau (NgayTao, DiaChi, IdChuHo) VALUES (?, ?, ?);";
    	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
    	preparedStatement.setString(1, ngayTao);
    	preparedStatement.setString(2, diaChi);
    	preparedStatement.setInt(3, idChuHo);
    	return preparedStatement.executeUpdate();
    }
    public static int addThanhVienHo(Connection conn, int idNhanKhau, int idHoKhau, String quanHeChuHo) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO `thanhvienho`(`IdNhanKhau`, `IdHoKhau`, `QuanHeChuHo`) VALUES (?,?,?)";
    	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
    	preparedStatement.setInt(1, idNhanKhau);
    	preparedStatement.setInt(2, idHoKhau);
    	preparedStatement.setString(3, quanHeChuHo);
    	return preparedStatement.executeUpdate();
    }
    public static int getHoKhauByChuHo(Connection conn, int idChuHo) throws SQLException {
    	int hokhauid = 0;
    	String SELECT_QUERY = "SELECT sohokhau.IdHoKhau FROM sohokhau WHERE sohokhau.IdChuHo = ?";
    	PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
    	preparedStatement.setInt(1, idChuHo);
    	ResultSet result = preparedStatement.executeQuery();
    	while(result.next()) {
    		hokhauid = result.getInt(1);
    	}
    	return hokhauid;
    }
    public static void main(String[] args) throws SQLException {
    	Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    	System.out.println(getHoKhauByChuHo(conn, 9));
	}
}
