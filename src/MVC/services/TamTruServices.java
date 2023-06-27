package MVC.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static MVC.constans.DBConstans.*;

public class TamTruServices {
	public static ResultSet getAllTamTru() throws SQLException {
        String SELECT_QUERY = "SELECT tamtru.IdTamTru, A.HoTen AS TenTamTru, tamtru.NgayTao, tamtru.NgayKetThuc, B.HoTen AS TenChuHo\r\n"
        		+ "FROM nhankhau A, nhankhau B, tamtru, sohokhau\r\n"
        		+ "WHERE A.IdNhanKhau = tamtru.IdNguoiTamTru AND tamtru.IdHoKhau = sohokhau.IdHoKhau AND B.IdNhanKhau = sohokhau.IdChuHo";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
	}
	public static int addTamTru(Connection conn, String ngayTao, String ngayKetThuc, int idNguoiTamtru, int idHoKhau) throws SQLException {
		String INSERT_QUERY = "INSERT INTO `tamtru`(`NgayTao`, `NgayKetThuc`, `IdNguoiTamTru`, `IdHoKhau`) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, ngayTao);
		preparedStatement.setString(2, ngayKetThuc);
		preparedStatement.setInt(3, idNguoiTamtru);
		preparedStatement.setInt(4, idHoKhau);
		return preparedStatement.executeUpdate();
	}
	public static int deleteTamTru(int idTamTru) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY = "DELETE FROM tamtru WHERE IdTamTru = ?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idTamTru);
        return preparedStatement.executeUpdate();		
	}
}
