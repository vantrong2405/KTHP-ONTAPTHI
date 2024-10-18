#include <iostream>
#define size 20 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int A[size];
int n , i ;
int S = 0 , k ; 
//==//
void Input(int &n){
	int code = 0 ; 
	do{
		printf("nhap n : "); code = scanf("%d",&n);	
	}while(n>size|| n<= 0 || code == 0 );
	printf("Mang cu ban la : A[%d]\n",n);
}
//======//
void TaoMang(int &n,int A[]){
	for(int i = 0 ; i< n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]);
	}
}
//======//	

void XemMang(int &n , int A[]){
	printf("\n--------------------Thong tin mang--------------------- :\n");
	for(int i = 0 ; i<n ; i++){
		printf("%d\t",A[i]);
	}
}
//====//
int TongLe(int &n , int A[]){
	for(int i = 0 ; i< n ; i++){
		if(A[i] % 2 == 1){
			S = S + A[i];
		}
	}
	return S ; 
}
//===//
void XoaX(int &n , int A[]){
	do{
		printf("nhap k : "); scanf("%d",&k);
	}while(k>n || k<=0);
	if(k<n-1){
		for(int i = k ; i<n-1; i++){
			A[i] = A[i+1];
		}
		n = n - 1 ;
	}
}
int main(int argc, char** argv) {
	Input(n);
	TaoMang(n,A);
	XemMang(n,A);
	printf("\nTong cac so le co trong mang la : %d\n",TongLe(n,A));
	XoaX(n,A);
	XemMang(n,A);
	return 0;
}



