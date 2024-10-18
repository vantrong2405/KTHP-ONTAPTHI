/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trong
 */
public class PhuongTien {
    public String id , hangSanXuat ;
    public double namSanXuat , giaBan;
    public String mauXe;

    public PhuongTien(String id, String hangSanXuat, String mauXe, double namSanXuat, double giaBan) {
        this.id = id;
        this.hangSanXuat = hangSanXuat;
        this.mauXe = mauXe;
        this.namSanXuat = namSanXuat;
        this.giaBan = giaBan;
    }

    public PhuongTien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    public double getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(double namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
   
    public String toString(){//hàm này để xuất đối tượng theo toString mọi hàm đèu phải có toString
        return id +", "+hangSanXuat+", "+namSanXuat+", "+mauXe+", "+giaBan;
    }
}
