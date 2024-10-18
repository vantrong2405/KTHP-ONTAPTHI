#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	using namespace std ;
    int a , b , c , d ;
    printf(" nhap a : ");
    scanf("%d",&a);
    printf(" nhap b : ");
    scanf("%d",&b);
    printf(" nhap c : ");
    scanf("%d",&c);
    printf(" nhap d : ");
    scanf("%d",&d);
    int Max = a ;
    if(Max<b){
    	Max = b ;
	}
	
	if(Max<c){
		Max = c ;
	}
	
	if(Max < d ){
		Max = d ;
	}
	printf("Max cua a b c d la : %d ",Max);
	return 0;
}
