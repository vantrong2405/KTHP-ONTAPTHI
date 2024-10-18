

import java.util.Scanner;

public class BAI_7 {

    long n;
    int t = 0;
    int s;
    int sum = 0;

    void input() {
        System.out.println("Nguyen Van Minh");
        System.out.print("Tinh Trung binh cong cac so nguyen to trong so n nhap tu ban phim <= n\n");
        Scanner kb = new Scanner(System.in);
        System.out.print("nhap n>0: ");
        n = kb.nextInt();

        System.out.print("Nhap " + n + " so nguyen: ");
        for (int i = 1; i <= n; i++) {
//        System.out.print(s);
            s = kb.nextInt();
            if (KTSoNt(s)) {
                sum = sum + s;
                t += 1;
            }
        }
    }

    boolean KTSoNt(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    void output() {
        double m = (double) sum / t;
        System.out.println("TBC =" + m);
    }

    public static void main(String[] args) {
    	BAI_7 a = new BAI_7();
        a.input();
        a.output();
    }

}