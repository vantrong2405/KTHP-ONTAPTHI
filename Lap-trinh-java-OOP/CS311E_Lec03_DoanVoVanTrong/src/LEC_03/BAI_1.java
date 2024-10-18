package LEC_03;
//Sai
import java.util.Scanner;

public class BAI_1 {
	double a, b, c, delta, x1, x2;

	void input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Giai ax^4 +bx^2 + c = 0");
		System.out.print("Nhap he so a<>0: ");
		a = kb.nextDouble();
		System.out.print("Nhap he so b<>0:");
		b = kb.nextDouble();
		System.out.print("Nhap he so c<>0:");
		c = kb.nextDouble();
	}
      /* dat t = x^2 =>at ^2 + bt + c = 0 , no t > 0 
       * delta = b^2 - 4ac
       * TH(d>0){
       * t12 = (-b -/+ can(d)) /(2a)
       * TH(t1 >0) => +- can(t1)
       * TH(t2 >0) => +- can(t2)
       * TH(t1<0 va t2 <0) -> vo nghiem 
	    }
	    
	    TH (d==0 ) 
	    t = -b/2a
	    TH(t>0) => +-can(t)
	    TH(t<0) => vo nghiem 
	    }
	    TH(d<0) => vo no 
	       
	       */
	void output() {
		delta = Math.pow(b, 2) - 4 * a * c;
		System.out.println("Delta = "+delta);
	    System.out.println(+(int)a+"x^4"+((b>0)?"+":" ")+(int)b+"x^2"+((c>0)?"+":" ")+(int)c+"=0");
		if (delta > 0) {
			x1 = (-b+Math.pow(delta,0.5)/(2.0*a));
			x2 = (-b-Math.pow(delta, 0.5)/(2.0*a));
			System.out.println(+x1+","+x2);  
		}else if ( delta == 0 ) {
			x1 = -b / (2.0 * a);  
			System.out.println( +x1);
			System.out.println();
			
		}else {
			System.out.println("vo nghiem");  
		}
	}
	public static void main(String[] args) {
		BAI_1 a = new BAI_1();
		a.input();
		a.output();		
	}
}
