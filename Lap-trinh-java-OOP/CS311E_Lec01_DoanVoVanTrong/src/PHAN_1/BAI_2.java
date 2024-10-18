package PHAN_1;

import java.util.Scanner;

public class BAI_2 {
	long a, b;
    double x ; 
	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Nhap so nguyen 1 : ");
		a = kb.nextLong();
		System.out.println("Nhap so nguyen 2 : ");
		b = kb.nextLong();
		x = (double)a/b ; 
	}

	// ===//
	void Output() {
		System.out.println("Doan Vo Van Trong");
		System.out.println("Tong: " + a + " + " + b + " = " + (a + b));
		System.out.println("Hieu: " + a + " - " + b + " = " + (a - b));
		System.out.println("Tich: " + a + " * " + b + " = " + (a * b));
		System.out.println("Thuong: " + a + " : " + b + " = " + x);
		System.out.println("Chia nguyen: " + a + " Div " + b + " = " +  (a / b));
		System.out.println("Chia du: " + a + " Mod " + b + " = " + (a % b));
		System.out.println("Mu: " + a + " ^ " + b + " = " + Math.pow(a,b));
	}

	// =====//
	public static void main(String[] args) {
		BAI_2 a = new BAI_2();
		a.Input();
		a.Output();
	}
}
