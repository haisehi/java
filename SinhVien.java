package main;

public class SinhVien implements Comparable<SinhVien> {
	private String id ;
	private String hovaten;
	private int namsinh;
	private double diemtrungbinh ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	public int getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	public double getDiemtrungbinh() {
		return diemtrungbinh;
	}
	public void setDiemtrungbinh(double diemtrungbinh) {
		this.diemtrungbinh = diemtrungbinh;
	}
	
	public SinhVien(String id) {
		this.id = id;
	}
	public SinhVien(String id, String hovaten, int namsinh, double diemtrungbinh) {
		this.id = id;
		this.hovaten = hovaten;
		this.namsinh = namsinh;
		this.diemtrungbinh = diemtrungbinh;
	}
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", hovaten=" + hovaten + ", namsinh=" + namsinh + ", diemtrungbinh="
				+ diemtrungbinh + "]";
	}
	@Override
	public int compareTo(SinhVien o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(id);
	}

}
