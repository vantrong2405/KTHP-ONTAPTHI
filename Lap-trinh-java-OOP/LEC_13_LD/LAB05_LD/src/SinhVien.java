/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trong
 */
public class SinhVien {
    public String maSv , hoTen;
    public boolean gioiTinh ; 
    public double diemTrungBinh;

    public SinhVien() {
    }

    public SinhVien(String maSv, String hoTen, boolean gioiTinh, double diemTrungBinh) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }
    
    public String xepLoai(){
        if(diemTrungBinh < 3.5) return "Kem";
        if(diemTrungBinh < 5.0) return "Yeu";
        if(diemTrungBinh < 6.5) return "Trung binh";
        if(diemTrungBinh < 8) return "Kha";
        if(diemTrungBinh < 9) return "Gioi";
        return "Xuat sac";
    }
    
    public String toString(){
        return maSv+", "+hoTen+", "+(gioiTinh?"Nam":"Nu")+", "+diemTrungBinh+", "+xepLoai();
    }
}
