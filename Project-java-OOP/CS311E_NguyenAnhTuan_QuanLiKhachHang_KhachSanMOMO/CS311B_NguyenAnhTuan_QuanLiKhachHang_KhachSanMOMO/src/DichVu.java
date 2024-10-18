/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311_finalexam_nguyenanhtuan;
public class DichVu extends KhachHang {
    private boolean loaiDichVu;

    public DichVu() {
    }

    public DichVu(boolean loaiDichVu, String maDinhDanh, String hoTen, boolean gioiTinh, String queQuan, String ngayDen, String ngayDi, double soLuong, double donGia) {
        super(maDinhDanh, hoTen, gioiTinh, queQuan, ngayDen, ngayDi, soLuong, donGia);
        this.loaiDichVu = loaiDichVu;
    }

    public boolean isLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(boolean loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
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
        return "DichVu{" + super.toString()+ ",loaiDichVu: "+(isLoaiDichVu()?"Binh thuong":"Cao cap")+" Thanh Tien ="+tinhTT();
    }
    
    public static void main(String[] args) {
        DichVu x = new DichVu(false,"D25341","Ho Van Dang Khoa",true,"Quang Nam","12/1/2020","24/1/2020",1,2000000);
        System.out.println(x);
    }

    @Override
    public Double tinhTT() {
        if(isLoaiDichVu()){
            return getSoLuong()*getDonGia();
        }else{
            return getSoLuong()*getDonGia()*0.5;
        }
    }
}
