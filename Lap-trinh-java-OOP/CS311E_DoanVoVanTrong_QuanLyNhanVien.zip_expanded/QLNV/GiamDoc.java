/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNV;

/**
 *
 * @author ADMIN
 */
public class GiamDoc extends Nguoi {

    protected double luongGiamDoc = 7000;

    @Override
    protected double phuCap() {
        if (soNgayLam < 22) {
            return 0;
        }
        return 1000;
    }

    @Override
    protected double getThanhTien() {
        if (soNgayLam < 22) {
            return (luongGiamDoc + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) + (soGioTangCa*30);
        } else {

            return (luongGiamDoc + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        }

    }

    public String toString() {
        return "Giam doc: " + super.toString() + ", " + ", " + "Phu cap = " + phuCap() + ", Thanh tien = " + getThanhTien();
    }

    public double getLuongGiamDoc() {
        return luongGiamDoc;
    }

    public void setLuongGiamDoc(double luongGiamDoc) {
        this.luongGiamDoc = luongGiamDoc;
    }

    public GiamDoc() {
    }

    public GiamDoc(String ma, String ten, String ngaySinh, boolean gioiTinh, String chucVu, String soDienThoai, double soNgayLam, double soNgayDiTre, double soGioTangCa) {
        super(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa);
    }

    

    public static void main(String[] args) {
        GiamDoc x = new GiamDoc("001", "Doan vo van trong", "24/05/2003", true, "Giam doc", "00000012", 2, 4, 5);
        System.out.println(x);

    }

}
