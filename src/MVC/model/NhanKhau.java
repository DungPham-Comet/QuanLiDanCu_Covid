package MVC.model;


public class NhanKhau {
	
	private int idNhanKhau; 
	private String maCccd;
	private String hoTen;
	private String ngaySinh;
	private String gioiTinh;
	private String danToc;
	private String quocTich;
	private String tonGiao;
	private String nguyenQuan;
	private String thuongTru;
	private String ngheNghiep;
	public NhanKhau(int idNhanKhau, String maCccd, String hoTen, String ngaySinh, String gioiTinh, String danToc,
			String quocTich, String tonGiao, String nguyenQuan, String thuongTru, String ngheNghiep) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.maCccd = maCccd;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.danToc = danToc;
		this.quocTich = quocTich;
		this.tonGiao = tonGiao;
		this.nguyenQuan = nguyenQuan;
		this.thuongTru = thuongTru;
		this.ngheNghiep = ngheNghiep;
	}

	
	
	public NhanKhau() {
		super();
	}



	public NhanKhau(int idNhanKhau, String maCccd, String hoTen, String ngaySinh, String quocTich, String nguyenQuan,
			String thuongTru) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.maCccd = maCccd;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.quocTich = quocTich;
		this.nguyenQuan = nguyenQuan;
		this.thuongTru = thuongTru;
	}

	public int getIdNhanKhau() {
		return idNhanKhau;
	}

	public void setIdNhanKhau(int idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}

	public String getMaCccd() {
		return maCccd;
	}

	public void setMaCccd(String maCccd) {
		this.maCccd = maCccd;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public String getTonGiao() {
		return tonGiao;
	}

	public void setTonGiao(String tonGiao) {
		this.tonGiao = tonGiao;
	}

	public String getNguyenQuan() {
		return nguyenQuan;
	}

	public void setNguyenQuan(String nguyenQuan) {
		this.nguyenQuan = nguyenQuan;
	}

	public String getThuongTru() {
		return thuongTru;
	}

	public void setThuongTru(String thuongTru) {
		this.thuongTru = thuongTru;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}
	
	
	
}
