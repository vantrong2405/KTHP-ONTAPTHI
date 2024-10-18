/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311_finalexam_nguyenanhtuan;

public abstract class KhachHang {
    String maDinhDanh,hoTen;
    boolean gioiTinh;
    String queQuan,ngayDen,ngayDi;
    double soLuong,donGia;
    public KhachHang() {
    }
    public KhachHang(String maDinhDanh, String hoTen, boolean gioiTinh, String queQuan, String ngayDen, String ngayDi, double soLuong, double donGia) {
        this.maDinhDanh = maDinhDanh;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaDinhDanh() {
        return maDinhDanh;
    }

    public void setMaDinhDanh(String maDinhDanh) {
        this.maDinhDanh = maDinhDanh;
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

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(String ngayDen) {
        this.ngayDen = ngayDen;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "maDinhDanh=" + maDinhDanh + ", hoTen=" + hoTen + ", gioiTinh=" + (gioiTinh?"Nam":"Nu") + ", queQuan=" + queQuan + ", ngayDen=" + ngayDen + ", ngayDi=" + ngayDi + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
    
    public abstract Double tinhTT();
}
