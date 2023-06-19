package MVC.model;

public class CachLy {
	
	private int idCachLy;
	private String thoiGian;
	private String mucDo;
	private String diaDiem;
	private int idNguoiCachLy;
	
	public CachLy(int idCachLy, String thoiGian, String mucDo, String diaDiem, int idNguoiCachLy) {
		super();
		this.idCachLy = idCachLy;
		this.thoiGian = thoiGian;
		this.mucDo = mucDo;
		this.diaDiem = diaDiem;
		this.idNguoiCachLy = idNguoiCachLy;
	}

	public int getIdCachLy() {
		return idCachLy;
	}

	public void setIdCachLy(int idCachLy) {
		this.idCachLy = idCachLy;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getMucDo() {
		return mucDo;
	}

	public void setMucDo(String mucDo) {
		this.mucDo = mucDo;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public int getIdNguoiCachLy() {
		return idNguoiCachLy;
	}

	public void setIdNguoiCachLy(int idNguoiCachLy) {
		this.idNguoiCachLy = idNguoiCachLy;
	}
	
	
}
