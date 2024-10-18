

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class GIO_PHUT_GIAY {

    long S1, S2, M1, M2, H1, H2;

    void Input() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Chuong trinh cong 2 moc thoi gian");
        System.out.println("Nhap moc thoi gian 1 : ");
        System.out.print("Nhap Gio : ");
        H1 = kb.nextLong();
        System.out.print("Nhap Phut : ");
        M1 = kb.nextLong();
        System.out.print("Nhap Giay : ");
        S1 = kb.nextLong();
        
        System.out.println("Nhap moc thoi gian 2 : ");
        System.out.print("Nhap Gio : ");
        H2 = kb.nextLong();
        System.out.print("Nhap Phut : ");
        M2 = kb.nextLong();
        System.out.print("Nhap Giay : ");
        S2 = kb.nextLong();
    }
    
    long tongGiay(){
        long Giay ; 
        Giay = S1 + S2 ; 
        while(Giay >= 60){
            Giay = Giay - 60 ; 
        }
        return Giay ; 
    }
    
    long tongPhut(){
        long Phut ;
        long Giay = S1 + S2 ; 
        Phut = M1 + M2 ; 
        while(Giay >= 60){
            Phut = Phut + 1 ;
            Giay = Giay - 60 ; 
        }
        
        while(Phut >= 60){
            Phut = Phut - 60 ; 
        }
        return Phut ; 
    }
    
    long tongGio(){
        long Gio ; 
        long Phut = M1 + M2 ;
        long Giay = S1 + S2 ; 
        Gio = H1 + H2 ; 
        while(Giay >=60) {
        	Phut = Phut + 1 ;
        	Giay = Giay - 60 ; 
        }
        
        while(Phut >=60) {
        	Gio = Gio + 1 ; 
        	Phut = Phut - 60 ; 
        }
        Gio = Gio % 12 ; 
        return Gio ; 
    }
    void Output(){
        System.out.println("Moc 1 : "+H1+"h: "+M1+"m: "+S1+"s");
        System.out.println("Moc 2 : "+H2+"h: "+M2+"m: "+S2+"s");
        System.out.print("Ket qua : "+tongGio()+"h: ");
        if(tongPhut() >= 0 && tongPhut() <=9) 
        	System.out.print("0"+tongPhut()+"m: ");
        else 
        	System.out.print(tongPhut()+"m: ");
         
        if(tongGiay() >=0 && tongGiay()<=9) 
        	System.out.print("0"+tongGiay()+"s ");
        else 
        	System.out.print(tongGiay()+"s ");
        
  
    }

    public static void main(String[] args) {
        GIO_PHUT_GIAY a = new GIO_PHUT_GIAY();
        a.Input();
        a.Output();
    }
}
