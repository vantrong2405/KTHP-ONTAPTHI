#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , GT ;
//=========================//
int GiaiThua(int n){
	if(n == 0 || n == 1) return 1 ;
	else{
		return n * GiaiThua(n-1);
	}
}

int main(int argc, char** argv) {
	int code = 0 ;
	do{
		printf("nhap n : ");
		code = scanf("%d",&n);
		fflush(stdin);
	}while(n<0 || code == 0);
	GT = GiaiThua(n);
	printf("Giai thua = %d ",GT);
	return 0;
}
