import java.util.Scanner;

public class BAI_1 {
   long a , b , c , d ;
   char pt ; 
   void Input() {
	   Scanner kb = new Scanner(System.in); 
	   System.out.println("Doan Vo Van Trong ");
	   System.out.println("Tinh Toan tren 2 phan so ");
	   System.out.println("Nhap phan so 1 : ");
	   System.out.println("Tu : " );
	   a = kb.nextLong();
	   System.out.println("Mau <> 0 : ");
	   b = kb.nextLong();
	   System.out.println("Nhap phan so 2 : ");
	   System.out.println("Tu : " );
	   c = kb.nextLong();
	   System.out.println("Mau <> 0 : ");
	   d = kb.nextLong();
	   System.out.println("Nhap phep toan (+,-,*,/) :");
	   pt = kb.next().charAt(0);
   }
   
   void Output() {
	   switch(pt) {
	   case '+' : System.out.println(a +"/"+ b +"+" +b+"/"+c +"=" +(a*d + c*b )+"/"+(b*d)); break;
	   case '-' : System.out.println(a +"/"+ b +"-" +b+"/"+c +"=" +(a*d - c*b )+"/"+(b*d)); break;
	   case '*' : System.out.println(a +"/"+ b +"*" +b+"/"+c +"=" +(a*c) +"/"+(b*d)); break;
	   case '/' : if(a == 0 || c == 0 ) {
		   System.out.println("ko chia 0 "); break ; 
	   }else System.out.println(a +"/"+ b +"/" +b+"/"+c +"=" +(a*d) +"/"+(b*c)); break;
	   default : System.out.println("Nhap sai phep toan ! ");
	   }   
   }
   public static void main(String[] args) {
	BAI_1 a = new BAI_1();
		a.Input();
		a.Output();
}
}
