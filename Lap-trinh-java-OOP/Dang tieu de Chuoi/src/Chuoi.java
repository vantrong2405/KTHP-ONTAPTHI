import java.util.Scanner;

public class Chuoi {
    String chuoi ="";
    int dem = 0 ; 
	void input() {
       Scanner kb = new Scanner(System.in);
       System.out.print("Nhap 1 chuoi : ");
       chuoi = kb.nextLine();//nhap chuoi
       chuoi= chuoi.toLowerCase();//dua ve chu thuong
       String s1 ="" ; 
       String s2 =""; 
       for(int i = 0 ; i<chuoi.length();i++) {
    	   dem++;
    	   if(chuoi.charAt(i) == ' ') {
    		   break;
    	   }
       }
       s1 = chuoi.substring(0 , dem);
       s1 = s1.toUpperCase();//in hoa
       s2 = chuoi.substring(dem,chuoi.length());
       chuoi = s1 + s2 ; 
	}
	
	void output() {
		System.out.println("Chuoi cua ban sau khi in hoa la : "+chuoi);
	}
	
	public static void main(String[] args) {
		Chuoi x = new Chuoi();
		x.input();
		x.output();
	}
}
