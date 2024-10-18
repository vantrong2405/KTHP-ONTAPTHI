/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311_finalexam_nguyenanhtuan;
public class ThuePhong extends KhachHang {
    public String loaiPhong;

    public ThuePhong() {
    }

    public ThuePhong(String loaiPhong, String maDinhDanh, String hoTen, boolean gioiTinh, String queQuan, String ngayDen, String ngayDi, double soLuong, double donGia) {
        super(maDinhDanh, hoTen, gioiTinh, queQuan, ngayDen, ngayDi, soLuong, donGia);
        this.loaiPhong = loaiPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
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
        return "ThuePhong{"+super.toString() + ", loaiphong: " + loaiPhong +",Thanh Tien= "+tinhTT();
    }
    
    @Override
    public Double tinhTT(){
       if(getLoaiPhong().equals("SingleRoom")){ // đây là phòng có 1 giường cho một người.
           return getSoLuong()*getDonGia()*2.5;
       }else if(getLoaiPhong().equals("DoubleRoom")){ // đây là phòng có 1 giường cho 2 người.
           return getSoLuong()*getDonGia()*2.2;
       }else if(getLoaiPhong().equals("TwinRoom")){ // đây là phòng có 2 giường cho 2 người.
           return getSoLuong()*getDonGia()*1.5;
    }else if(getLoaiPhong().equals("TripleRoom")){ // đây là phòng có 3 giường cho 3 người( có thể có 2 giường đơn và 1 giường đôi)..
           return getSoLuong()*getDonGia()*1.2;
    }else// phòng Quad Room: 2 giường cho 4 khách, 2 khách nằm chung 1 giường.
        return getSoLuong()*getDonGia();
    }
    
}

 