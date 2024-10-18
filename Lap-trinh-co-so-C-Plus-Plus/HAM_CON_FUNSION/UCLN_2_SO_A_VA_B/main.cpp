#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int a , b , UC ;
int code = 0 ; 
int UCLN(int a , int b ){
	while(a!=b){
		if(a>b) a= a - b ;
		else b = b - a ;
	}
	return a ;
}
int main(int argc, char** argv) {
	do{
		printf(" nhap a : "); 
		code = scanf("%d",&a);
		fflush(stdin);
	}while(a<1 || code == 0 );
	do{
		printf(" nhap b : "); 
		code = scanf("%d",&b);
		fflush(stdin);
	}while(b<1 || code == 0 );
	UC = UCLN(a,b);
	printf("UCLN(%d,%d) = %d",a,b,UC);
	return 0;
}
