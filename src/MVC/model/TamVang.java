package MVC.model;

public class TamVang {
	
	private String idTamVang;
	private String idNguoiTamVang;
	private String ngayTao;
	private String ngayKetThuc;
	
	public TamVang(String idTamVang, String idNguoiTamVang, String ngayTao, String ngayKetThuc) {
		super();
		this.idTamVang = idTamVang;
		this.idNguoiTamVang = idNguoiTamVang;
		this.ngayTao = ngayTao;
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getIdTamVang() {
		return idTamVang;
	}

	public void setIdTamVang(String idTamVang) {
		this.idTamVang = idTamVang;
	}

	public String getIdNguoiTamVang() {
		return idNguoiTamVang;
	}

	public void setIdNguoiTamVang(String idNguoiTamVang) {
		this.idNguoiTamVang = idNguoiTamVang;
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
