#include <iostream>
#define size 20 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , A[size], x , k ; 
//======//
void Input(int &n){
	int code = 0 ; 
	do{
		printf("nhap n : "); code = scanf("%d",&n);
	}while(n<=0 || n>size || code == 0 );
}
//====//
void TaoMang(int A[] , int &n){
	for(int i = 0 ; i<n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]);
	}
}
//====//
void XuatMang(int A[] , int &n){
	printf("\n=================Thong tin mang===================\n");
	for(int i = 0 ; i<n ; i++){
		printf("%d\t",A[i]);
	}
	printf("\n");
}
//=====//
void XoaX(int A[] , int k , int &n ){// Xoa phan tu cua mang tai vi tri k . 
	if(k<n-1){
		for(int i = k ; i< n - 1 ; i++){
			A[i] = A[i+1]; 
 		}
		n = n - 1 ; //mat 1 phan tu 
	}
} 
int main(int argc, char** argv) {
	Input(n);//nhap kich thuoc mang 
	TaoMang(A,n);//nhap phan tu cua mang 
	XuatMang(A,n);
	printf("nhap vi tri can xoa : ");scanf("%d",&k);
	XoaX(A,k,n);
	XuatMang(A,n); 
	return 0;
}
