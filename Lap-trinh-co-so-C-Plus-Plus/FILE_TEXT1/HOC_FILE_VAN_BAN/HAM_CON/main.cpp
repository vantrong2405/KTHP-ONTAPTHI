#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
 FILE *f ;
int n , k , x ; 
int A[20];
//===================//
void DOCFILE(int &n , char * tenfile){
	f = fopen(tenfile,"w");
	if(f == NULL){
		return ;
	}
	while(!feof(f)){
		fscanf(f,"%d",&A[n]);//doc file neu no chua phai phan tu cuoi cung trong file
		n = n + 1 ; // mang se tang them 1 cho dem khi ket thuc ;  
 }
}
//===================//
void GHIFILE(int &n , char * tenfile){
	for(int i = 0 ; i< n ; i++){
		printf("%d\t",A[i]);
	}
}

//Sap xep tang dan 
void SapXep(int &n){
	for( int i = 0 ; i < n ; i++ )
		for(int j = i + 1 ; j < n ; j++)
		  if(A[i] > A[j]){
		  	 int tam = A[i];
			 A[i] = A[j];
			 A[j] = tam ;  
	}
	printf("\nFILE sau khi sap xep la :\n ");
}
//====================//
//chen x ;
void ChenX(int &n , int k , int A[] , int x){
 printf("\nnhap x : "); scanf("%d",&x);
 printf("\nnhap k : "); scanf("%d",&k);
 printf("\nFILE sau khi Chen la :\n ");
	if(k<n){
		for(int i = n - 1 ; i>=k ; i--){
			A[i+1] = A[i];
		}	
	}
	A[k] = x ;
	n = n + 1 ;
}
//=============//
int main(int argc, char** argv) {
	DOCFILE(n,(char*)"Test.txt");
	GHIFILE(n,(char*)"Test.txt");
	SapXep(n);
	GHIFILE(n,(char*)"Test.txt");
	ChenX(n,k,A,x);
	GHIFILE(n,(char*)"Test.txt");
	return 0;
}
