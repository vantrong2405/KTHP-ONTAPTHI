import java.util.Scanner;

public class GIAI_PT_BAC_1 {
	long a , b ; 
	//ax + b = 0
	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Nhap a : ");
		a = kb.nextLong();
		System.out.println("Nhap b : ");
		b = kb.nextLong();
	}
	
	void Output() {
		System.out.println((int)a+ "x" +((b>0)?"+":" ")+(int)b+" = 0 ");
		if(a == 0 && b == 0 ) {
			System.out.println("Vo so nghiem ");
		}else if(a == 0 && b <= 0) {
			System.out.println("Vo nghiem ");
		}else {
			System.out.println("X = "+(1.0*b/a));
		}
		
	}
  public static void main(String[] args) {
	  GIAI_PT_BAC_1 a = new GIAI_PT_BAC_1();
	  a.Input();
	  a.Output();
}
}
 


























