import java.util.Scanner;

public class BAI_5 {
    long i , n ; 
    void Input() {
    	Scanner kb = new Scanner(System.in);
    	System.out.println("Doan Vo Van Trong ");
    	System.out.println("Kiem tra so nguyen to ");
        	System.out.print("Nhap 1 so nguyen : ");
        	n = kb.nextLong();
    }
    
    boolean kiemTra(long x ) {
    	if(x < 2 ) return false ; 
    	else {
    		for(int i = 2 ; i<=x/2 ;i++) 
    			if(x % i == 0 ) return false ; 
    	}
    	return true ;
    }
    
    void Output() {
    	System.out.print(n+": ");
    	if(kiemTra(n)==true) System.out.println("Yes");
    	else System.out.println("No");
    }
    public static void main(String[] args) {
    	BAI_5 a = new BAI_5();
		   a.Input();
		   a.Output();
	  
	}
}
