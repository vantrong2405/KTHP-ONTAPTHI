/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trong
 */
public class XeTai extends PhuongTien{
    public String trongTai;

    public XeTai(String trongTai, String id, String hangSanXuat, String mauXe, double namSanXuat, double giaBan) {
        super(id, hangSanXuat, mauXe, namSanXuat, giaBan);
        this.trongTai = trongTai;
    }

    public XeTai() {
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    public String toString(){
        return "Xe Tai : "+super.toString()+", "+trongTai;
    }
    
    
    
    public static void main(String[] args) {
        XeTai o = new XeTai("1000kg", "009", "ok", "vang", 2002, 99999);
        System.out.println(o);
    }
}
