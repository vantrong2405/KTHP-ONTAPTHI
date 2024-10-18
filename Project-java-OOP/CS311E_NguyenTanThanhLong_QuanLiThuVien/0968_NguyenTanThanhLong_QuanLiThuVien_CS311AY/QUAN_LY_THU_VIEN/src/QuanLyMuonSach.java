/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class QuanLyMuonSach {

    ArrayList<TheMuon> a = new ArrayList<>();

    public ArrayList<TheMuon> getA() {
        return a;
    }

    public void setA(ArrayList<TheMuon> a) {
        this.a = a;
    }

    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (f.exists()) {
                System.out.println("Da mo dc file");
                Scanner read = new Scanner(f);
                while (read.hasNextLine()) {
                    Scanner line = new Scanner(read.nextLine());
//                    Sinh vien 
                    String hoTen = "";
                    int tuoi;
                    String lop = "";
                    //Muon sach
                    String maPhieuMuon = "";
                    int ngayMuon, hanTra;
                    String soHieuSach = "";
                    maPhieuMuon = line.next();
                    ngayMuon = line.nextInt();
                    hanTra = line.nextInt();
                    soHieuSach = line.next();
                    while (!line.hasNextInt()) {
                        hoTen = hoTen + line.next() + " ";
                    }
                    tuoi = line.nextInt();
                    lop = line.next();
                    a.add(new TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, hoTen, tuoi, lop));
                }
            }
        } catch (Exception e) {
            System.out.println("file ko ton tai");
            e.printStackTrace(); // Handle exceptions appropriately in your application
        }
    }

    public void outPut(String cauDan) {
        for (TheMuon x : a) {
            System.out.println(x);
        }
    }

    public boolean them(TheMuon y) {
        for (TheMuon x : a) {
            if (x.getMaPhieuMuon().equalsIgnoreCase(y.getMaPhieuMuon())) {
                return false;
            }
        }
        a.add(y);
        return true;
    }

    public boolean xoaTheoMa(String ma) {
        for (TheMuon x : a) {
            if (x.getMaPhieuMuon().equalsIgnoreCase(ma.trim())) {
                a.remove(x);
                return true; //xoa duoc
            }
        }
        return false; //ko co ma de xoa
    }

    public void thoatChuongTrinh() {
        System.exit(0);
    }

    public static void main(String[] args) {
        QuanLyMuonSach e = new QuanLyMuonSach();
        e.docFile("D:\\muonSach.txt");
        e.outPut("Xuat");
    }
}
