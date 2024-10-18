import java.util.Scanner;

public class GIAI_PT_BAC_4 {
	double x1, x2, a, b, c;

	void Input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Doan Vo Van Trong ");
		System.out.println("Giai ax^4 +bx^2 + c = 0");
		System.out.println("Nhap a<>0 : ");
		a = kb.nextFloat();
		System.out.println("Nhap b<>0 : ");
		b = kb.nextFloat();
		System.out.println("Nhap c<> : ");
		c = kb.nextFloat();
	}

	public int giaiPT() {
		double delta = b * b - 4 * a * c;
		if (delta < 0) {
			x1 = x2 = 0;
			return 0;
		} else if (delta == 0) {
			x1 = x2 = -b / (2 * a);
			return 1;
		} else {
			x1 = (-b + Math.sqrt(delta)) / (2 * a);
			x2 = (-b - Math.sqrt(delta)) / (2 * a);
			return 2;
		}
	}

	public void Output() {
		System.out.println(+(int)a+"x^4"+((b>0)?"+":" ")+(int)b+"x^2"+((c>0)?"+":" ")+(int)c+"=0");
		if (giaiPT() == 0) {
			System.out.println("Phuong trinh vo nghiem");
		} else if (giaiPT() == 1) {
			if (x1 < 0)
				System.out.println("Phuong trinh vo nghiem");
			else if (x1 == 0)
				System.out.println("Phuong trinh co 1 nghiem X : " + 0);
			else {
				System.out.println("Phuong trinh co 2 nghiem");
				System.out.println("X1 : " + Math.sqrt(x1));
				System.out.println("X2 : " + (-Math.sqrt(x1)));
			}
		} else {
			if (x1 < 0) {
				if (x2 < 0)
					System.out.println("Phuong trinh vo nghiem");
				else if (x2 == 0)
					System.out.println("Phuong trinh co 1 no X : " + 0);
				else {
					System.out.println("Phuong trinh co 2 nghiem");
					System.out.println("X1 : " + Math.sqrt(x2));
					System.out.println("X2 : " + (-Math.sqrt(x2)));
				}

			} else if (x1 == 0) {
				if (x2 < 0)
					System.out.println("Phuong trinh co 1 no X : " + 0);
				else {
					System.out.println("Phuong trinh co 3 nghiem :");
					System.out.println("X1 : " + Math.sqrt(x2));
					System.out.println("X2 : " + (-Math.sqrt(x2)));
					System.out.println("X3 : " + 0);
				}
			} else {
				if (x2 < 0) {
					System.out.println("Phuong trinh co 2 nghiem");
					System.out.println("X1 : " + Math.sqrt(x1));
					System.out.println("X2 : " + (-Math.sqrt(x1)));
				} else if (x2 == 0) {
					System.out.println("Phuong trinh co 3 nghiem :");
					System.out.println("X1 : " + Math.sqrt(x1));
					System.out.println("X2 : " + (-Math.sqrt(x1)));
					System.out.println("X3 : " + 0);
				} else {
					System.out.println("Phuong trinh co 4 nghiem :");
					System.out.println("X1 : " + Math.sqrt(x1));
					System.out.println("X2 : " + (-Math.sqrt(x1)));
					System.out.println("X3 : " + Math.sqrt(x2));
					System.out.println("X4 : " + (-Math.sqrt(x2)));
				}
			}

		}
		
	}

	public static void main(String[] args) {
		GIAI_PT_BAC_4 a = new GIAI_PT_BAC_4();
		a.Input();
		a.giaiPT();
		a.Output();
	}

}