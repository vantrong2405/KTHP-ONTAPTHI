/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNV;

/**
 *
 * @author ADMIN
 */
public class NhanVien extends Nguoi {

    protected double luongNhanVien = 2000;

    @Override
    protected double phuCap() {
        if (soNgayLam < 22) {
            return 0;
        }
        return 600;
    }

    @Override
    protected double getThanhTien() {
        if (soNgayLam < 22) {
            if(soNgayLam < 10){
                luongNhanVien = 0;
                return (luongNhanVien + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) + (soGioTangCa*30);
            }
            return (luongNhanVien + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) + (soGioTangCa*30);
        } else {

            return (luongNhanVien + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        }

    }

    public String toString() {
        return "Nhan vien: " + super.toString() + ", " + ", " + "Phu cap = " + phuCap() + ", Thanh tien = " + getThanhTien();
    }

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String ngaySinh, boolean gioiTinh, String chucVu, String soDienThoai, double soNgayLam, double soNgayDiTre, double soGioTangCa) {
        super(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa);
    }

   

    public double getLuongNhanVien() {
        return luongNhanVien;
    }

    public void setLuongNhanVien(double luongNhanVien) {
        this.luongNhanVien = luongNhanVien;
    }

    public static void main(String[] args) {
        NhanVien x = new NhanVien("001", "Doan vo van trong", "24/05/2003", true, "Nhan vien", "0002321", 2, 4, 5);
        System.out.println(x);
    }

}
