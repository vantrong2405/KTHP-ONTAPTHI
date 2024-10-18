/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNV;

/**
 *
 * @author ADMIN
 */
public class PhoPhong extends Nguoi {

    protected double luongPhoPhong = 3000;

    @Override
    protected double phuCap() {
        if (soNgayLam < 22) {
            return 0;
        }
        return 700;
    }

    @Override
    protected double getThanhTien() {
        if (soNgayLam < 22) {
            if(soNgayLam < 10){
                luongPhoPhong = 0;
                return (luongPhoPhong + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) + (soGioTangCa*30);
            }
            return (luongPhoPhong + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        } else {

            return (luongPhoPhong + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        }

    }

    public PhoPhong() {
    }

    public PhoPhong(String ma, String ten, String ngaySinh, boolean gioiTinh, String chucVu, String soDienThoai, double soNgayLam, double soNgayDiTre, double soGioTangCa) {
        super(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa);
    }

   

    public double getLuongPhoPhong() {
        return luongPhoPhong;
    }

    public void setLuongPhoPhong(double luongPhoPhong) {
        this.luongPhoPhong = luongPhoPhong;
    }

    public String toString() {
        return "Pho Phong: " + super.toString() + ", " + ", " + "Phu cap = " + phuCap() + ", Thanh tien = " + getThanhTien();
    }

    public static void main(String[] args) {
        PhoPhong x = new PhoPhong("001", "Doan vo van trong", "24/05/2003", true, "Pho Phong","0123912", 2, 4, 5);
        System.out.println(x);

    }
}
