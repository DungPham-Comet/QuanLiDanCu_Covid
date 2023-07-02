package MVC.services;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TamVangServices {
	public static ResultSet getAllTamVang() throws SQLException {
        String SELECT_QUERY = "SELECT tamvang.IdTamVang, nhankhau.HoTen, tamvang.NgayTao, tamvang.NgayKetThuc, tamvang.DiaDiem\r\n"
        		+ "FROM tamvang, nhankhau\r\n"
        		+ "WHERE tamvang.IdNguoiTamVang = nhankhau.IdNhanKhau;";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
	}
	public static int addTamVang(Connection conn, String ngayTao, String ngayKetThuc, int idNguoiVang, String diaDiem) throws SQLException {
		String INSERT_QUERY = "INSERT INTO `tamvang`(`NgayTao`, `NgayKetThuc`, `IdNguoiTamVang`, `DiaDiem`) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, ngayTao);
		preparedStatement.setString(2, ngayKetThuc);
		preparedStatement.setInt(3, idNguoiVang);
		preparedStatement.setString(4, diaDiem);
		return preparedStatement.executeUpdate();
	}
	public static int deleteTamVang(int idTamVang) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY = "DELETE FROM tamvang WHERE IdTamVang = ?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idTamVang);
        return preparedStatement.executeUpdate();		
	}
    public static int getTotalTamVangByDate(String fromdate, String todate) {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM tamvang WHERE (? <= tamvang.NgayTao AND tamvang.NgayTao <= ?) OR  (? <= tamvang.NgayKetThuc AND tamvang.NgayKetThuc <= ?) OR (tamvang.NgayTao <= ? AND tamvang.NgayKetThuc >= ?)";
        try {
            Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(GET_QUERY);
            preparedStatement.setString(1, fromdate);
            preparedStatement.setString(2, todate);
            preparedStatement.setString(3, fromdate);
            preparedStatement.setString(4, todate);
            preparedStatement.setString(5, fromdate);
            preparedStatement.setString(6, todate);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                total = result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }
}
