#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n ;
double x , s ;
//==================//
double f(double x , int n ){
	if(n==0) return 1 ;
	return x * f(x,n-1);	
}

double F(double x , int n ){
	if(n==0) return f(1.5,8);
	return (f(-1,n)*f(x + n, n))/f(n,2) + F(x,n-1);
}
//=======================//
int Input(int &n , char c ){
	int code = 0 ;
	do{
		printf("nhap %c = ",c);
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
	s = F(x,n);
	printf("S = %.3lf",s);
	return 0;
}
