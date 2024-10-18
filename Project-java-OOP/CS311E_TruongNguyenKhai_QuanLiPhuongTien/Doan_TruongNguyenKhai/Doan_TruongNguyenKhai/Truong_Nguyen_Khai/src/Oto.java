/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trong
 */
public class Oto extends PhuongTien{
    public double soChoNgoi;
    public String kieuDongCo;

    public Oto() {
    }

    public Oto(double soChoNgoi, String kieuDongCo, String id, String hangSanXuat, String mauXe, double namSanXuat, double giaBan) {
        super(id, hangSanXuat, mauXe, namSanXuat, giaBan);// kế thừa 
        this.soChoNgoi = soChoNgoi;
        this.kieuDongCo = kieuDongCo;
    }

    public double getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(double soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuDongCo() {
        return kieuDongCo;
    }

    public void setKieuDongCo(String kieuDongCo) {
        this.kieuDongCo = kieuDongCo;
    }
    
    public String toString(){
        return "Oto : "+super.toString()+", "+soChoNgoi+", "+kieuDongCo;
    }
    
    public static void main(String[] args) {
        Oto x = new Oto(10, "Manh", "009", "Lambo", "Vang", 2023, 500);
        System.out.println(x);
    }
    
    
    
    
}
