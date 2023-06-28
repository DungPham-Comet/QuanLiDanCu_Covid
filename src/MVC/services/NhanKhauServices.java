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
    public static int deleteNhanKhauViaCCCD(int ID) throws SQLException {
        String DELETE_QUERY = "DELETE FROM cccd " +
                "WHERE idNhankhau =?";
        Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, ID);
        return preparedStatement.executeUpdate();
    }
    public static int addNhanKhau(Connection conn, String HoTen, String ngaySinh, String nguyenQuan, boolean gioiTinh,
        String danToc, String thuongTru, String tonGiao, String quocTich, String ngheNghiep) throws SQLException {
    	String INSERT_QUERY = "INSERT INTO `nhankhau`(`HoTen`, `DOB`, `GioiTinh`, `NguyenQuan`, `DanToc`, `TonGiao`, `QuocTich`, `ThuongTru`, `NgheNghiep`) " +
    				"VALUES (?,?,?,?,?,?,?,?,?)";
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
    	return preparedStatement.executeUpdate();
    }
    public static int updateNhanKhau(Connection conn, String HoTen, String ngaySinh, String nguyenQuan, boolean gioiTinh,
        String danToc, String thuongTru, String tonGiao, String quocTich, String ngheNghiep, int id) throws SQLException {
    	String UPDATE_QUERY = "UPDATE `nhankhau` SET `HoTen`=?, `DOB`=?, `GioiTinh`=?, `NguyenQuan`=?, `DanToc`=?, `TonGiao`=?, `QuocTich`=?, `ThuongTru`=?, `NgheNghiep`=?" +
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
    	preparedStatement.setInt(10, id);
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
}
