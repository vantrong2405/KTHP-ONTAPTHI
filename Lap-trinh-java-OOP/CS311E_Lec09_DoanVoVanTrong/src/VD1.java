
import java.util.Scanner;



public class VD1 {

    int A[] = new int[100];
    int n;
    Scanner kb = new Scanner(System.in);
    void Input() {
       
        System.out.println("Thuc hanh ve mang");
        do {
            System.out.print("1.Nhap so phan tu mang >0 :");
            n = kb.nextInt();
        } while (n <= 0);

        for (int i = 0; i < n; i++) {//*9 -> in ra tu 0 den 8 
            A[i] = (int) (Math.random() * 100);// *100 =>in ra tu 0 den 99 
        }
    }

    void Xuat(String nd) {
        System.out.print(nd);
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

    }

    //Cau 2 
    int Max() {
        int max = A[0];
        for (int i = 0; i < n; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }
        return max;
    }

    //Cau 3 
    int Min() {
        int min = A[0];
        for (int i = 0; i < n; i++) {
            if (min > A[i]) {
                min = A[i];
            }
        }
        return min;
    }

    //Cau 4 
    int tongMaxLienTiep() { //1 2 3 4 5 6 7 8
        int max = A[0] + A[1];
        for (int i = 0; i < n - 1; i++) {
            if (max < A[i] + A[i + 1]) {
                max = A[i] + A[i + 1];
            }
        }
        return max;
    }

    // Cau 5 
    int tongCacSoChan() {
        int S = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                S = S + A[i];
            }
        }
        return S;
    }

    //Cau 6 
    boolean Snt(int x) {
        if (x < 2)  return false;
        for (int i = 2; i <= n / 2; i++) 
            if (x % i == 0) 
                return false ; 
        return true;
    }

    int TBC_SNT() {
        int S = 0, dem = 0;
        for (int i = 0; i < n; i++) {
            if (Snt(A[i]) == true) {
                S = S + A[i];
                dem++;
            }
        }
        S = S / dem;
        return S;
    }
    
    int Dem_SNT() {
        int dem = 0;
        for (int i = 0; i < n; i++) 
            if (Snt(A[i]) == true) 
               dem++;
        return dem;
    }
    //Cau 7
    int soDao(int x) {//12345
        int S = 0;
        while (x != 0) {
            int laySo = x % 10;
            S = S * 10 + laySo;
            x = x / 10;
        }
        return S;
    }

    boolean SDX(int x) {
        if (soDao(x) == x && x > 10) 
            return true;
        return false;
    }

    int tongSoDoiXung() {
        int S = 0;
        for (int i = 0; i < n; i++) 
            if (SDX(A[i]) == true) 
                S = S + A[i];
        return S;
    }
    //Cau 8 
    int tongSo(int x ){//43 , 56
        int S = 0 ;  
        while(x!=0){
            int laySo = x % 10 ; 
            S = S + laySo ; 
            x = x / 10 ; 
        }
      return S ; 
    }
    // cau 9 
    void xemMang(){
        for(int i = 0 ; i<n ; i++){
            System.out.print(A[i] + " ");
        }
    }
    void ChenX(){
        int x , k ; // x = value , k = index
        x = kb.nextInt();
        k = kb.nextInt();
        if(k>0 && k<n){
            for(int i = n - 1 ; i>=k ; i++){
                A[i+1] = A[i]; 
            }
            A[k] = x ;
            n = n + 1 ;
        } 
    }

    void Output() {
        Xuat("Mang vua tao ngau nhien : "); 
        System.out.println("\n2.Max = "+Max());
        System.out.println("3.Max - min = "+(Max()-Min()));
        System.out.println("4.Tong 2 so lien tiep co tong lon nhat = "+tongMaxLienTiep());
        System.out.print("5.Tong cac so chan = ");
        for(int i = 0 ; i<n ; i++){
            if(A[i] % 2 == 0 ) System.out.print(A[i] + " + ");
        }
        System.out.println("\b\b= "+tongCacSoChan());
        System.out.print("6.TB cac so nguyen to = (");
        for(int i = 0 ; i<n ; i++){
            if(Snt(A[i])== true) System.out.print(A[i] + " + ");
        }
        System.out.println("\b\b)/"+Dem_SNT()+" = "+TBC_SNT());
        System.out.print("7.Tong cac so doi xung = ");
        for(int i = 0 ; i<n ; i++){
            if(SDX(A[i])==true) System.out.print(A[i] + " + ");
        }
        System.out.println("\b\b="+tongSoDoiXung());
        System.out.print("8.Cac so co tong cac chu so >10 : ");
        for(int i = 0 ; i<n ; i++){
            if(tongSo(A[i])>10) System.out.print(A[i]+" ");
        }
        System.out.print("\nMang truoc khi chen la : ");
        xemMang();
        System.out.print("\n9.Nhap gia tri va chi so can chen : ");
//        ChenX();
        System.out.print("Mang sau chen : ");
        xemMang();
    }

    public static void main(String[] args) {
        VD1 a = new VD1();
        a.Input();
        a.Output();
    }

}
