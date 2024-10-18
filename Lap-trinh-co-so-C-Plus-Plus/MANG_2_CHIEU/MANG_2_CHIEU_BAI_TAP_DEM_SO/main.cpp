#include <iostream>
#include<math.h>
#define size 20
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , m ;
int M[size][size];//khai bao mang 2 chieu co toi da 20 hang va 20 cot 
int NgTo , k , h ;
//==================//
int Input(int &n , char c){
	int code = 0 ;
	do{
		printf(" nhap n : "); code = scanf("%d",&n); fflush(stdin);
	}while(code == 0 || n<=0 || n > size);
}

//========================//
void TaoMang(int M[][size] , int n , int m  ){
	for(int i = 0 ; i<n;i++){
		for(int j = 0 ; j<m;j++){	
		printf("M[%d][%d] =",i,j);
		scanf("%d",&M[i][j]);	
		}
	}
}	
//========================//
void XuatMang(int M[][size] , int n , int m   ){
	printf("====================In Mang===================\n");
	for(int i = 0 ; i<n;i++){
		for(int j = 0 ; j<m;j++)
		printf("%d ",M[i][j]);
		printf("\n");
	}
	printf("\n");
}

int Sochan(int M[][size] , int n , int m ){
	int dem = 0 ;
	for(int i = 0 ; i,n ; i++)
		for(int j = 0 ; j < m ; j ++)
			if(M[i][j] % 2 == 0 )
				dem = dem + 1 ;
	return dem ;
}

//=========================//
int Ngto(int n ){
	if( n == 1 ) return 0 ;
	for(int i = 2 ; i<=(int)sqrt(n)+1;i++)
		if(n% i == 0 ) return 0 ;
	else{
		return 1 ;
	}
}

//==================//
int DemNgto(int M[][size],int n,int m){
	int ngto = 0 ;
	for(int i = 0 ; i<n ; i++)
		for(int j = 0 ; j < m ; j ++ )
			if(Ngto(M[i][j])==1)
			ngto = ngto + 1 ;
	return ngto ;
}
//==================//
void DoiHang(int M[][size] , int n , int m , int k , int h ){
	for(int i = 0 ; i<n ; i++){
		int tam = M[k][i];
		M[k][i] = M [h][i];
		M[h][i] = tam ;
	}
}
//=====================//
void DoiCot(int M[][size] , int n , int m , int k , int h ){
	for(int j = 0 ; j<m;j++){
		int tam = M[j][k];
		M[j][k] = M[j][h];
		M[j][h] = tam ; 
	}
}
	
int main(int argc, char** argv) {
  Input(n,'n');
  Input(m,'m');
	TaoMang(M,n,m);	
	XuatMang(M,n,m);
	int DemSoChan = Sochan(M,n,m);
	printf("Sochan = %d",DemSoChan);
	int ngto = DemNgto(M,n,m);
	printf("So nguyen to = %d",ngto);
	DoiHang(M,n,m,k,h);
	DoiCot(M,n,m,k,h);
	return 0;
}
