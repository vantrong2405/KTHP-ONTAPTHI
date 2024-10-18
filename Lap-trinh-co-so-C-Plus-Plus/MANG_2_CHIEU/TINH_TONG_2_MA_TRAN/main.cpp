#include <iostream>
#define size 20
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , m ;
int A[size][size];//khai bao mang 2 chieu co toi da 20 hang va 20 cot 
int B[size][size];//khai bao mang 2 chieu co toi da 20 hang va 20 cot 
int C[size][size];
int i , j , k , h ;
//==================//
int Input(int &n , char c){
	int code = 0 ;
	do{
		printf(" nhap n : "); code = scanf("%d",&n); fflush(stdin);
	}while(code == 0 || n<=0 || n > size);
}

//========================//
void TaoMang(int M[][size] , int n , int m , char c ){
	for(i = 0 ; i<n ;i++)
		for(j = 0 ; j<m ; j++){
			printf("Nhap %c[%d][%d] = ",c,i,j);
			scanf("%d",&M[i][j]);
		}
}
//========================//
void XuatMang(int M[][size] , int n , int m   ){
	for(int i = 0 ; i<n;i++){
		for(int j = 0 ; j<m;j++)
		printf("%d",M[i][j]);
		printf("\n");
	}
	printf("\n");
}
//=====================//
void TongHaiMT(int A[][size] , int B[][size] , int C[][size],int n , int m ){
	for(int i = 0 ; i<n ; i++)
		for(j=0;j<m ; j++)
			C[i][j] = A[i][j] + B[i][j];
}

void TichHaiMT(int A[][size] , int B[][size] , int C[][size] , int m , int n , int h ){
	for( i = 0 ; i<m; i++)
		for(int j = 0 ; j < h ;j++)
	        for(int k = 0 ; k < m ; k++)
		C[i][j] = C[i][j] + A[i][k] * B[k][j];
}


int main(int argc, char** argv) {
  printf(" nhap n : "); scanf("%d",&n);//nhap kich thuoc hang 
  printf(" nhap m : "); scanf("%d",&m);// nhap kich thuoc cot 
  printf(" nhap h : "); scanf("%d",&h);	
  TaoMang(A,n,m,'A');
  XuatMang(A,n,m);
  TaoMang(B,m,h,'B');
  XuatMang(B,m,h);
  TichHaiMT(A,B,C,n,m,h);
  XuatMang(C,n,m);
//  TongHaiMT(A,B,C,n,m);
	return 0;
}
