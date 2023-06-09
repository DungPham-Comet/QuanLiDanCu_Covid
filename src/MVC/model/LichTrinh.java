package MVC.model;

public class LichTrinh {
	private int idLichTrinh;
	private String tenLichTrinh;
	public LichTrinh(int idLichTrinh, String tenLichTrinh) {
		this.idLichTrinh = idLichTrinh;
		this.tenLichTrinh = tenLichTrinh;
	}
	public int getIdLichTrinh() {
		return idLichTrinh;
	}
	public void setIdLichTrinh(int idLichTrinh) {
		this.idLichTrinh = idLichTrinh;
	}
	public String getTenLichTrinh() {
		return tenLichTrinh;
	}
	public void setTenLichTrinh(String tenLichTrinh) {
		this.tenLichTrinh = tenLichTrinh;
	}
	
}
