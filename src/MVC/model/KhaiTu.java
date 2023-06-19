package MVC.model;

public class KhaiTu {
	
	private int idKhaiTu;
	private String tenNguoiChet;
	private String tenNguoiKhai;
	private String ngayKhai;
	private String ngayChet;
	private String lyDoChet;
	
	public KhaiTu(int idKhaiTu, String tenNguoiChet, String tenNguoiKhai, String ngayKhai, String ngayChet,
			String lyDoChet) {
		super();
		this.idKhaiTu = idKhaiTu;
		this.tenNguoiChet = tenNguoiChet;
		this.tenNguoiKhai = tenNguoiKhai;
		this.ngayKhai = ngayKhai;
		this.ngayChet = ngayChet;
		this.lyDoChet = lyDoChet;
	}

	public int getIdKhaiTu() {
		return idKhaiTu;
	}

	public void setIdKhaiTu(int idKhaiTu) {
		this.idKhaiTu = idKhaiTu;
	}

	public String getTenNguoiChet() {
		return tenNguoiChet;
	}

	public void setTenNguoiChet(String tenNguoiChet) {
		this.tenNguoiChet = tenNguoiChet;
	}

	public String getTenNguoiKhai() {
		return tenNguoiKhai;
	}

	public void setTenNguoiKhai(String tenNguoiKhai) {
		this.tenNguoiKhai = tenNguoiKhai;
	}

	public String getNgayKhai() {
		return ngayKhai;
	}

	public void setNgayKhai(String ngayKhai) {
		this.ngayKhai = ngayKhai;
	}

	public String getNgayChet() {
		return ngayChet;
	}

	public void setNgayChet(String ngayChet) {
		this.ngayChet = ngayChet;
	}

	public String getLyDoChet() {
		return lyDoChet;
	}

	public void setLyDoChet(String lyDoChet) {
		this.lyDoChet = lyDoChet;
	}
	
}
