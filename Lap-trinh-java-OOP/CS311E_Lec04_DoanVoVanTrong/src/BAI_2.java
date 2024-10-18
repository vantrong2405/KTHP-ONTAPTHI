import java.util.Scanner;

public class BAI_2 {
   long a , tong  , layso; 
   void Input() {
	   Scanner kb = new Scanner(System.in);
	   System.out.println("Nhap 1 so nguyen hang van ( 5 so ) : " );
	   a = kb.nextLong();
   }
   
   void Output() {
	   if(a >=10000 && a<=99999) {
		   while(a != 0) {
			   layso = a % 10;
		        tong += layso;
		        a /= 10;
		   }
		   System.out.println("Tong cua 5 so nguyen la :"+tong );
	   }else  System.exit(0);
	   
   }
   
   public static void main(String[] args) {
	BAI_2 a = new BAI_2();
	a.Input();
	a.Input();
}
}
