#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	double a , b , c ;
	printf(" nhap a : "); scanf("%lf",&a);
	printf(" nhap b : "); scanf("%lf",&b);
	printf(" nhap c : "); scanf("%lf",&c);
	if(a + b > c && a + c > b && b + c >a){
		if(a > 0 && b > 0 && c > 0  || a + b > c || a + c > b || b + c > a   ){
			printf("Day la so do 3 canh cua tam giac\n");
		}
	}else{
		printf("Day khong phai la 3 canh cua tam giac\n"); 
	}
				
	return 0;
}
