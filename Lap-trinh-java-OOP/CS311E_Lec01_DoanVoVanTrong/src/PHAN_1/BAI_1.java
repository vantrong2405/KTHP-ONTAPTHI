package PHAN_1;

import java.util.Scanner;

public class BAI_1 {
	double r , S , P ;	
	final double Pi = 3.14 ; 
	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Nhap ban kinh  : ");
		r = kb.nextDouble();
		S = Pi * r * r ; 
		P = 2 * Pi * r ; 
	}
	//==========//
	void Output() {
		System.out.println("Doan Vo Van Trong ");
		System.out.println("Tinh S va P hinh tron : ");
		System.out.println("S = " + "3.14 * " + r +" * "+ r + " = " +S);
		System.out.println("P = 2 * 3.14 * "+ r + " = " +P);
	}
	//=========//
	public static void main(String[] args) {
		 BAI_1 a = new BAI_1();
		 a.Input();
		 a.Output();
   }
  }

