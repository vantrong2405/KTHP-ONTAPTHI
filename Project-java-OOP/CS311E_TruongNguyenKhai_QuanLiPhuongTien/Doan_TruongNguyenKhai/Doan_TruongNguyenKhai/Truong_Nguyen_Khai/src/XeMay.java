/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trong
 */
public class XeMay extends PhuongTien{
    public String congSuat ;

    public XeMay() {
    }

    public XeMay(String congSuat, String id, String hangSanXuat, String mauXe, double namSanXuat, double giaBan) {
        super(id, hangSanXuat, mauXe, namSanXuat, giaBan);
        this.congSuat = congSuat;
    }
    

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }
    
    public String toString(){
        return "Xe may: "+super.toString()+", "+congSuat;
    }
    
    public static void main(String[] args) {
        XeMay u = new XeMay("Manh", "2", "Sirius", "hong canh xen", 2019, 2900);
        System.out.println(u);
    }
    
}
