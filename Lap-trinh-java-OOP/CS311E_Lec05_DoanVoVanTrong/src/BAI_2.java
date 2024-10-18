import java.util.Scanner;

public class BAI_2 {
	double S = 0;
	long n;

	void Input() {
		System.out.println("Doan Vo Van Trong");
		System.out.println("Tinh tong S(n) = 1 - 1/2 + 1/3 - ...");
		Scanner kb = new Scanner(System.in);

		do {
			System.out.print("Nhap n > 0 : ");
			n = kb.nextLong();
		} while (n <= 0);
	}

	double tinhTong(long X) {
		for (int i = 1; i <= n; i++) { // 1 - 1/2 + 1/3 - ..
//			if (i % 2 == 0) S = S - 1.0 / i;
//			else S = S + 1.0 / i;
			S = S + ((i%2==1)?1.0:-1.0)/i;
		}
		return S;
	}

	void Output() {
		System.out.print("S(" + n + ") = ");
		for (int i = 1; i < n; i++) {
			if (i % 2 == 1)
				System.out.print("1/" + i + " - ");
			else
				System.out.print("1/" + i + " + ");
		}
		System.out.print("1/" + n + " = " + tinhTong(n));

	}

	public static void main(String[] args) {
		BAI_2 a = new BAI_2();
		a.Input();
		a.Output();
	}
}
