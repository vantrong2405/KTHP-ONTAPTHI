
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trong
 */
public class MangSinhVien {

    ArrayList<SinhVien> a = new ArrayList<>();
    int n;
    public void input() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Nhap n : ");
        n = kb.nextInt();
        for(int i = 0 ; i<n ; i++){
            nhapThongTinSV();
        }
    }

    public void nhapThongTinSV() {
        Scanner kb = new Scanner(System.in);
        String maSV, hoTen, ngaySinh, queQuan;
        boolean gioiTinh;
        double diem;
        System.out.print("Nhap ma sinh vien : ");
        maSV = kb.nextLine();
        System.out.print("Nhap gioi tinh : ");
        gioiTinh = kb.nextBoolean();
        System.out.print("Nhap diem : ");
        diem = kb.nextDouble();
        System.out.print("Nhap ho ten : ");
        String bkt = kb.nextLine();
        hoTen = kb.nextLine();
        SinhVien x = new SinhVien(maSV, hoTen, gioiTinh, diem);
        a.add(x);
    }

    //cau a
    public void xuatDanhSach(String cauDan) {
        System.out.println(cauDan);
        for (SinhVien x : a) {
            System.out.println(x);
        }
    }

    //cau b
    public double tinhDiemTrungBinhChung() {
        double S = 0, dem = 0;
        for (SinhVien x : a) {
            S = S + x.diemTrungBinh;
            dem++;
        }
        return S / dem;
    }

    //cauc
    public double tinhDTBTheoGioiTinh(boolean gt) {
        double dem = 0, S = 0;
        for (SinhVien x : a) {
            if (x.isGioiTinh() == gt) {
                S = S + x.diemTrungBinh;
                dem++;
            }
        }
        return S / dem;
    }

    //caud
    public void loaiSinhVien() {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getDiemTrungBinh() < tinhDiemTrungBinhChung()) {
                a.remove(i);
                i++;
            }
        }
    }

    //caue
    public void sapXepGiamDan() {//1 3 
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).getDiemTrungBinh() < a.get(j).getDiemTrungBinh()) {
                    SinhVien tam = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, tam);
                }
            }
        }
    }

    public void output() {
        xuatDanhSach("a. Danh sach sinh vien");
        System.out.println("b. Diem TB chung = "+tinhDiemTrungBinhChung());
        System.out.println("c. Diem TB nam = "+tinhDTBTheoGioiTinh(true));
        System.out.println("Diem TB nu = "+tinhDTBTheoGioiTinh(false));
        loaiSinhVien();
        xuatDanhSach("d. Danh sach sinh vien sau khi loai");
        sapXepGiamDan();
        xuatDanhSach("e. Danh sach sinh vien sau khi sap xep giam dan theo diem");
    }

    public static void main(String[] args) {
        MangSinhVien x = new MangSinhVien();
        x.input();
        x.output();
    }
}
