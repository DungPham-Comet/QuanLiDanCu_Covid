package MVC.model;

public class Cccd {
	
	private String idCccd;
	private String ngayCap;
	private String noiCap;
	private String ngayHetHan;
	private String dacDiem;
	
	public Cccd(String idCccd, String ngayCap, String noiCap, String ngayHetHan, String dacDiem) {
		super();
		this.idCccd = idCccd;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.ngayHetHan = ngayHetHan;
		this.dacDiem = dacDiem;
	}

	public String getIdCccd() {
		return idCccd;
	}

	public void setIdCccd(String idCccd) {
		this.idCccd = idCccd;
	}

	public String getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(String ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getDacDiem() {
		return dacDiem;
	}

	public void setDacDiem(String dacDiem) {
		this.dacDiem = dacDiem;
	}
	
	
}
