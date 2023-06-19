package MVC.model;

public class LichTrinh {
	
	private int idLichTrinh;
	private int idNguoiKhai;
	private String tenLichTrinh;
	
	public LichTrinh(int idLichTrinh, int idNguoiKhai, String tenLichTrinh) {
		super();
		this.idLichTrinh = idLichTrinh;
		this.idNguoiKhai = idNguoiKhai;
		this.tenLichTrinh = tenLichTrinh;
	}

	public int getIdLichTrinh() {
		return idLichTrinh;
	}

	public void setIdLichTrinh(int idLichTrinh) {
		this.idLichTrinh = idLichTrinh;
	}

	public int getIdNguoiKhai() {
		return idNguoiKhai;
	}

	public void setIdNguoiKhai(int idNguoiKhai) {
		this.idNguoiKhai = idNguoiKhai;
	}

	public String getTenLichTrinh() {
		return tenLichTrinh;
	}

	public void setTenLichTrinh(String tenLichTrinh) {
		this.tenLichTrinh = tenLichTrinh;
	}
	
	
	
}
