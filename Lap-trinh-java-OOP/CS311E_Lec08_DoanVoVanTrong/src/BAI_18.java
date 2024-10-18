
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class BAI_18 {

	long a, b, c, d;
	char pt;

	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Doan Vo Van Trong");
		System.out.println("Tinh toan tren 2 phan so ");
		System.out.println("Nhap phan so 1 : ");
		System.out.print("Tu: ");
		a = kb.nextLong();
		System.out.print("Mau<>0: ");
		b = kb.nextLong();

		System.out.println("Nhap phan so 2 : ");
		System.out.print("Tu: ");
		c = kb.nextLong();
		System.out.print("Mau<>0: ");
		d = kb.nextLong();

		System.out.print("Nhap phep toan (+,-,*,/): ");
		pt = kb.next().charAt(0);

	}

	long UCLN(long x, long y) {
		while (x != y) {
			if (x > y) {
				x = x - y;
			} else {
				y = y - x;
			}
		}
		return x;
	}

	void Output() {
		long x, y, z1, z2;
		switch (pt) {
		case '+':
			x = (a * d + b * c);
			y = b * d;
			z1 = x / UCLN(x, y);
			z2 = y / UCLN(x, y);
			System.out.println(a + "/" + b + " " + pt + " " + c + "/" + d + " = " + (z1 + "/" + z2));
			break;
		case '-':
			x = a * d - b * c;
			y = b * d;
			z1 = x / UCLN(Math.abs(x), Math.abs(y));
			z2 = y / UCLN(Math.abs(x), Math.abs(y));
			System.out.println(a + "/" + b + " " + pt + " " + c + "/" + d + " = " + (z1 + "/" + z2));
			break;
		case '*':
			x = a * c;
			y = b * d;
			z1 = x / UCLN(x, y);
			z2 = y / UCLN(x, y);
			System.out.println(a + "/" + b + " " + pt + " " + c + "/" + d + " = " + (z1 + "/" + z2));
			break;
		case '/':
			if (c == 0 || b == 0) {
				System.out.println("Ko chia 0 ");
			} else {
				x = a * d;
				y = b * c;
				z1 = x / UCLN(x, y);
				z2 = y / UCLN(x, y);
				System.out.println(a + "/" + b + " " + pt + " " + c + "/" + d + " = " + (z1 + "/" + z2));
			}
			break;
		}
	}

	public static void main(String[] args) {
		BAI_18 a = new BAI_18();
		a.Input();
		a.Output();
	}
}
