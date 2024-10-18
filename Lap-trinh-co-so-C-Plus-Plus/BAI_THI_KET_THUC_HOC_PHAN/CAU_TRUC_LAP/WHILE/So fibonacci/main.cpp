#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , S ;
int main(int argc, char** argv) {
	printf(" nhap n : ");
	scanf("%d",&n);
	if(n==1){
		S = 1 ;
	}else{
		if(n==2){
			S = 2 ;
		}else{
		S = 2 ;
		int f0 = 1 , f1 = 1 , fn = 0 ;
		i = 2 ;
		while(i<n){
			fn = f0 + f1 ;
			S = S + fn ;
			f0 = f1 ; 
			f1 = fn ;
			i = i + 1 ;
		} 
	}
	}
	printf("S = %d ",S);
	return 0;
}
