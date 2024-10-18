#include <iostream>
#define size 30
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , x , k ; 
int A[size];
///========//
void Input(int &n){
	int code = 0 ; 
	do{
		printf("nhap kich thuoc mang : ");
		code = scanf("%d",&n);//nhap kich thuoc mang 
	}while(code == 0 || n > size || n <= 0 );
}
//==========//
void NhapMang(int A[] , int &n){
	for(int i = 0 ; i < n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]);//nhap tung phan tu cua A{i]
	}
}
//=======//
void InMang(int A[] , int &n){
	printf("-----------------Thong tin mang A[%d]-----------------------\n",n);
	for(int i = 0 ; i< n ; i++){
		printf("%d\t",A[i]);
	}
}
//======//
void ChenX(int A[] , int &n , int k , int x){
	for(int i = n - 1 ; i>=k ; i--){
		 A[i+1] = A[i] ;
	}
	A[k] = x ;
	n = n + 1 ; 
}
//=========//
void XoaX(int A[] , int &n , int k ){//xoa tai phan tu k 
    if(k<n ){
    	for(int i = k ; i < n ; i++){
		A[i] = A[i+1];
	}
		n = n - 1 ; 
}

}                                
int main(int argc, char** argv) {
	Input(n);
	NhapMang(A,n);
	InMang(A,n);
	printf("\nnhap k: "); scanf("%d",&k);
//	printf("nhap gia tri can chen : "); scanf("%d",&x);
//	ChenX(A,n,k,x);
    XoaX(A,n,k);
	InMang(A,n);
	return 0;
}
