package PHAN_1;

import java.util.Scanner;

public class BAI_3 {
  long ps; 
  long a , b , c , d ; 
  Scanner kb = new Scanner(System.in);
  void Input() {
  System.out.println("Nhap phan so 1 : ");
  System.out.println("Nhap Tu : ");
  a = kb.nextLong();
  System.out.println("Nhap Mau : ");
  b = kb.nextLong();
  System.out.println("Nhap phan so 2 : ");
  System.out.println("Nhap Tu : ");
  c = kb.nextLong();
  System.out.println("Nhap Mau : ");
  d = kb.nextLong();
  }
  //========//
  void Output() {
	  System.out.println("Doan Vo Van Trong");
	  System.out.println(a+"/"+b+"+"+c+"/"+d+"="+(a*d +c*b)+"/"+b*d); 
	  System.out.println(a+"/"+b+"-"+c+"/"+d+"="+(a*d -c*b)+"/"+b*d); 
	  System.out.println(a+"/"+b+"*"+c+"/"+d+"="+(a*c)+"/"+b*d); 
	  System.out.println(a+"/"+b+"/"+c+"/"+d+"="+(a*d)+"/"+b*c); 	
  }
  public static void main(String[] args) {
	BAI_3 a = new BAI_3();
	a.Input();
	a.Output();
}

}
