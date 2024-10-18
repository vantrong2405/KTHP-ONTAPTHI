package PHAN_1;

import java.util.Scanner;

public class BAI_4 {
	long a, b, c, d , max ; 
	void Input() {
      Scanner kb = new Scanner(System.in);
      System.out.println("Nhap a : ");
      a = kb.nextLong();
      System.out.println("Nhap b : ");
      b = kb.nextLong();
      System.out.println("Nhap c : ");
      c = kb.nextLong();
      System.out.println("Nhap d : ");
      d = kb.nextLong();
	}
//================================//
	void Output() {
		System.out.println("Doan Vo Van Trong");
      max = (Math.max(a, b) > Math.max(c, d))?Math.max(a, b) : Math.max(c, d);
      System.out.println("Max("+ a + "," + b + "," + c + "," + d + ")=" +max);
	}

	public static void main(String[] args) {
       BAI_4 a = new BAI_4();
       a.Input();
       a.Output();
	}
}