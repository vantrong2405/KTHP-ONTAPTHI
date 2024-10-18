package LEC_03;

import java.util.Scanner;

public class BAI_3 {
	long a, b, c, d;
	char pt;

	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Doan Vo Van Trong");
		System.out.println("Tinh toan tren 2 phan so ");
		System.out.println("Nhap phan so 1 : ");
		System.out.println("Tu : ");
		a = kb.nextLong();
		System.out.println("Mau <>0 : ");
		b = kb.nextLong();
		System.out.println("Nhap phan so 2 : ");
		System.out.println("Tu : ");
		c = kb.nextLong();
		System.out.println("Mau<>0 : ");
		d = kb.nextLong();
		System.out.println("Nhap phep toan(+,-,*,/):");
		pt = kb.next().charAt(0);// bat ky tu
		
	}

	void Output() {
		if (pt == '+')
			System.out.println(a + "/" + b + "+" + c + "/" + d + "=" + (a * d + c * b) + "/" + b * d);
		else if (pt == '-')
			System.out.println(a + "/" + b + "-" + c + "/" + d + "=" + (a * d - c * b) + "/" + b * d);
		else if (pt == '*')
			System.out.println(a + "/" + b + "*" + c + "/" + d + "=" + (a * c) + "/" + b * d);
		else {
			if (a == 0 || c == 0)
				System.out.println("ko chia 0 ");
			else
				System.out.println(a + "/" + b + "/" + c + "/" + d + "=" + (a * d) + "/" + b * c);
		}
	}

	public static void main(String[] args) {
       BAI_3  a = new BAI_3();
    	   a.Input();
           a.Output(); 
	}
}
