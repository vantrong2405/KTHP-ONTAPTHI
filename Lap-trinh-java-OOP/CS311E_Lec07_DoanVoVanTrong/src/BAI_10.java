import java.util.Scanner;

public class BAI_10 {
	long n;

	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Doan Vo Van Trong");
		System.out.println("Tinh tong cac chu so chan cua 1 so nguyen duong ");
		do {
			System.out.print("Nhap so nguyen >0: ");
            n = kb.nextLong();
		} while (n <= 0);
	}

	long tinhTong(long x) { // 23572  
		long S = 0 , du = 0 ;
		while(x != 0) {
		  du = x % 10 ; // 2
		  if(du % 2 == 0 ) {
			 S = S + du ; 
		  }
		  x = x / 10 ; // 2357
		}
		
		return S ; 
	}
	
	void Output() {
		long S = tinhTong(n);
         System.out.print("Tong = ");
         while(n != 0) {
        	 long du = n % 10 ;
        	 if(du % 2 == 0 ) System.out.print(du+" +");
        	 n = n / 10 ; 
         }
         	
         System.out.println(" = "+S);
	}

	public static void main(String[] args) {
		BAI_10 a = new BAI_10();
		a.Input();
		a.Output();
	}
}
