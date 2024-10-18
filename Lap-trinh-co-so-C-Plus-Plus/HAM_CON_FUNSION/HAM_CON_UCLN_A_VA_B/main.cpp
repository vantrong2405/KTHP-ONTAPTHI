#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int a  ,  b , UC , ucln ; 
//============================//
void nhap(){
	printf(" nhap a : "); scanf("%d",&a);
	printf(" nhap b : "); scanf("%d",&b);
}
//============================//
int UCLN(int a , int b ){
	while(a!= b){
	   if(a > b ){
	   	a = a - b ; UC = a ;
	   }  
	   else{
	   	b = b - a  ;
	   	UC = b ;
	   } 
	}
	if(a==b){
		UC = a ;
	}
	return UC ;
}
//===========================//


int main(int argc, char** argv) {
    nhap();
	printf("UCLN cua a va b la : %d",UCLN(a,b));
	return 0;
}
