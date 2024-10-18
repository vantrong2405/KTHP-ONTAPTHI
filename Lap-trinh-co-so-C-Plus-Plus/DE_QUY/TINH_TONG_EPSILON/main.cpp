#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n ;
double x , e ;
//==================//
double Pow(double x , int n ){
	if(n==0)  return 1 ;
	return x * Pow(x,n-1);
}

int GiaiThua(int n){
	if(n==1 || n == 0) return 1;
	return n * GiaiThua(n-1);
}

double f(double x , int n ){
	if(n==0) return 1 ;
	return (Pow(x,n)/GiaiThua(n)+f(x,n-1));
}

//=======================//
int Input(int &n , char c ){
	int code = 0 ;
	do{
		printf(" nhap %c = ",c);
		code = scanf("%d",&n);
		fflush(stdin);
	}while(code == 0 || n < 0 );
	return 0 ;
}
//==================================//
int Input(double &x , char c ){
	int code = 0 ;
	do{
		printf("nhap %c =",c); 
		code = scanf("%lf",&x);
		fflush(stdin);
	}while(code == 0 );
	return 0 ;
}
int main(int argc, char** argv) {
	Input(n,'n'); 
	Input(x,'x');
	e =f(x,n);
	printf("S = %.3lf",e);
	return 0;
}
