#include <iostream>
#define size 50
#include<math.h> 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , x ;
int A[size];
//===============//
Input(int &n){
	int code = 0 ;
	do{
		printf("nhap kich thuoc mang : "); code=scanf("%d",&n); fflush(stdin);
	}while(code == 0 || n<=0 || n>size );
		printf("Mang cua ban la : A[%d]\n",n);
}
//===============//
void TaoMang(int &n , int A[]){
	for(int i = 0 ; i<n ; i++){
		printf("A[%d] =",i);
		scanf("%d",&A[i]);
	}
}
//================//
void XuatMang(int &n , int A[]){
	printf("============Thong tin cua mang==================\n");
	for(int i = 0 ; i<n ; i++)
	  printf("%d\t",A[i]);
}
//==============//
void Xoa_gtri(int &n , int A[] , int x){
	int vitri = -1 ;//co nghia la neu ko tim thay se la -1
	for(int i = 0 ; i<n ; i++){
		if(x == A[i]){
			vitri = i ;
		}
	}
	//Xoa//
	if(vitri != -1){
		for(int i = vitri ; i< n -1 ; i++){
			A[i] = A[i+1];
		}
		n = n - 1 ;	
	}
} 
//=================//
int KtraSnt(int &n){
	if(n<2) return 0 ; 
	for(int i = 2 ; i<=(int)sqrt(n) ; i++)
		if(n % i == 0 ) return 0 ;
	return 1 ; 
}
//==========//'
int DemSnt(int &n ,int A[]){
	int dem = 0 ; 
	for(int i = 0 ; i<n ; i++){
		dem = dem + KtraSnt(A[i]);
	}
	return dem ; 
}
	
int main(int argc, char** argv) {
	Input(n);
	TaoMang(n,A);
	XuatMang(n,A);
	printf("\nSo luong So nguyen to trong mang la : %d",DemSnt(n,A));
	printf("\nnhap gia tri can xoa : ");
	scanf("%d",&x);
	Xoa_gtri(n,A,x);
	XuatMang(n,A);
	return 0;
}
