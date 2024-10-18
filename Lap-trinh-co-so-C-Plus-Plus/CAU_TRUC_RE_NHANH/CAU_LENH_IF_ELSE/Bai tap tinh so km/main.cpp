#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int n ;
	printf(" nhap n :");
	scanf("%d",&n);
	double S = 0 ;
	if(n==1){
		 S = S + 5000 ;
		printf("So tien di taxi ban phai tra la : %0.3lf",S);
	}else{
		if(n>=2 && n<=5){
         S = 5000 + 4500 *(n-1);
		 printf("So tien di taxi ban phai tra la : %lf",S);   		
		}else{
		 S = 5000 + 4500 *(n-1) + 3500 *(n-5);
		 printf("So tien di taxi ban phai tra la : %lf",S);
		}
	}
	return 0;
}
