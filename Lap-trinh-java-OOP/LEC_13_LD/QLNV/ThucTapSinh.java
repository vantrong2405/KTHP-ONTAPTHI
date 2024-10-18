/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNV;

/**
 *
 * @author ADMIN
 */
public class ThucTapSinh extends Nguoi {
  protected double luongThucTap = 1000;

    @Override
    protected double phuCap() {
        if (soNgayLam < 22) {
            return 0;
        }
        return 400;
    }

    @Override
    protected double getThanhTien() {
        if (soNgayLam < 22) {
            if(soNgayLam < 10){
                luongThucTap = 0;
                return (luongThucTap + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) + (soGioTangCa*30);
            }
            return (luongThucTap + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        } else {

            return (luongThucTap + phuCap() / ngayCong * soNgayLam) - (soNgayDiTre * 10) +(soGioTangCa*30);
        }

    }

    public double getLuongThucTap() {
        return luongThucTap;
    }

    public void setLuongThucTap(double luongThucTap) {
        this.luongThucTap = luongThucTap;
    }

    

    public ThucTapSinh() {
    }

    public ThucTapSinh(String ma, String ten, String ngaySinh, boolean gioiTinh, String chucVu, String soDienThoai, double soNgayLam, double soNgayDiTre, double soGioTangCa) {
        super(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa);
    }

   
    
    public String toString(){
        return "Thuc tap sinh: "+super.toString()+", "+"Phu cap = "+(int)phuCap()+", Thanh tien = "+getThanhTien();
    }
    
    public static void main(String[] args) {
        ThucTapSinh x = new ThucTapSinh( "001", "Doan vo van trong", "24/05/2003" , true ,"Thuc tap sinh","020020312", 22 , 4, 5);
        System.out.println(x);
    }
            
    
    

}
