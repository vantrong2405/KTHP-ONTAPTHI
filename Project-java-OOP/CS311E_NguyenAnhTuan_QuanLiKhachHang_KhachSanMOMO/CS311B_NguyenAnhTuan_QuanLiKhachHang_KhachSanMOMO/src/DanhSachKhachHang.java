/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311_finalexam_nguyenanhtuan;

import java.awt.Component;
import java.io.File;
import java.io.PrintStream;
import java.util.*;
import javax.swing.JOptionPane;

public class DanhSachKhachHang {

    ArrayList<KhachHang> a = new ArrayList<KhachHang>();

    public void docFile(String tenfile) {
        try {
            File f = new File(tenfile);
            if (f.exists()) {
                System.out.println("Da mo duoc file");
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner line = new Scanner(read.nextLine());
                    String ma = "", ht = "", quequan = "";
                    boolean gt;
                    String ngayden, ngaydi;
                    double sl, dg;
                    boolean dv;
                    String lp = "";
                    ma = line.next();
                    String ma1 = ma.substring(0, 1);
                    if (ma1.trim().equalsIgnoreCase("D".trim())) {
                        while (!line.hasNextBoolean()) {
                            ht = ht + line.next() + " ";
                        }
                        gt = line.nextBoolean();
                        while (!line.hasNextDouble()) {
                            quequan = quequan + line.next() + " ";
                        }
                        sl = line.nextDouble();
                        ngayden = line.next();
                        ngaydi = line.next();
                        dv = line.nextBoolean();
                        lp = line.next();
                        dg = line.nextDouble();
                        a.add(new DichVu(dv, ma, ht, gt, quequan, ngayden, ngaydi, sl, dg));

                    } else {
                        while (!line.hasNextBoolean()) {
                            ht = ht + line.next() + " ";
                        }
                        gt = line.nextBoolean();
                        while (!line.hasNextDouble()) {
                            quequan = quequan + line.next() + " ";
                        }
                        sl = line.nextDouble();
                        ngayden = line.next();
                        ngaydi = line.next();
                        dv = line.nextBoolean();
                        lp = line.next();
                        dg = line.nextDouble();
                        a.add(new ThuePhong(lp, ma, ht, gt, quequan, ngayden, ngaydi, sl, dg));
                    }
                }
            } else {
                System.out.println("Ko ton tai file");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ghiFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (!f.exists()) {
                Component rootPane = null;
                PrintStream out = new PrintStream(f);
                for (KhachHang x : a) {
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

    public void xuat(String cauDan) {
        System.out.println(cauDan);
        for (KhachHang x : a) {
            System.out.println(x);
        }
    }

    public ArrayList<KhachHang> getA() {
        return a;
    }

    public void setA(ArrayList<KhachHang> a) {
        this.a = a;
    }

    public void lietKe() {
        System.out.println("\n2.DS khach Hang Thue Phong: ");
        for (KhachHang x : a) {
            if (x instanceof ThuePhong) {
                System.out.println(x);
            }
        }

        System.out.println("DS khach Hang Thue Dich Vu: ");
        for (KhachHang x : a) {
            if (x instanceof DichVu) {
                System.out.println(x);
            }
        }
    }

    public boolean them(KhachHang y) {
        for (KhachHang x : a) {
            if (x.getMaDinhDanh().equalsIgnoreCase(y.getMaDinhDanh())) {
                return false;
            }
        }
        a.add(y);
        return true;
    }

    public KhachHang timTheoMaHD(String ma) {
        for (KhachHang x : a) {
            if (x.getMaDinhDanh().equalsIgnoreCase(ma)) {
                return x;
            }
        }
        return null;
    }

    public double tongHDDichVu() {
        double s = 0;
        for (KhachHang x : a) {
            if (x.getMaDinhDanh().charAt(0) == 'D') {
                s = s + x.tinhTT();
            }
        }
        return s;
    }

    public double tongHDKhachHang() {
        double s = 0;
        for (KhachHang x : a) {
            if (x.getMaDinhDanh().charAt(0) == 'K') {
                s = s + x.tinhTT();
            }
        }
        return s;
    }

    public void output() {
        Scanner kb = new Scanner(System.in);
        xuat("Danh sach doc tu file");
        lietKe();
        System.out.println("Tong HD Dich Vu:  " + tongHDDichVu());
        System.out.println("Tong HD Khach Hang: " + tongHDKhachHang());
        System.out.print("\n4.Xoa hoa don theo ma\n\t NHap ma can xoa: ");
        String ma = kb.nextLine();
        timTheoMaHD(ma);
        xuat("\n5.DSHH sau khi tim la: " + ma);
    }

    public static void main(String[] args) {
        DanhSachKhachHang x = new DanhSachKhachHang();
        x.docFile("D:\\QuanLiKhachHang.txt");
        x.output();
    }
}
