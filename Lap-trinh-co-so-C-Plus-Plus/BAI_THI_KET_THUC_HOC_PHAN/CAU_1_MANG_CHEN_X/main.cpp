#include <iostream>
#define size 30 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int N , X , H , K , L ;
int A[30];
//====//
void Input(int &N){
	int code = 0 ; 
	do{
		printf("nhap N : "); code=scanf("%d",&N);
	}while(code == 0 || N > 30 || N <= 0);
} 
//===//
void TaoMang(int A[] , int &N){
	for(int i = 0 ; i<N ;i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]);
	}
}
//===//
void XemMang(int A[] , int &N){
	printf("-------------Thong tin cua mang-----------------\n");
	for(int i = 0 ; i<N ; i++){
		printf("%d\t",A[i]);
	}
}
//====//
int TongLe(int A[] , int &N){
	for(int i = 0 ; i<N ; i++){
		if(i % 2 == 1 ){
			H = H + A[i];
		}
	}
	return H ; 
}
//======//
int SoPtu(int A[] , int &N){
	for(int i = 0 ; i<N ; i++){
		if(A[i] == X){
			K++;
		}
	}
	return K ; 
}
//======//
int GTLN(int A[] , int &N){
	for(int i = 0 ; i<N ; i++){
		if(A[i] > L ){
			L = A[i];
		}
	}
	return L ; 
}
//=====//
int ChenX(int A[] , int &N){
	printf("\nNhap vi tri can chen K : "); scanf("%d",&K);
  if(K<=N-1 ){
  	for(int i = N-1  ; i>=K ; i--){
  		A[i+1] = A[i];
	}
	A[K] = X ; 
    N = N + 1 ;
}
}
int main(int argc, char** argv) {
	Input(N);
	TaoMang(A,N);
	XemMang(A,N);
	printf("\nH = %d ",TongLe(A,N));
	printf("\nNhap gia tri X : "); scanf("%d",&X);
	printf("\nK = %d ",SoPtu(A,N));
	printf("\nL = %d ",GTLN(A,N));
	ChenX(A,N);
	XemMang(A,N);
	return 0;
}
