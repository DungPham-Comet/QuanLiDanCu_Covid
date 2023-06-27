package MVC.model;

public class TamVang {
	
	private int idTamVang;
	private String tenNguoiTamVang;
	private String ngayTao;
	private String ngayKetThuc;
	private String diaDiem;
	
	public TamVang(int idTamVang, String tenNguoiTamVang, String ngayTao, String ngayKetThuc, String diaDiem) {
		super();
		this.idTamVang = idTamVang;
		this.tenNguoiTamVang = tenNguoiTamVang;
		this.ngayTao = ngayTao;
		this.ngayKetThuc = ngayKetThuc;
		this.diaDiem = diaDiem;
	}

	public int getIdTamVang() {
		return idTamVang;
	}

	public void setIdTamVang(int idTamVang) {
		this.idTamVang = idTamVang;
	}

	public String getTenNguoiTamVang() {
		return tenNguoiTamVang;
	}

	public void setTenNguoiTamVang(String tenNguoiTamVang) {
		this.tenNguoiTamVang = tenNguoiTamVang;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
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
