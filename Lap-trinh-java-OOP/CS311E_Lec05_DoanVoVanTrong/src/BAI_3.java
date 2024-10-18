import java.util.Scanner;

public class BAI_3 {
	long n  ;
	double X = 0 ;
	void Input() {
		System.out.println("Doan Vo Van Trong");
		System.out.println("Tinh tong S(n) = 1/2! - 2/3! + 3/4! - ...");
		Scanner kb = new Scanner(System.in);
		do {
			System.out.print("Nhap n>0 : ");
			n = kb.nextLong();
		} while (n < 0 || n == 0 );
	}
    //====//
	double tinhGiaiThua(long x ) {
		long S = 1 ;
		for(int i = 1 ; i<=x ; i++) 
			S = S * i ; 
		return S ; 
	}
	
	double tinhTong(long n ) {// 0 - , 1+
		for(long i = 1 ; i<=n ; i++) {
			if(i % 2 == 0 ) X = X - i/tinhGiaiThua(i+1);
			else X = X + i/tinhGiaiThua(i+1);
		}
		return X ; 
	}
	
	void Output() {
		System.out.print("S(" + n + ") = ");
		for (int i = 1; i < n; i++) {
			if (i % 2 == 1)
				System.out.print(i+"/" + (i+1) + "! - ");
			else
				System.out.print(i+"/" + (i+1) + "! + ");
		}	
		System.out.print(n+"/"+(n+1)+ "! = "+(double)tinhTong(n));
	}
	public static void main(String[] args) {
		BAI_3 a = new BAI_3();
		a.Input();
		a.Output();
	}

}
