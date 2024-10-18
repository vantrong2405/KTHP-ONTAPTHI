/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 */
public class TheMuon extends SinhVien{
    protected String maPhieuMuon ;
    protected int ngayMuon , hanTra ;
    protected String soHieuSach;

    public TheMuon() {
    }

    public TheMuon(String maPhieuMuon, int ngayMuon, int hanTra, String soHieuSach, String hoTen, int tuoi, String lop) {
        super(hoTen, tuoi, lop);
        this.maPhieuMuon = maPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.soHieuSach = soHieuSach;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(int ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public int getHanTra() {
        return hanTra;
    }

    public void setHanTra(int hanTra) {
        this.hanTra = hanTra;
    }

    public String getSoHieuSach() {
        return soHieuSach;
    }

    public void setSoHieuSach(String soHieuSach) {
        this.soHieuSach = soHieuSach;
    }
    
    public String toString(){
        return super.toString() + ", "+ ", " + maPhieuMuon + ", "+ngayMuon+", "+" "+hanTra+", " +soHieuSach;
    }
    
}