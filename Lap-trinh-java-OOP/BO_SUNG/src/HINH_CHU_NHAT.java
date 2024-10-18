import java.util.Scanner;

public class HINH_CHU_NHAT {
    double a , b ; 
    
    void Input() {
       Scanner kb = new Scanner(System.in);
       System.out.print("Nhap canh1 : "); a = kb.nextDouble();
       System.out.print("Nhap canh 2 : "); b = kb.nextDouble();
    }
    
    void Output() {
    	System.out.println("Dien tich va chu vi hcn : ");
    	double P = (a + b)*2 ;
        double  S = a * b ;
        System.out.println("P= "+P);
        System.out.println("S = "+S);
    	
    }
    
    public static void main(String[] args) {
		HINH_CHU_NHAT x = new HINH_CHU_NHAT();
		x.Input();
		x.Output();
	}
}
