import java.util.Scanner;

public class GIAI_PT_BAC_2 {
	double a , b , c , X1 , X2 , X , delta ; 
   void Input() {
	   Scanner kb = new Scanner(System.in);
	   System.out.println("Nhap a <>0: ");
	   a = kb.nextDouble();
	   System.out.println("Nhap b : ");
	   b = kb.nextDouble();
	   System.out.println("Nhap c : ");
	   c = kb.nextDouble();
   }
   //=======//
   void Output() {
	   delta = b*b - 4 *a * c ; 
	  System.out.println((int)a+"x^2"+((b>0)?"+":"")+(int)b+"x"+((c>0)?"+":"")+(int)c+"=0 ");  
	  if(delta < 0) {
		  System.out.println("vo no");
	  }else if(delta > 0) {
		  X1 = (-b+Math.sqrt(delta))/(2*a);
		  X2 = (-b-Math.sqrt(delta))/(2*a);
		  System.out.println("X =" +X1);
		  System.out.println("X ="+X2);
	  }else {
		  X = -b/(2*a);
		  System.out.println("\nx1 = x2 = "+X);
	  }
   }
   
   public static void main(String[] args) {
      GIAI_PT_BAC_2 a = new GIAI_PT_BAC_2();
      a.Input();
      a.Output();
}
}
