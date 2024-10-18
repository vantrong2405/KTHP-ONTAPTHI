import java.util.Scanner;

public class BAI_6 {
	long n;

	void Input() {
		System.out.println("Doan Vo Van Trong");
		System.out.println("Liet ke So Nguyen to<=n");
		Scanner kb = new Scanner(System.in);
		do {
			System.out.print("Nhap so nguyen n>0: ");
			n = kb.nextLong();
		}while(n<=0);
	}

	boolean kiemTra(long x) {
		if (x < 2)
			return false;
		else {
			for (int i = 2; i <= x/2; i++)
				if (x % i == 0)
					return false;
		}
		return true;
	}

	void Output() {
		for (int i = 0; i <= n; i++)
			if (kiemTra(i) == true)
			System.out.print(i+"\t");
	}
	public static void main(String[] args) {
		BAI_6 a = new BAI_6();
		a.Input();
		a.Output();
	}
}
