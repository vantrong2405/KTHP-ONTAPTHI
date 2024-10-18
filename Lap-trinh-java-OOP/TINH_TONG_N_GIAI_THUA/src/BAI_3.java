import java.util.Scanner;

public class BAI_3 {
    long n , S , i ; 
    void Input() {
    	Scanner kb = new Scanner(System.in);
    	System.out.println("Doan Vo Van Trong");
    	System.out.println("Tinh tong S(n) = 1/2! - 2/3! +3/4! - ...");
    	do {
    		System.out.print("nhap n : ");
    		n = kb.nextLong();
    	}while(n <= 0);
    }
    
    long giaiThua(long x) {
    	long S = 1 ;
    	for(int i = 1 ; i<=x ; i++ )
    		S = S * i ; 
    	return S ; 
    }
    
    double tinhTong(long x) {
    	double S = 0 ; 
    	for(int i = 1 ; i<=x ; i++) 
    		S = S + ((i%2==1)?1.0*i:-1.0*i)/giaiThua(i+1);
    	return S ; 
    }
    
    void Output() {
    	System.out.print("S("+n+") = ");
    	for(int i = 1 ; i<n ; i++) {
             if(i%2==1) System.out.print(i+ "/" +(i+1)+ "! - ");
             else       System.out.print(i+ "/" +(i+1)+ "! + ");
    	}
    	System.out.print(n+"/"+(n+1)+"! = ");
    	System.out.println(tinhTong(n));
    }
    public static void main(String[] args) {
		BAI_3 a = new BAI_3();
		a.Input();
		a.Output();
	}
}
