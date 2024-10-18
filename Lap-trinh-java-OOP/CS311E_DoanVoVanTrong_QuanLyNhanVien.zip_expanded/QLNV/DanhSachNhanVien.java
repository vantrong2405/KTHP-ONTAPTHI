/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNV;

import java.awt.Component;
import java.io.File;
import java.io.PrintStream;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DanhSachNhanVien {

    ArrayList<Nguoi> a = new ArrayList<>();


    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (f.exists()) {
                System.out.println("Da mo duoc file");
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner line = new Scanner(read.nextLine());
                    String ma = "", ten = "", ngaySinh = "";
                    boolean gioiTinh = false;
                    String chucVu = "", soDienThoai = "";
                    double soNgayLam, soNgayDiTre, soGioTangCa;
                    ma = line.next();
                    while (!line.hasNextBoolean()) {
                        ten = ten + line.next() + " ";
                    }

                    gioiTinh = line.nextBoolean();
                    ngaySinh = line.next();
                    while (!line.hasNextDouble()) {
                        chucVu = chucVu + line.next() + " ";
                    }

                    soDienThoai = line.next();
                    soNgayLam = line.nextDouble();
                    soNgayDiTre = line.nextDouble();
                    soGioTangCa = line.nextDouble();
                    String chucVu1;
                    chucVu1 = chucVu.substring(0, 2);//2 ky tu 
                    if (chucVu1.trim().equalsIgnoreCase("Th".trim())) {
                        a.add(new ThucTapSinh(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa));
                    } else if (chucVu1.trim().equalsIgnoreCase("Nh".trim())) {
                        a.add(new NhanVien(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa));
                    } else if (chucVu1.trim().equalsIgnoreCase("Ph".trim())) {
                        a.add(new PhoPhong(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa));
                    } else if (chucVu1.trim().equalsIgnoreCase("Tr".trim())) {
                        a.add(new TruongPhong(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa));
                    } else if (chucVu1.trim().equalsIgnoreCase("Gi".trim())) {
                        a.add(new GiamDoc(ma, ten, ngaySinh, gioiTinh, chucVu, soDienThoai, soNgayLam, soNgayDiTre, soGioTangCa));
                    }
                }
            } else {
                System.out.println("file loi!");
            }
        } catch (Exception e) {

        }
    }

    public ArrayList<Nguoi> getA() {
        return a;
    }

    public void setA(ArrayList<Nguoi> a) {
        this.a = a;
    }

    public boolean them(Nguoi y) {
        for (Nguoi x : a) {
            if (x.getMa().trim().equalsIgnoreCase(y.getMa())) {
                return false;
            }
        }
        a.add(y);
        return true;
    }
    
    public void xuatDanhSach(String cauDan) {
        System.out.println(cauDan);
        for (Nguoi x : a) {
            System.out.println(x);
        }
    }
    
       

    //chuc nang them moi 
    //cau2
    public void ghiFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (!f.exists()) {
                Component rootPane = null;
                PrintStream out = new PrintStream(f);
                for (Nguoi x : a) {
                    out.println(x);
                }
                JOptionPane.showMessageDialog(rootPane, "Luu thanh cong ");
                out.close();
            } else {
                System.out.println("File da ton tai ");
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "File đã tồn tại ko thể lưu ");
            }
        } catch (Exception e) {

        }
    }

    //sap xep theo luong 
    public void sapXepTheoLuongGiamDan() {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).getThanhTien() < a.get(j).getThanhTien()) {
                    Nguoi x = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, x);
                }
            }
        }

    }
     public void sapXepTheoLuongTangDan() {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).getThanhTien() > a.get(j).getThanhTien()) {
                    Nguoi x = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, x);
                }
            }
        }

    }

    //thanh tien lon nhat
    public Nguoi thanhTienLonNhat() {
        Nguoi y = a.get(0);
        for (Nguoi x : a) {
            if (x.getThanhTien() > y.getThanhTien()) {
                y = x;
            }
        }
        return y;
    }

    //timkiem
    public Nguoi timKiemTheoMa(String ma) {
        Nguoi z = null;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getMa().trim().equalsIgnoreCase(ma.trim())) {
                z = a.get(i);
            }
        }
        return z;
    }

    public void output() {
        Scanner kb = new Scanner(System.in);
        xuatDanhSach("1. Danh sach nhan vien ");
        sapXepTheoLuongGiamDan();
        xuatDanhSach("2. Danh sach nhan vien sau khi sap xep : ");
        System.out.println("Nguoi co thanh tien lon nhat : " + thanhTienLonNhat());
        System.out.println("3. Tim kiem theo ma : ");
        System.out.print("Nhap ma : ");
        String ma1 = kb.nextLine();
        System.out.println("Nhan vien duoc tim thay la : " + timKiemTheoMa(ma1));//de ben ngoai no k ăn giá trị
    

    }

    public static void main(String[] args) {
        DanhSachNhanVien z = new DanhSachNhanVien();
        z.docFile("D:\\QLNV.txt");
        z.output();
    }
}
