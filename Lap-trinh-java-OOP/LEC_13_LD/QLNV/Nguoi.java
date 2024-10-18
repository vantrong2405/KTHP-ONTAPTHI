/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNV;

/**
 *
 * @author ADMIN
 */
public abstract class Nguoi {
    protected String ma , ten , ngaySinh ;
    protected boolean gioiTinh ;
    protected String chucVu , soDienThoai;
    protected double  soNgayLam , soNgayDiTre , soGioTangCa ;
    protected double ngayCong = 26 ; 
    protected abstract double phuCap(); 
    protected abstract double getThanhTien();
    
    public String toString(){
        return ma +", "+ten+", "+ngaySinh+", "+(gioiTinh?" Nam":" Nu")+", "+chucVu+", SDT: "+soDienThoai+", "+(int)soNgayLam+", "+soNgayDiTre+", "+soGioTangCa;
    }
    public Nguoi() {
    }

    public Nguoi(String ma, String ten, String ngaySinh, boolean gioiTinh, String chucVu, String soDienThoai, double soNgayLam, double soNgayDiTre, double soGioTangCa) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.soDienThoai = soDienThoai;
        this.soNgayLam = soNgayLam;
        this.soNgayDiTre = soNgayDiTre;
        this.soGioTangCa = soGioTangCa;
       
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

  

    public double getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(double soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public double getSoNgayDiTre() {
        return soNgayDiTre;
    }

    public void setSoNgayDiTre(double soNgayDiTre) {
        this.soNgayDiTre = soNgayDiTre;
    }

    public double getSoGioTangCa() {
        return soGioTangCa;
    }

    public double getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(double ngayCong) {
        this.ngayCong = ngayCong;
    }
    

    public void setSoGioTangCa(double soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

 
}
   