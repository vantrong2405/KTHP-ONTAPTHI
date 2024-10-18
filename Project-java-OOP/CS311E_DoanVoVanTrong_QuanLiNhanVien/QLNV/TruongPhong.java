/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNV;

/**
 *
 * @author ADMIN
 */
public class TruongPhong extends Nguoi {

    protected double luongTruongPhong = 4000;

    @Override
    protected double phuCap() {
        if (soNgayLam < 22) {
            return 0;
        }
        return 800;
    }

    @Override
    protected double getThanhTien() {
        if (soNgayLam < 22) {
            if(soNgayLam < 10){
                luongTruongPhong = 0;
                return (luongTruongPhong + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) + (soGioTangCa*30);
            }
            return (luongTruongPhong + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        } else {

            return (luongTruongPhong + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        }

    }

    public String toString() {
        return "Truong phong: " + super.toString() + ", " + ", " + "Phu cap = " + phuCap() + ", Thanh tien = " + getThanhTien();
    }

    public double getLuongTruongPhong() {
        return luongTruongPhong;
    }

    public void setLuongTruongPhong(double luongTruongPhong) {
        this.luongTruongPhong = luongTruongPhong;
    }

    public TruongPhong() {
    }

    public TruongPhong(String ma, String ten, String ngaySinh, boolean gioiTinh, String chucVu, String soDienThoai, double soNgayLam, double soNgayDiTre, double soGioTangCa) {
        super(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa);
    }

   

    public static void main(String[] args) {
       TruongPhong x = new TruongPhong("001", "Doan vo van trong", "24/05/2003", true, "Truong Phong", "020020312", 2, 4, 5);
        System.out.println(x);

    }

}
