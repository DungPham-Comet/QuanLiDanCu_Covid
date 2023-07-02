package MVC.services;

import static MVC.constans.DBConstans.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanKhauServices {
    public static ResultSet getAllNhanKhau() throws SQLException {
        // Connecting Database
        String SELECT_QUERY = "SELECT nhankhau.*\n" +
                "FROM nhankhau\n";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        return preparedStatement.executeQuery();
    }
    public static String getNhanKhauById(Connection conn, int idNhanKhau) throws SQLException {
    	String tenNhanKhau = "";
    	String SELECT_QUERY = "SELECT nhankhau.HoTen FROM nhankhau WHERE nhankhau.IdNhanKhau = ?";
    	PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
    	preparedStatement.setInt(1, idNhanKhau);
    	ResultSet result = preparedStatement.executeQuery();
    	while(result.next()) {
    		tenNhanKhau = result.getString(1);
    	}
    	return tenNhanKhau;
    }
    public static int deleteNhanKhau(int ID) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        String DELETE_QUERY =
                "DELETE FROM nhankhau " +
                        "WHERE IdNhanKhau =?";
        preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, ID);
        return preparedStatement.executeUpdate();
    }
    public static int deleteNhanKhauViaCCCD(String cccd) throws SQLException {
        String DELETE_QUERY = "DELETE FROM cccd " +
                "WHERE idCccd =?";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setString(1, cccd);
        return preparedStatement.executeUpdate();
    }
    public static int addNhanKhau(Connection conn, String HoTen, String ngaySinh, String nguyenQuan, boolean gioiTinh,
        String danToc, String thuongTru, String tonGiao, String quocTich, String ngheNghiep, String cccd) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO `nhankhau`(`HoTen`, `DOB`, `GioiTinh`, `NguyenQuan`, `DanToc`, `TonGiao`, `QuocTich`, `ThuongTru`, `NgheNghiep`, `MaCccd`) " +
    				"VALUES (?,?,?,?,?,?,?,?,?,?)";
    	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
    	preparedStatement.setString(1, HoTen);
    	preparedStatement.setString(2, ngaySinh);
    	preparedStatement.setBoolean(3, gioiTinh);
    	preparedStatement.setString(4, nguyenQuan);
    	if(danToc.equals("")) preparedStatement.setString(5, "Không");
    	else preparedStatement.setString(5, danToc);
    	if(tonGiao.equals("")) preparedStatement.setString(6, "Không");
    	else preparedStatement.setString(6, tonGiao);
    	if(quocTich.equals("")) preparedStatement.setString(7, "Việt Nam");
    	else preparedStatement.setString(7, quocTich);
    	preparedStatement.setString(8, thuongTru);
    	if(ngheNghiep.equals("")) preparedStatement.setString(9, "Không");
    	else preparedStatement.setString(9, ngheNghiep);
    	if(cccd.equals("")) preparedStatement.setString(10, "");
    	else preparedStatement.setString(10, cccd);
    	return preparedStatement.executeUpdate();
    }
    public static int addCccd(Connection conn, String idCccd, String ngayCap, String ngayHetHan, String noiCap, String dacDiem) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO `cccd`(`IdCccd`, `NgayCap`, `NoiCap`, `NgayHetHan`, `DacDiem`) VALUES (?,?,?,?,?)";
    	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
    	preparedStatement.setString(1, idCccd);
    	preparedStatement.setString(2, ngayCap);
    	preparedStatement.setString(3, noiCap);
    	preparedStatement.setString(4, ngayHetHan);
    	preparedStatement.setString(5, dacDiem);
    	return preparedStatement.executeUpdate();
    }
    public static int updateNhanKhau(Connection conn, String HoTen, String ngaySinh, String nguyenQuan, boolean gioiTinh,
        String danToc, String thuongTru, String tonGiao, String quocTich, String ngheNghiep, String cccd, int id) throws SQLException {
    	String UPDATE_QUERY = "UPDATE `nhankhau` SET `HoTen`=?, `DOB`=?, `GioiTinh`=?, `NguyenQuan`=?, `DanToc`=?, `TonGiao`=?, `QuocTich`=?, `ThuongTru`=?, `NgheNghiep`=?, `MaCccd`=?" +
				"WHERE `IdNhanKhau`=?";
    	PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
    	preparedStatement.setString(1, HoTen);
    	preparedStatement.setString(2, ngaySinh);
    	preparedStatement.setBoolean(3, gioiTinh);
    	preparedStatement.setString(4, nguyenQuan);
    	if(danToc.equals("")) preparedStatement.setString(5, "Không");
    	else preparedStatement.setString(5, danToc);
    	if(tonGiao.equals("")) preparedStatement.setString(6, "Không");
    	else preparedStatement.setString(6, tonGiao);
    	if(quocTich.equals("")) preparedStatement.setString(7, "Việt Nam");
    	else preparedStatement.setString(7, quocTich);
    	preparedStatement.setString(8, thuongTru);
    	if(ngheNghiep.equals("")) preparedStatement.setString(9, "Không");
    	else preparedStatement.setString(9, ngheNghiep);
    	if(cccd.equals("")) preparedStatement.setString(10, "");
    	else preparedStatement.setString(10, cccd);
    	preparedStatement.setInt(11, id);
    	preparedStatement.execute();
    	return preparedStatement.executeUpdate();
    }
    public static int updateCccd(Connection conn, String cccd, int id) throws SQLException {
    	String UPDATE_QUERY_CCCD = "UPDATE `cccd` SET `IdCccd`=? WHERE `idNhanKhau`=?";
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY_CCCD);
        preparedStatement.setString(1, cccd);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
        return preparedStatement.executeUpdate();
    }
    public static ResultSet getCCCd(int idNhanKhau) throws SQLException {
        // Connecting Database
        String SELECT_QUERY = "SELECT nhankhau.HoTen, nhankhau.DOB, nhankhau.GioiTinh, nhankhau.MaCccd, nhankhau.NguyenQuan, nhankhau.ThuongTru, cccd.NgayCap, cccd.NgayHetHan, cccd.NoiCap, cccd.DacDiem FROM nhankhau, cccd WHERE nhankhau.MaCccd = cccd.IdCccd AND nhankhau.IdNhanKhau = ?;";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        preparedStatement.setInt(1, idNhanKhau);
        return preparedStatement.executeQuery();
    }
    public static void main(String[] args) throws SQLException {
		ResultSet result = NhanKhauServices.getCCCd(5);
		while(result.next()) {
			System.out.println(result.getString("HoTen"));
		}
	}
    public static int getTotalNhanKhau() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM nhankhau";
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
    
    public static int getTotalNhanKhauNam() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM nhankhau WHERE nhankhau.GioiTinh = 1";
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
    
    public static int getTotalNhanKhauNu() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM nhankhau WHERE nhankhau.GioiTinh = 0";
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
    
    public static int getTotalNhanKhauTreEm() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM nhankhau WHERE TIMESTAMPDIFF(YEAR, nhankhau.DOB, CURDATE()) <= 18";
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
    
    public static int getTotalNhanKhauLaoDong() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM nhankhau WHERE TIMESTAMPDIFF(YEAR, nhankhau.DOB, CURDATE()) > 18 AND TIMESTAMPDIFF(YEAR, nhankhau.DOB, CURDATE()) < 65";
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
    
    public static int getTotalNhanKhauNghiHuu() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM nhankhau WHERE TIMESTAMPDIFF(YEAR, nhankhau.DOB, CURDATE()) >= 65";
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
}
