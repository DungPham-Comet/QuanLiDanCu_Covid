package MVC.model;

public class CachLy {
	
	private int idCachLy;
	private String thoiGian;
	private String mucDo;
	private String diaDiem;
	private String nguoiCachLy;
	
	public CachLy(int idCachLy, String thoiGian, String mucDo, String diaDiem, String nguoiCachLy) {
		super();
		this.idCachLy = idCachLy;
		this.thoiGian = thoiGian;
		this.mucDo = mucDo;
		this.diaDiem = diaDiem;
		this.nguoiCachLy = nguoiCachLy;
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

	public String getNguoiCachLy() {
		return nguoiCachLy;
	}

	public void setNguoiCachLy(String nguoiCachLy) {
		this.nguoiCachLy = nguoiCachLy;
	}
	
	
	
	
}
