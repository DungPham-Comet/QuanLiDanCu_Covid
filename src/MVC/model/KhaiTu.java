package MVC.model;

public class KhaiTu {
	
	private int idKhaiTu;
	private int idNguoiChet;
	private int idNguoiKhai;
	private String ngayKhai;
	private String ngayChet;
	private String lyDoChet;
	
	public KhaiTu(int idKhaiTu, int idNguoiChet, int idNguoiKhai, String ngayKhai, String ngayChet, String lyDoChet) {
		super();
		this.idKhaiTu = idKhaiTu;
		this.idNguoiChet = idNguoiChet;
		this.idNguoiKhai = idNguoiKhai;
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

	public int getIdNguoiChet() {
		return idNguoiChet;
	}

	public void setIdNguoiChet(int idNguoiChet) {
		this.idNguoiChet = idNguoiChet;
	}

	public int getIdNguoiKhai() {
		return idNguoiKhai;
	}

	public void setIdNguoiKhai(int idNguoiKhai) {
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
