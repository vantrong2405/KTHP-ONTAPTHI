
import java.awt.Component;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trong
 */
public class QLPTGT {

    ArrayList<PhuongTien> a = new ArrayList<>();

    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (f.exists()) {
                System.out.println("Da mo duoc file");
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner line = new Scanner(read.nextLine());
                    //      thuoc tinh chung
                    String id, hangSanXuat = "";
                    double namSanXuat, giaBan;
                    String mauXe;
                    id = line.next();
                    String batKyTu = id.substring(0, 1);
                    if (batKyTu.trim().equalsIgnoreCase("o".trim())) {
                        double soChoNgoi;
                        String kieuDongCo = "";
                        hangSanXuat = line.next();
                        namSanXuat = line.nextDouble();
                        giaBan = line.nextDouble();
                        mauXe = line.next();
                        while (!line.hasNextDouble()) {
                            kieuDongCo = kieuDongCo + line.next() + " ";
                        }
                        soChoNgoi = line.nextDouble();
                        a.add(new Oto(soChoNgoi, kieuDongCo, id, hangSanXuat, mauXe, namSanXuat, giaBan));
                    } else if (batKyTu.trim().equalsIgnoreCase("m".trim())) {
                        String congSuat = "";
                        hangSanXuat = line.next();
                        namSanXuat = line.nextDouble();
                        mauXe = line.next();
                        while (!line.hasNextDouble()) {
                            congSuat = congSuat + line.next() + " ";
                        }
                        giaBan = line.nextDouble();
                        a.add(new XeMay(congSuat, id, hangSanXuat, mauXe, namSanXuat, giaBan));
                    } else {
                        String trongTai;
                        while (!line.hasNextDouble()) {
                            hangSanXuat = hangSanXuat + line.next() + " ";
                        }
                        namSanXuat = line.nextDouble();
                        giaBan = line.nextDouble();
                        mauXe = line.next();
                        trongTai = line.next();
                        a.add(new XeTai(trongTai, id, hangSanXuat, mauXe, namSanXuat, giaBan));
                    }
                }

            } else {
                System.out.println("File khong ton tai");
            }
        } catch (Exception e) {
        }
    }

    public void themLoaiXe() {
        Scanner kb = new Scanner(System.in);
        String id, hangSanXuat = "";
        double namSanXuat, giaBan;
        String mauXe;
        System.out.print("Nhap id : ");
        id = kb.nextLine();

        String batKyTu = id.substring(0, 1);
        if (batKyTu.trim().equalsIgnoreCase("o".trim())) {
            double soChoNgoi;
            String kieuDongCo = "";
            System.out.print("Nhap hang san xuat : ");
            hangSanXuat = kb.nextLine();
            System.out.print("Nhap nam san xuat : ");
            namSanXuat = kb.nextDouble();
            System.out.print("Nhap gia ban : ");
            giaBan = kb.nextDouble();
            System.out.print("Nhap mau xe : ");
            String bkt = kb.nextLine();
            mauXe = kb.nextLine();
            System.out.print("Nhap so cho ngoi : ");
            soChoNgoi = kb.nextDouble();
            System.out.print("Nhap kieu dong co : ");
            String bkt1 = kb.nextLine();
            kieuDongCo = kb.nextLine();
            a.add(new Oto(soChoNgoi, kieuDongCo, id, hangSanXuat, mauXe, namSanXuat, giaBan));
        } else if (batKyTu.trim().equalsIgnoreCase("m".trim())) {
            String congSuat = "";
            System.out.print("Nhap hang san xuat : ");
            hangSanXuat = kb.nextLine();
            System.out.print("Nhap nam san xuat : ");
            namSanXuat = kb.nextDouble();
            System.out.print("Nhap gia ban : ");
            giaBan = kb.nextDouble();
            String bkt = kb.nextLine();
            System.out.print("Nhap mau xe : ");
            mauXe = kb.nextLine();
            System.out.print("Nhap cong suat : ");
            congSuat = kb.nextLine();
            a.add(new XeMay(congSuat, id, hangSanXuat, mauXe, namSanXuat, giaBan));
        } else {
            String trongTai;
            System.out.print("Nhap hang san xuat : ");
            hangSanXuat = kb.nextLine();
            System.out.print("Nhap nam san xuat : ");
            namSanXuat = kb.nextDouble();
            System.out.print("Nhap gia ban : ");
            giaBan = kb.nextDouble();
            System.out.print("Nhap mau xe : ");
            String bkt = kb.nextLine();
            mauXe = kb.nextLine();
            System.out.print("Nhap trong tai(kg) : ");
            trongTai = kb.nextLine();
            a.add(new XeTai(trongTai, id, hangSanXuat, mauXe, namSanXuat, giaBan));
        }
    }

    public void xoaTheoID(String ma) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().trim().equalsIgnoreCase(ma.trim())) {
                a.remove(a.get(i));
                i--;
            }
        }
    }

    public void timPhuongTien(String hangSx, String mau) {
        for (PhuongTien x : a) {
            if (x.getHangSanXuat().trim().equalsIgnoreCase(hangSx.trim())
                    && x.getMauXe().trim().equalsIgnoreCase(mau.trim())) {
                System.out.println(x);
            }
        }
    }

    public void thoatChuongTrinh() {
        System.exit(0);
    }

//    xuatDanhSach
    public void xuatDanhSach(String cauDan) {
        System.out.println(cauDan);
        for (PhuongTien x : a) {
            System.out.println(x);
        }
    }

    public void output() {
        Scanner kb = new Scanner(System.in);
        xuatDanhSach("1. Danh sach phuong tien sau khi doc file : ");
        System.out.println("2. Them cac loai phuong tien : ");
        themLoaiXe();
        xuatDanhSach("Danh sach cac loai xe sau khi them : ");
        System.out.println("3. Xoa theo id : ");
        System.out.print("Nhap id can xoa : ");
        String ma1 = kb.nextLine();
        xoaTheoID(ma1);
        xuatDanhSach("Danh sach cac loai phuong tien sau khi xoa : ");
        System.out.println("4. Tim cac loai phuong tien theo hang san xuat , mau : ");
        System.out.print("Nhap hang san xuat : ");
        String hsx1 = kb.nextLine();
        System.out.print("Nhap mau : ");
        String mau1 = kb.nextLine();
        timPhuongTien(hsx1, mau1);

        thoatChuongTrinh();
    }

    public ArrayList<PhuongTien> getA() {
        return a;
    }

    public void setA(ArrayList<PhuongTien> a) {
        this.a = a;
    }

    public void ghiFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (!f.exists()) {
                Component rootPane = null;
                PrintStream out = new PrintStream(f);
                for (PhuongTien x : a) {
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

    public boolean them(PhuongTien y) {
        for (PhuongTien x : a) {
            if (x.getId().trim().equalsIgnoreCase(y.getId().trim())) {
                return false;
            }
        }
        a.add(y);
        return true;
    }

    public static void main(String[] args) {
        QLPTGT x = new QLPTGT();
        x.docFile("D://QuanLiPhuongTien.txt");
        x.output();
    }
}
