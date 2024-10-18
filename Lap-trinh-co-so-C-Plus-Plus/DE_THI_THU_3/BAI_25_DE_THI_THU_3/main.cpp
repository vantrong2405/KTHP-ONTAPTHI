#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i ;
double S = 0 ; 
int main(int argc, char** argv) {
	printf("nhap n : "); scanf("%d",&n);
	if(n<1 || n>10){
		printf("Errol\n");
		return 0 ; 	
	}
	for(int i = 0 ; i<n ; i++){
		S = S + 1.0/((2*i)+1); 
	}
	printf("S = %.2lf",S);
	return 0;
}
