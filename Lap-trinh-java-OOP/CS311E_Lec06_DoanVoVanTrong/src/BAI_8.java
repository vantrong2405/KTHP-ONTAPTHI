import java.util.Scanner;

public class BAI_8 {
	long n;
	Scanner kb = new Scanner(System.in);

	void Input() {
		System.out.println("Doan Vo Van Trong");
		System.out.println("Trung binh cong So Nguyen to trong n so nhap tu ban phim <=n");
		System.out.print("Nhap so nguyen n>0 : ");
		n = kb.nextLong();
	}

	boolean kiemTraSnt(long x) {
		if (x < 2)
			return false;
		else {
			for (int i = 2; i <= x / 2; i++)
				if (x % i == 0)
					return false;
		}
		return true;
	}

	void Output() {
		long x, S = 0, dem = 0;
		System.out.print("Nhap 5 so nguyen : ");
		for (int i = 0; i < n; i++) {
			x = kb.nextLong();
			if (kiemTraSnt(x) == true) {
				S = S + x;
				dem = dem + 1;	
			}
		}
       System.out.println("TBC = "+(S/dem));
	}
	public static void main(String[] args) {
		BAI_8 a = new BAI_8();
		a.Input();
		a.Output();
	}
}
