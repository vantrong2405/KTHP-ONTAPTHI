#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int a , b , UC ;
//========================//
int UCLN(int a , int b ){
	if(a==b)  return a ;//neu 2 so bang nhau return so nao cung dc
		if(a>b) 
		   return UCLN(a-b,b);
		else  
		   return UCLN(a,b-a);   
}

//======================//
int main(int argc, char** argv) {
	int code = 0 ;
	do{
		printf("nhap a : "); 
		code = scanf("%d",&a); 
		fflush(stdin);
	}while(a<1 || code == 0 );
do{
		printf("nhap b : "); 
		code = scanf("%d",&b); 
		fflush(stdin);
	}while(b<1 || code == 0 );
	UC = UCLN(a,b);
	printf("UCLN(%d,%d) = %d",a,b,UC);
	return 0;
}
