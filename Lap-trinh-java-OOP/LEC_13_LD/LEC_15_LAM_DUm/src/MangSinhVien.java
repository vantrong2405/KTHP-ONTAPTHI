/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */import java.util.ArrayList;
import java.util.Scanner;

public class MangSinhVien {

    private ArrayList<SinhVien> a = new ArrayList<SinhVien>();
    int n;

    public void input() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien >0: ");
        n = kb.nextInt();
        for(int i = 0 ; i<n ; i++){
            System.out.println("Nhap sinh vien thu : "+(i+1));
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

    //cau1
    public void xuatDanhSachSinhVien(String cauDan) {
        System.out.println(cauDan);
        for (SinhVien x : a) {
            System.out.println(x);
        }
    }

    //cau2
    public double tinhDiemTBChung() {
        double S = 0;
        for (SinhVien x : a) {
            S = S + x.getDiemTB();
        }
        return S / a.size();
    }

    //cau3
    public double diemTrungBinhChungTheoGioiTin(boolean gt) {
        double S = 0;
        double dem = 0;
        for (SinhVien x : a) {
            if (x.isGioiTinh() == gt) {
                S = S + x.getDiemTB();
                dem++;
            }
        }
        return S / dem;
    }

    //cau4
    public void loaiSinhVien() {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getDiemTB() < tinhDiemTBChung()) {
                a.remove(a.get(i));
                i--;
            }
        }
    }

    //cau5
    public void sapXepGiamDan() {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).getDiemTB() < a.get(j).getDiemTB()) {
                    SinhVien tam = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, tam);
                }
            }
        }
    }

    //câu 6 quên :)
    public void output() {
        xuatDanhSachSinhVien("a. Danh sach sinh vien : ");
        System.out.println("b. Diem TB chung = "+tinhDiemTBChung());
        System.out.println("c. TB Nam = "+diemTrungBinhChungTheoGioiTin(true));
        System.out.println("TB Nu = "+diemTrungBinhChungTheoGioiTin(false));
        System.out.println("d. Loai SV diem TB <"+tinhDiemTBChung());
        loaiSinhVien();
        xuatDanhSachSinhVien("Danh sach sinh vien sau khi loai : ");
        sapXepGiamDan();
        xuatDanhSachSinhVien("Danh sach sinh vien sau khi sap xep giam dan theo diem");
    }

    public static void main(String[] args) {
        MangSinhVien a = new MangSinhVien();
        a.input();
        a.output();
    }
}
