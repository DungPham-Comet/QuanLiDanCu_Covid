package MVC.model;

public class SoHoKhau {
	private int idHoKhau;
	private String ngayTao;
	private String diaChi;
	private String tenChuHo;
	private int soThanhVen;
	
	public int getIdHoKhau() {
		return idHoKhau;
	}

	public SoHoKhau(int idHoKhau, String diaChi, String tenChuHo, int soThanhVen) {
		super();
		this.idHoKhau = idHoKhau;
		this.diaChi = diaChi;
		this.tenChuHo = tenChuHo;
		this.soThanhVen = soThanhVen;
	}

	public String getTenChuHo() {
		return tenChuHo;
	}

	public void setTenChuHo(String tenChuHo) {
		this.tenChuHo = tenChuHo;
	}

	public int getSoThanhVen() {
		return soThanhVen;
	}

	public void setSoThanhVen(int soThanhVen) {
		this.soThanhVen = soThanhVen;
	}

	public void setIdHoKhau(int idHoKhau) {
		this.idHoKhau = idHoKhau;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
}
