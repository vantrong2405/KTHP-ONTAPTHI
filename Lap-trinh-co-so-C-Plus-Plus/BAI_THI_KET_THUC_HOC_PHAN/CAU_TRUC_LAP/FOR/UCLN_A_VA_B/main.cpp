#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int a , b , UC ; 
int main(int argc, char** argv) {
	printf(" nhap a : "); scanf("%d",&a);
	printf(" nhap b : "); scanf("%d",&b);
	while(a!= b ){//den khi nao ma a = b no moi dung cai vong lap nay
	if(a>b){
		a = a - b ;
		UC = a ;
    }else
        b = b - a ;
		UC = b ;	
	}
	if(a == b )
		UC = a ;
		printf("UCLN = %d",UC);
	 
	return 0;
}
