import java.util.Scanner;

public class CAU6 {
	int a, b;

	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap a : ");
		a = kb.nextInt();
		System.out.print("Nhap b : ");
		b = kb.nextInt();
	}

	 int tinhPhepChia(int a, int b) {
		int S = 0;
		int x = 0;
		if (b * b > a) {
			S = 0;
			return S;
		} else if (b * b == a) {
			S = 1;
			return S;
		} else if (b * b < a) {
			S++;
			int n = b * b;
			while (Math.sqrt(n) <= a) {
				S++;
			}
			return S;
		}
		return S;

	}

	void Output() {
		System.out.println(a + " / " + b + " = " + tinhPhepChia(a, b));
	}

	public static void main(String[] args) {
		CAU6 a = new CAU6();
		a.Input();
		a.Output();
	}
}
