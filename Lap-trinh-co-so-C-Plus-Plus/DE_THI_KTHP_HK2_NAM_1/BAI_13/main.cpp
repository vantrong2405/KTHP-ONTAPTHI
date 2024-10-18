#include <iostream>
#define size 50 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i , n , A[size];
//===//
void Input(int &n){
	do{
		printf("nhap n : "); scanf("%d",&n);//nhap kich thuoc mang 
	}while(n > size || n<=0);
	printf("Mang cua ban la : A[%d]\n",n);
}
//===//
void TaoMang(int &n , int A[] ){
	for(int i = 0 ; i < n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]);
	}
}
//==========//
void InMang(int &n , int A[] ){
	printf("\n-----------Thong tin mang-------------\n");
	for(int i = 0 ; i< n ; i++ ){
		printf("%d\t",A[i]);
	}
}
//==//
void Ktra()
int main(int argc, char** argv) {
	Input(n);
	TaoMang(n,A);
	InMang(n,A);
	return 0;
}

