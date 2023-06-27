package MVC.model;

public class TamTru {
	
	private int idTamTru;
	private String tenNguoiTamTru;
	private String tenChuHo;
	private String ngayTao;
	private String ngayKetThuc;
	
	public TamTru(int idTamTru, String tenNguoiTamTru, String tenChuHo, String ngayTao, String ngayKetThuc) {
		super();
		this.idTamTru = idTamTru;
		this.tenNguoiTamTru = tenNguoiTamTru;
		this.tenChuHo = tenChuHo;
		this.ngayTao = ngayTao;
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getIdTamTru() {
		return idTamTru;
	}

	public void setIdTamTru(int idTamTru) {
		this.idTamTru = idTamTru;
	}

	public String getTenNguoiTamTru() {
		return tenNguoiTamTru;
	}

	public void setTenNguoiTamTru(String tenNguoiTamTru) {
		this.tenNguoiTamTru = tenNguoiTamTru;
	}

	public String getTenChuHo() {
		return tenChuHo;
	}

	public void setTenChuHo(String tenChuHo) {
		this.tenChuHo = tenChuHo;
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
