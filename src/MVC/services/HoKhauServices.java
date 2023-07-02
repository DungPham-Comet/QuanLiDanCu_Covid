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
        String SELECT_QUERY = "SELECT sohokhau.IdHoKhau, sohokhau.DiaChi, sohokhau.NgayTao, nhankhau.HoTen, COUNT(thanhvienho.IdNhanKhau) AS SoThanhVien\r\n"
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
    
    public static ResultSet getAllThanhVien(int idHoKhau) throws SQLException {
    	String SELECT_QUERY = "SELECT nhankhau.IdNhanKhau, nhankhau.HoTen, nhankhau.MaCccd, thanhvienho.QuanHeChuHo\r\n"
    			+ "FROM nhankhau, thanhvienho\r\n"
    			+ "WHERE nhankhau.IdNhanKhau = thanhvienho.IdNhanKhau AND thanhvienho.IdHoKhau = ?";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        preparedStatement.setInt(1, idHoKhau);
        return preparedStatement.executeQuery();
    }
    
    public static int deleteThanhVien(int idNhanKhau) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY = "DELETE FROM thanhvienho WHERE IdNhanKhau = ?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idNhanKhau);
        return preparedStatement.executeUpdate();
    }
    
    public static int deleteHoKhau(int idHoKhau) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY = "DELETE FROM sohokhau WHERE IdHoKhau = ?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idHoKhau);
        return preparedStatement.executeUpdate();
    }
    
    public static int updateThanhVien(int idNhanKhau, String quanHe) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String UPDATE_QUERY = "UPDATE thanhvienho SET thanhvienho.QuanHeChuHo = ? WHERE thanhvienho.IdNhanKhau = ?;";
        preparedStatement = conn.prepareStatement(UPDATE_QUERY);
        preparedStatement.setString(1, quanHe);
        preparedStatement.setInt(2, idNhanKhau);
        return preparedStatement.executeUpdate();    	
    }
    
    public static int updateHoKhau(int idHoKhau, int idNhanKhau) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String UPDATE_QUERY = "UPDATE sohokhau SET IdChuHo = ? WHERE IdHoKhau = ?;";
        preparedStatement = conn.prepareStatement(UPDATE_QUERY);
        preparedStatement.setInt(1, idNhanKhau);
        preparedStatement.setInt(2, idHoKhau);
        return preparedStatement.executeUpdate();    	
    }
    public static int checkThanhVien(int idNhanKhau, int idHoKhau) throws SQLException {
    	int check = 0;
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String SELECT_QUERY = "SELECT COUNT(*) AS dem FROM thanhvienho WHERE thanhvienho.IdNhanKhau = ? AND thanhvienho.IdHoKhau = ?";
        preparedStatement = conn.prepareStatement(SELECT_QUERY);
        preparedStatement.setInt(1, idNhanKhau);
        preparedStatement.setInt(2, idHoKhau);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            check = result.getInt("dem");
        }
    	return check;
    }
    public static int getTotalSoHoKhau() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM sohokhau";
        try {
            Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(GET_QUERY);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                total = result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }
    
    public static int getTotalSoHoKhauByYear(int year) {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM sohokhau WHERE YEAR(sohokhau.NgayTao) < ?";
        try {
            Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(GET_QUERY);
            preparedStatement.setInt(1, year);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                total = result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }
    
    public static void main(String[] args) throws SQLException {
    	Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    	System.out.println(getHoKhauByChuHo(conn, 9));
	}
}
