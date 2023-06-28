package MVC.model;

public class LichTrinh {
	
	private int idLichTrinh;
	private String tenNguoiKhai;
	private String tenLichTrinh;
	
	public LichTrinh(int idLichTrinh, String tenNguoiKhai, String tenLichTrinh) {
		super();
		this.idLichTrinh = idLichTrinh;
		this.tenNguoiKhai = tenNguoiKhai;
		this.tenLichTrinh = tenLichTrinh;
	}

	public int getIdLichTrinh() {
		return idLichTrinh;
	}

	public void setIdLichTrinh(int idLichTrinh) {
		this.idLichTrinh = idLichTrinh;
	}

	public String getTenNguoiKhai() {
		return tenNguoiKhai;
	}

	public void setTenNguoiKhai(String tenNguoiKhai) {
		this.tenNguoiKhai = tenNguoiKhai;
	}

	public String getTenLichTrinh() {
		return tenLichTrinh;
	}

	public void setTenLichTrinh(String tenLichTrinh) {
		this.tenLichTrinh = tenLichTrinh;
	}
	
}
