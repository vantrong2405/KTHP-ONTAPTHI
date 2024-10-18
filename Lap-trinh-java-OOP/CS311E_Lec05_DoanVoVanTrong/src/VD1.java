import java.util.Scanner;

public class VD1 {
	long n;

	void Input() {
		System.out.println("Tinh tong S(n) = 1 + 1/2 + 1/3 + ... + 1/n");
		Scanner kb = new Scanner(System.in);
		do {
			System.out.print("Nhap n > 0 : ");
			n = kb.nextLong();
		} while (n == 0 || n < 0);

	}

	double tinhTong(long n) {
		double S = 0;
		for (int i = 1; i <= n; i++) {
			S = S + 1.0 / i;
		}
		return S;
	}

	void Output() {
		System.out.print("S("+n+")=");
        for(int i=1; i<=n; i++)
            System.out.print(" 1/"+i+" +");
        System.out.println("\b ="+ tinhTong(n));
	}

	public static void main(String[] args) {
		VD1 a = new VD1();
		a.Input();
		a.Output();
	}
}
