package MVC.model;

public class ThanhVienCuaHo {
	
	private int idNhanKhau;
	private int maHoKhau;
	private String quanHeChuHo;
	
	public ThanhVienCuaHo(int idNhanKhau, int maHoKhau, String quanHeChuHo) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.maHoKhau = maHoKhau;
		this.quanHeChuHo = quanHeChuHo;
	}

	public int getIdNhanKhau() {
		return idNhanKhau;
	}

	public void setIdNhanKhau(int idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}

	public int getMaHoKhau() {
		return maHoKhau;
	}

	public void setMaHoKhau(int maHoKhau) {
		this.maHoKhau = maHoKhau;
	}

	public String getQuanHeChuHo() {
		return quanHeChuHo;
	}

	public void setQuanHeChuHo(String quanHeChuHo) {
		this.quanHeChuHo = quanHeChuHo;
	}
	
	
}
