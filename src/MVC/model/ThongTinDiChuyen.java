package MVC.model;

public class ThongTinDiChuyen {
	
	private int idThongTin;
	private String phuongTien;
	private String thoiGian;
	private String diaDiem;
	private int idLichTrinh;
	
	public ThongTinDiChuyen(int idThongTin, String phuongTien, String thoiGian, String diaDiem, int idLichTrinh) {
		super();
		this.idThongTin = idThongTin;
		this.phuongTien = phuongTien;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
		this.idLichTrinh = idLichTrinh;
	}

	public int getIdThongTin() {
		return idThongTin;
	}

	public void setIdThongTin(int idThongTin) {
		this.idThongTin = idThongTin;
	}

	public String getPhuongTien() {
		return phuongTien;
	}

	public void setPhuongTien(String phuongTien) {
		this.phuongTien = phuongTien;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public int getIdLichTrinh() {
		return idLichTrinh;
	}

	public void setIdLichTrinh(int idLichTrinh) {
		this.idLichTrinh = idLichTrinh;
	}
	
}
