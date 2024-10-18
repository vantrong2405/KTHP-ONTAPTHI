/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;
public class MangDiem {
    int n;
    private ArrayList<DiemOxy> a = new ArrayList<DiemOxy>();
    public void input(){
        
        Scanner kb = new Scanner(System.in);
        do{
            System.out.print("Nhap n > 0 : "); n = kb.nextInt();
        }while(n<=0);
        for(int i =1; i<=n;i++){
            System.out.print("Nhap diem thu "+i+" : ");
            int x,y;
            x = kb.nextInt();   y = kb.nextInt();
            DiemOxy z = new DiemOxy(x,y);
            a.add(z);
        }
    }
    public DiemOxy min(){
        DiemOxy c = a.get(0);
        for(int i=1; i<a.size(); i++)
           if(c.modul()>a.get(i).modul())
               c = a.get(i);
        return c;
    }
    public DiemOxy max(){
        DiemOxy c = a.get(0);
        for(int i=1; i<a.size(); i++)
           if(c.modul()<a.get(i).modul())
               c = a.get(i);
        return c;
    }
    public void maxKhoangCach(){
        DiemOxy x = a.get(0), y =a.get(1);
        for(int i=0;i<a.size()-1;i++){
            for(int j = i+1; j<a.size(); j++){
                if(x.khoangCach(y)<a.get(i).khoangCach(a.get(j))){
                    x = a.get(i); y = a.get(j);
                }
                System.out.println("\n 5. Max khoang cach : "+x+"---->"+y+" = "+x.khoangCach(y));
            }
        }
    }
    
//    cau9
    public void tangMoDul(){
        for(int i = 0 ; i<n ; i++){
            for(int j = i + 1 ; j<n ; j++){
                if(a.get(i).modul() > a.get(j).modul()){
                    DiemOxy tam = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, tam);
                }
            }
        }
    }
    
    public void giamMoDul(){
        for(int i = 0 ; i<n ; i++){
            for(int j = i + 1 ; j<n ; j++){
                if(a.get(i).modul() < a.get(j).modul()){
                    DiemOxy tam = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, tam);
                }
            }
        }
    }
    
    public void danhSachCacDiem(String cauDan){
        System.out.println(cauDan);
        for(DiemOxy diem : a){
            System.out.print(diem + " ");
        }
    }
    
    public void output(){
        System.out.println("2. Cac diem trong mang : ");
        for(DiemOxy diem : a){
            System.out.println(diem);
        }
        System.out.println("3. Min : "+min());
        System.out.println("4. Min : "+max());
        maxKhoangCach();
        tangMoDul();
        danhSachCacDiem("9. Danh sach cac diem sau khi sap xep tang dan :");
        giamMoDul();
        danhSachCacDiem("10. Danh sach cac diem sau khi sap xep giam dan :  ");
    }
    public static void main(String[] args) {
        MangDiem a = new MangDiem();
        a.input(); a.output();
    }
}