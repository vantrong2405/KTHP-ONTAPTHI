#include <iostream>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , dem = 0 ;
int shh  = 0 ;
int i ; 
int Ktra(int a){
	int shh = 0 ; 
	for(int i = 1 ; i<=a/2 ; i++){
		if( a % i == 0 ){
			shh = shh + i ; 
		}
	}
	return shh ; 
}

int SoHoanHao(int n){
	printf("Cac so hoan hao la : ");
   for(int i = 1 ; i<= n ;i++){
   	if(Ktra(i) == i ){
   		printf("%d\t ",i);
	   }
   }
}


int main(int argc, char** argv) {
	printf("nhap n: "); scanf("%d",&n);
	SoHoanHao(n);
	return 0;
}
