package LEC_03;

import java.util.Scanner;

public class BAI_2 {
	long a, b;
	char pt;

	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Nhap so nguyen 1 : ");
		a = kb.nextLong();
		System.out.println("Nhap so nguyen 2 : ");
		b = kb.nextLong();
		System.out.println("Nhap phep toan(+,-,*,/): ");
		pt = kb.next().charAt(0);
	}

	void Output() {
		System.out.println("Doan Vo Van Trong ");
		if (pt == '+')
			System.out.println(a + "+" + b + "=" + (a + b));
		else if (pt == '-')
			System.out.println(a + "-" + b + "=" + (a - b));
		else if (pt == '*')
			System.out.println(a + "*" + b + "=" + (a * b));
		else {
			if (b == 0)
				System.out.println("ko chia 0 ");
			else
				System.out.println(a + "/" + b + "=" + (double)(a / b));
		}
	}

	public static void main(String[] args) {
		BAI_2 a = new BAI_2();
			a.Input();
			a.Output();

	}
}
