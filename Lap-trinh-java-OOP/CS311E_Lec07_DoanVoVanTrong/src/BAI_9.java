import java.util.Scanner;

public class BAI_9 {
  long n ;
  void Input() {
	  System.out.println("Tinh tong cac chu so cua 1 so nguyen duong");
	  Scanner kb = new Scanner(System.in);
	  do {
		  System.out.print("Nhap so nguyen > 0 : ");
		  n = kb.nextLong();
	  }while(n<=0);
  }
  
  long tinhTongCacChuSo(long x) {
	  long  S = 0 , du = 0 ;   
	  while( x > 0) {
		  du = x % 10 ; 
		  S = S + du ; 
		  x = x / 10 ; 
	  }
	  return S ;
  }
  
  void Output() {
	  long x = tinhTongCacChuSo(n);
	  System.out.print("Tong = ");
	  Label :// nhãn
	  while(n>0) {
		  long du = n % 10 ; 
		  n = n / 10 ; 
		  System.out.print(du);
		  if(n==0) break Label ;	 
		  System.out.print(" + ");
	  }
       System.out.println(" = "+x);
  }
  public static void main(String[] args) {
	BAI_9 a = new BAI_9();
	a.Input();
	a.Output();
}
}
