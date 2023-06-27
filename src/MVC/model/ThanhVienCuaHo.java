package MVC.model;

public class ThanhVienCuaHo {
	
	private int idNhanKhau;
	private String hoTen;
	private String cccd;
	private String quanHeChuHo;
	
	public ThanhVienCuaHo(int idNhanKhau, String hoTen, String cccd, String quanHeChuHo) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.hoTen = hoTen;
		this.cccd = cccd;
		this.quanHeChuHo = quanHeChuHo;
	}
	

	public int getIdNhanKhau() {
		return idNhanKhau;
	}


	public void setIdNhanKhau(int idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}


	public String getQuanHeChuHo() {
		return quanHeChuHo;
	}

	public void setQuanHeChuHo(String quanHeChuHo) {
		this.quanHeChuHo = quanHeChuHo;
	}
	
	
}
