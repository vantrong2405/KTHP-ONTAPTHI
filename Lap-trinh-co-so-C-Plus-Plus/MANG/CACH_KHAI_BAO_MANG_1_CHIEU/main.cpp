#include <iostream>
#define size 20 
#include<math.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , vitri , x ; 
int A[size];
void Input(int &n  ){
	int code = 0 ; 
	do{
	printf("nhap n : "); code = scanf("%d",&n);
	printf("Mang cua ban la : A[%d]\n",n);
	}while(code == 0 || n<=0);
}
//Tao mang //
void TaoMang(int &n , int A[] ){
	for( i = 0 ; i<n ; i++){
		 printf("A[%d] = ",i); scanf("%d",&A[i]);
	}
	 
}
//In mang //
void XuatMang(int &n , int A[] ){
	printf("============Thong tin cua mang=============\n");
	for( i = 0 ; i<n ; i++)
	  printf("%d\t",A[i]);
}
void XoaX(int &n , int A[] , int x ){
	int vitri = -1 ; //tuc la vi tri neu khong tim thay se la -1 
	for( i = 0 ; i<n ; i++ ){
		if(x == A[i]){
			vitri = i ;
		}
	}
	for(int i = vitri ; i< n -1 ; i++){	
			A[i] = A[i+1]; 
		}
			n = n - 1 ;  
} 
//============//
int KtraSnt(int n ){
	if(n<2) return 0 ;// neu n < 2 thi n ko phai snt  nen return 0  
	for(i = 2 ; i<=(int)sqrt(n) ; i++)
		if(n % i == 0 ) return 0 ;// neu n % i tuc la so do co uoc vay no k phai snt return 0  	
     return 1 ;// xong tren neu k co cai nao dung thi return 1 (1 dung 0 sai ) 
}	
//Dem snt //
int DemSnt(int n , int A[]){
	int dem = 0  ; 
	for(i = 0 ; i<n ; i++)
		dem = dem + KtraSnt(A[i]); 
	return dem ;
} 
int main(int argc, char** argv) {
	Input(n);
	TaoMang(n,A);
	XuatMang(n,A);	
	printf("\nCac so nguyen to trong mang la : %d ",DemSnt(n,A)); 
	printf("\nNhap gia tri can tim va xoa gia tri do : "); scanf("%d",&x);
	XoaX(n,A,x);
	XuatMang(n,A);
	return 0;
}
