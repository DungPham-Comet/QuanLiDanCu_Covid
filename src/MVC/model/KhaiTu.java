package MVC.model;

public class KhaiTu {
	
	private String idKhaiTu;
	private String idNguoiChet;
	private String idNguoiKhai;
	private String ngayKhai;
	private String ngayChet;
	private String lyDoChet;
	
	public KhaiTu(String idKhaiTu, String idNguoiChet, String idNguoiKhai, String ngayKhai, String ngayChet,
			String lyDoChet) {
		super();
		this.idKhaiTu = idKhaiTu;
		this.idNguoiChet = idNguoiChet;
		this.idNguoiKhai = idNguoiKhai;
		this.ngayKhai = ngayKhai;
		this.ngayChet = ngayChet;
		this.lyDoChet = lyDoChet;
	}

	public String getIdKhaiTu() {
		return idKhaiTu;
	}

	public void setIdKhaiTu(String idKhaiTu) {
		this.idKhaiTu = idKhaiTu;
	}

	public String getIdNguoiChet() {
		return idNguoiChet;
	}

	public void setIdNguoiChet(String idNguoiChet) {
		this.idNguoiChet = idNguoiChet;
	}

	public String getIdNguoiKhai() {
		return idNguoiKhai;
	}

	public void setIdNguoiKhai(String idNguoiKhai) {
		this.idNguoiKhai = idNguoiKhai;
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
