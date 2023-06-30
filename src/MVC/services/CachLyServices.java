package MVC.services;

import static MVC.constans.DBConstans.DATABASE;
import static MVC.constans.DBConstans.PASSWORD;
import static MVC.constans.DBConstans.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CachLyServices {
	public static ResultSet getAllCachLy() throws SQLException {
    	String SELECT_QUERY = "SELECT A.HoTen AS TenNguoiCachLy, cachly.IdCachLy, cachly.MucDo, cachly.DiaDiem, cachly.IdNguoiCachLy, cachly.ThoiGian FROM nhankhau A, cachly\n"
    			+ "WHERE A.IdNhanKhau = cachly.IdNguoiCachLy;";
    	Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }
	
	public static int deleteCachLy(int idCachLy) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY =
                "DELETE FROM cnpm2023.cachly " +
                        "WHERE IdCachLy = ?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, idCachLy);
        return preparedStatement.executeUpdate();
    }
	
	public static int updateCachLy(Connection conn, String mucDo, String thoiGian,String diaDiem, int idCachLy) throws SQLException {
        	String UPDATE_QUERY = "UPDATE `cachly` SET  `DiaDiem` = ?, `MucDo` = ?, `ThoiGian` = ?" +
    				"WHERE `IdCachLy` = ?";
        	PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
        	preparedStatement.setString(1, diaDiem);
        	preparedStatement.setString(2, mucDo);
        	preparedStatement.setString(3, thoiGian);
        	preparedStatement.setInt(4, idCachLy);
        	preparedStatement.execute();
        	return preparedStatement.executeUpdate();
        }
	
	public static int addCachLy(Connection conn, int idNguoiCachLy, String mucDo, String thoiGian, String diaDiem) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO cachly (IdNguoiCachLy, MucDo, ThoiGian, DiaDiem) VALUES (?, ?, ?, ?);";
    	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
    	preparedStatement.setInt(1, idNguoiCachLy);
    	preparedStatement.setString(2, mucDo);
    	preparedStatement.setString(3, thoiGian);
    	preparedStatement.setString(4, diaDiem);
    	return preparedStatement.executeUpdate();
    }
}
