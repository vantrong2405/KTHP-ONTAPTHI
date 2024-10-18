#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int a , b , c , x; 
void Input(int &a , char c){
	int code =0 ;
	do{
		printf("nhap %c =",c); code = scanf("%d",&a);
	}while(code==0 || a<=0);
} 

int UCLN(int a , int b ){
	if(a==b) return a ;
	if(a>b)  return UCLN(a-b,b);
	if(a<b)  return UCLN(a,b-a);	
}
//=========================//
int main(int argc, char** argv) {
	Input(a,'a');
	Input(b,'b');
	Input(c,'c');
	x = UCLN(a,b);
	printf("UCLN(%d,%d,%d) = %d",a,b,c,UCLN(x,c));
	return 0;
}
