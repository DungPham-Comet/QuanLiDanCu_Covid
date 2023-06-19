package MVC.model;

public class SoHoKhau {
	private int idHoKhau;
	private String ngayTao;
	private String diaChi;
	private int idChuHo;
	
	public SoHoKhau(int idHoKhau, String ngayTao, String diaChi, int idChuHo) {
		super();
		this.idHoKhau = idHoKhau;
		this.ngayTao = ngayTao;
		this.diaChi = diaChi;
		this.idChuHo = idChuHo;
	}

	public int getIdHoKhau() {
		return idHoKhau;
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

	public int getIdChuHo() {
		return idChuHo;
	}

	public void setIdChuHo(int idChuHo) {
		this.idChuHo = idChuHo;
	}
	
	
}
