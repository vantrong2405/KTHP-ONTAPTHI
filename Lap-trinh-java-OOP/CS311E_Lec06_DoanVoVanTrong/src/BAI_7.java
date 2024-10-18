import java.util.Scanner;

public class BAI_7 {
	long n;

	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Doan Vo Van Trong");
		System.out.println("Trung binh cong So Nguyen to <=n ");
		System.out.print("Nhap so nguyen n>0: ");
		n = kb.nextLong();
	}

	boolean kiemTra(long x) {
		if (x < 2)
			return false;
		else {
			for (int i = 2; i <= x / 2; i++)
				if (x % i == 0)
					return false;
		}
		return true;
	}

	long congSoNguyenTo(long x) {
		long S = 0;
		for (int i = 1; i <= x; i++) {
			if (kiemTra(i) == true) {
				S = S + i;
			}
		}
		return S;
	}

	long demSoNguyenTo(long x) {
		long dem = 0;
		for (int i = 1; i <= x; i++) {
			if (kiemTra(i) == true)
				dem++;
		}
		return dem;
	}

	void Output() {
		System.out.print("TBC = (");
		label :
		for (int i = 1; i < n; i++) {
			if (kiemTra(i) == true) {
				System.out.print(i);
				if(i == n-1 ) 
					break label; 
				System.out.print(" + ");
			}

		}
		if(n == 0 || n == 1 || n== 2) {
			System.out.println("0");
			System.exit(0);
		}
		if (kiemTra(n) == true)
			System.out.print(n + " )/" + demSoNguyenTo(n) + " = " + (1.0 * congSoNguyenTo(n) / demSoNguyenTo(n)));
		else {
			System.out.print(")/" + demSoNguyenTo(n) + " = " + (1.0 * congSoNguyenTo(n) / demSoNguyenTo(n)));
		}

	}

	public static void main(String[] args) {
		BAI_7 a = new BAI_7();
		a.Input();
		a.Output();
	}
}
