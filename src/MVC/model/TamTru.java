package MVC.model;

public class TamTru {
	
	private int idTamTru;
	private int idNguoiTamTru;
	private int maHoKhau;
	private String ngayTao;
	private String ngayKetThuc;
	
	public TamTru(int idTamTru, int idNguoiTamTru, int maHoKhau, String ngayTao, String ngayKetThuc) {
		super();
		this.idTamTru = idTamTru;
		this.idNguoiTamTru = idNguoiTamTru;
		this.maHoKhau = maHoKhau;
		this.ngayTao = ngayTao;
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getIdTamTru() {
		return idTamTru;
	}

	public void setIdTamTru(int idTamTru) {
		this.idTamTru = idTamTru;
	}

	public int getIdNguoiTamTru() {
		return idNguoiTamTru;
	}

	public void setIdNguoiTamTru(int idNguoiTamTru) {
		this.idNguoiTamTru = idNguoiTamTru;
	}

	public int getMaHoKhau() {
		return maHoKhau;
	}

	public void setMaHoKhau(int maHoKhau) {
		this.maHoKhau = maHoKhau;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	
}
