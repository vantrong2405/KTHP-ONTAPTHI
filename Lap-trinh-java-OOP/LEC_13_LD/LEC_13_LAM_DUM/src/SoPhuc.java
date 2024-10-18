
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trong
 */
public class SoPhuc {

    public int thuc, ao;

    public SoPhuc() {
    }

    public SoPhuc(int thuc, int ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public int getThuc() {
        return thuc;
    }

    public void setThuc(int thuc) {
        this.thuc = thuc;
    }

    public int getAo() {
        return ao;
    }

    public void setAo(int ao) {
        this.ao = ao;
    }

    public String toString() {
        if (ao < 0) {
            return "(" + thuc + (ao < 0 ? " - " : " + ") + "i" + (ao < 0 ? -ao : ao) + ")";
        }
        return "(" + thuc + (ao >= 0 ? " + " : "") + "i" + ao + ")";
    }

    public SoPhuc cong(SoPhuc x) {
        SoPhuc z = new SoPhuc();
        z.thuc = thuc + x.thuc;
        z.ao = ao + x.ao;
        return z;
    }

    public SoPhuc tru(SoPhuc x) {
        SoPhuc z = new SoPhuc();
        z.thuc = thuc - x.thuc;
        z.ao = ao - x.ao;
        return z;
    }

    public SoPhuc nhan(SoPhuc x) {
        SoPhuc z = new SoPhuc();
        z.thuc = (thuc * x.thuc + ao * x.ao);
        z.ao = (thuc * x.ao + ao * x.thuc);
        return z;
    }

    public SoPhuc chia(SoPhuc x) {
        SoPhuc z = new SoPhuc();
        z.thuc = (thuc * x.thuc - ao * x.ao);
        double soAo = ((ao * x.thuc - thuc * x.ao) / (Math.pow(x.thuc, 2) - Math.pow(x.ao, 2)));
//        z.ao = ((ao * x.thuc - thuc * x.ao) / (Math.pow(x.thuc, 2) - Math.pow(x.ao, 2)));
        z.ao = (int) soAo;
        return z;
    }

    public void nhapSoPhuc(String cauDan) {
        Scanner kb = new Scanner(System.in);
        System.out.println(cauDan);
        System.out.print("Thuc: ");
        thuc = kb.nextInt();
        System.out.print("Ao: ");
        ao = kb.nextInt();
    }

    public static void main(String[] args) {
        SoPhuc x = new SoPhuc();
        SoPhuc y = new SoPhuc();
        SoPhuc z = new SoPhuc();
        x.nhapSoPhuc("Nhap so phuc 1: ");
        y.nhapSoPhuc("nhap so phuc 2: ");
        z = x.cong(y);
        System.out.println(x + "+" + y + " = " + z);
        z = x.tru(y);
        System.out.println(x + "-" + y + " = " + z);
        z = x.nhan(y);
        System.out.println(x + "*" + y + " = " + z);
        z = x.chia(y);
        System.out.println(x + "/" + y + " = " + z);

    }

}
