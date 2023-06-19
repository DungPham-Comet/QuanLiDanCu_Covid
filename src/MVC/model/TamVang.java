package MVC.model;

public class TamVang {
	
	private int idTamVang;
	private int idNguoiTamVang;
	private String ngayTao;
	private String ngayKetThuc;
	
	public TamVang(int idTamVang, int idNguoiTamVang, String ngayTao, String ngayKetThuc) {
		super();
		this.idTamVang = idTamVang;
		this.idNguoiTamVang = idNguoiTamVang;
		this.ngayTao = ngayTao;
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getIdTamVang() {
		return idTamVang;
	}

	public void setIdTamVang(int idTamVang) {
		this.idTamVang = idTamVang;
	}

	public int getIdNguoiTamVang() {
		return idNguoiTamVang;
	}

	public void setIdNguoiTamVang(int idNguoiTamVang) {
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
