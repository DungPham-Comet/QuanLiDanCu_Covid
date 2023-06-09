package MVC.model;

public class TamTru {
	
	private String idTamTru;
	private String idNguoiTamTru;
	private String maHoKhau;
	private String ngayTao;
	private String ngayKetThuc;
	
	public TamTru(String idTamTru, String idNguoiTamTru, String maHoKhau, String ngayTao, String ngayKetThuc) {
		super();
		this.idTamTru = idTamTru;
		this.idNguoiTamTru = idNguoiTamTru;
		this.maHoKhau = maHoKhau;
		this.ngayTao = ngayTao;
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getIdTamTru() {
		return idTamTru;
	}

	public void setIdTamTru(String idTamTru) {
		this.idTamTru = idTamTru;
	}

	public String getIdNguoiTamTru() {
		return idNguoiTamTru;
	}

	public void setIdNguoiTamTru(String idNguoiTamTru) {
		this.idNguoiTamTru = idNguoiTamTru;
	}

	public String getMaHoKhau() {
		return maHoKhau;
	}

	public void setMaHoKhau(String maHoKhau) {
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
