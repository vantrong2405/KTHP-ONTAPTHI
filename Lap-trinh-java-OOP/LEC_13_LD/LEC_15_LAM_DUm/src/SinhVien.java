public class SinhVien {
    private String maSV, hoTen;
    private boolean gioiTinh;
    private double diemTB;
    public SinhVien() {
    }
    public String getMaSV() {
        return maSV;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
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
    public double getDiemTB() {
        return diemTB;
    }
    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }
    public SinhVien(String maSV, String hoTen, boolean gioiTinh, double diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemTB = diemTB;
    }
    @Override
    public String toString() {
        return maSV + ","+ hoTen + ", "+ (gioiTinh?"Nam" :"Nu") + ", "+ diemTB +", "+xepLoai();
    }
    
    public String xepLoai(){
        if(getDiemTB() < 3.5) return "Kem";
        if(getDiemTB() < 5) return "Yeu";
        if(getDiemTB() < 6.5) return "Trung Binh";
        if(getDiemTB() < 8) return "Kha";
        if(getDiemTB() < 9) return "Gioi";
        return "Xuat sac";
    }
    
    
    public static void main(String[] args) {
        SinhVien a = new SinhVien("sv001","Le Van Hung",true,8.0);
        System.out.println(a);
    }
}