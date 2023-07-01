package MVC.model;

public class XetNghiem {
	
	private int idXetNghiem;
	private String hinhThuc;
	private String thoiGian;
	private String ketQua;
	private String tenNguoiXetNghiem;
	
	public XetNghiem(int idXetNghiem, String hinhThuc, String thoiGian, String ketQua, String tenNguoiXetNghiem) {
		super();
		this.idXetNghiem = idXetNghiem;
		this.hinhThuc = hinhThuc;
		this.thoiGian = thoiGian;
		this.ketQua = ketQua;
		this.tenNguoiXetNghiem = tenNguoiXetNghiem;
	}

	public int getIdXetNghiem() {
		return idXetNghiem;
	}

	public void setIdXetNghiem(int idXetNghiem) {
		this.idXetNghiem = idXetNghiem;
	}

	public String getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

	public String getTenNguoiXetNghiem() {
		return tenNguoiXetNghiem;
	}

	public void setTenNguoiXetNghiem(String tenNguoiXetNghiem) {
		this.tenNguoiXetNghiem = tenNguoiXetNghiem;
	}
	
}
