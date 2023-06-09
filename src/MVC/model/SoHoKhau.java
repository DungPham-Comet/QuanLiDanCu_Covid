package MVC.model;

public class SoHoKhau {
	private String idHoKhau;
	private String ngayTao;
	private String diaChi;
	private String idChuHo;
	
	public SoHoKhau(String idHoKhau, String ngayTao, String diaChi, String idChuHo) {
		super();
		this.idHoKhau = idHoKhau;
		this.ngayTao = ngayTao;
		this.diaChi = diaChi;
		this.idChuHo = idChuHo;
	}

	public String getIdHoKhau() {
		return idHoKhau;
	}

	public void setIdHoKhau(String idHoKhau) {
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

	public String getIdChuHo() {
		return idChuHo;
	}

	public void setIdChuHo(String idChuHo) {
		this.idChuHo = idChuHo;
	}
	
	
}
