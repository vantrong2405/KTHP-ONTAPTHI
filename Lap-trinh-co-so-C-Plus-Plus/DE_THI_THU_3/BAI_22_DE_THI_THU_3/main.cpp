#include <iostream>
#define size 20 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , k , S = 0 ; 
int A[size];
//=========//
void Input(int &n){
	int code = 0 ; 
	do{
		printf("Nhap kich thuoc mang : "); code = scanf("%d",&n);
	}while(code == 0 || n > size || n<= 0);
} 
//===========//
void TaoMang(int A[] , int &n){
	for(int i = 0 ; i<n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]);
	}
}
//=============//
void XemMang(int A[] , int &n){
	printf("\n=====Thong tin mang =======\n");
	for(int i = 0 ; i< n ; i++){
		printf("%d\t",A[i]);
	}
}
//===========//
int SoLe(int A[] , int &n){
	for(int i = 0 ; i<n ; i++){
		if(A[i] % 2 == 1 ){
		   S = S + A[i];
		}
	}
	return S ; 
}
void XoaX(int A[] , int &n , int k ){
	do{
		printf("\nnhap vi tri can xoa : ");
		scanf("%d",&k);
	}while(k>=n);
	for(int i = k ; i< n - 1 ; i++){//k la vi tri can xoa 
		A[i] = A[i + 1];//tuc la vi du mang thu 1 se mang gia tri cua mang thu 2 va mang thu 2 se giu nguyen
	}
	n = n - 1 ; //xoa mang thu 2 
}
int main(int argc, char** argv) {
    Input(n);
	TaoMang(A,n);
	XemMang(A,n);
	printf("\nTong cac so le trong mang la : %d",SoLe(A,n));
	XoaX(A,n,k);
	XemMang(A,n);//sau khi xoa xem lai mang lan nua 
    return 0;
}
