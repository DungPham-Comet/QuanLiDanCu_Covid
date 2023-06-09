package MVC.model;

public class ThanhVienCuaHo {
	
	private String idNhanKhau;
	private String maHoKhau;
	private String quanHeChuHo;
	
	public ThanhVienCuaHo(String idNhanKhau, String maHoKhau, String quanHeChuHo) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.maHoKhau = maHoKhau;
		this.quanHeChuHo = quanHeChuHo;
	}

	public String getIdNhanKhau() {
		return idNhanKhau;
	}

	public void setIdNhanKhau(String idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}

	public String getMaHoKhau() {
		return maHoKhau;
	}

	public void setMaHoKhau(String maHoKhau) {
		this.maHoKhau = maHoKhau;
	}

	public String getQuanHeChuHo() {
		return quanHeChuHo;
	}

	public void setQuanHeChuHo(String quanHeChuHo) {
		this.quanHeChuHo = quanHeChuHo;
	}
	
	
}
