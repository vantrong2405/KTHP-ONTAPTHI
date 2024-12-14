/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QLNV;

/**
 *
 * @author Tai
 */
public class QuanLyNhanVien_NguyenThanhDuoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DanhSachNhanVien dsnv= new DanhSachNhanVien();
        dsnv.docFile("D://QLNV.txt");
        dsnv.ghiFile("D://Output.txt");
    }
}
