import java.util.Scanner;

public class BAI_1 {
   long n , S = 1 ; 
   void Input() {
	   System.out.println("Doan Vo Van Trong");
	   System.out.println("Tinh tong n! = 1 * 2 * ... * n");
	   Scanner kb = new Scanner(System.in);
	   do {
		   System.out.print("Nhap n>0: ");
		   n = kb.nextLong();
	   }while(n < 0 || n == 0 );   
   }
   
   long giaiThua(long n) {
	   for(int i = 1 ; i<=n ; i++) 
		   S = S * i ; 
	   return S ;
   }
   
   void Output() {
	   System.out.print(n+"!=");
	   for(int i = 1 ; i<n ; i++) {
		   System.out.print(+i+"*");
	   }
	   System.out.print(n);
	   System.out.print("="+giaiThua(n));
   }
   public static void main(String[] args) {
	BAI_1 a = new BAI_1();
	a.Input();
	a.Output();
}
}
