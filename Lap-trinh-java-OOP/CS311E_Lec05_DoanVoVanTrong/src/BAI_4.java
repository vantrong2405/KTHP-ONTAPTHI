import java.util.Scanner;

public class BAI_4 {
	double x , S = 1 ; 
	long y;
	void Input() {
		System.out.println("Doan Vo Van Trong");
		System.out.println("Tinh x^y");
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap x : ");
		x = kb.nextDouble();
		System.out.print("Nhap y nguyen duong : ");
		y = kb.nextLong();
	}
	void Output() {
		for(int i = 1 ; i<=y ; i++) {
			S = S * x;
		}
		System.out.print((long)(x)+"^"+y+"=");
		for(int i = 1 ; i<y ; i++) {
			System.out.print((long)x+"*");
		}
		System.out.print((long)x+"="+(long)S);
	}
	public static void main(String[] args) {
		BAI_4 a = new BAI_4();
		a.Input();
		a.Output();
	}
}
