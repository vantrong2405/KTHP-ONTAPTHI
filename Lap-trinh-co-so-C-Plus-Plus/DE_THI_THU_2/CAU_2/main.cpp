#include <iostream>
#define size 50
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , m , i , j ;
int p ; 
int A[size] , B[size];
void Input(int &n , int &m  ){
	int code = 0 ; 
	do{
		printf("nhap n : "); code = scanf("%d",&n);
	}while(n>size || n<=0 || code == 0);
	//===//
	do{
		printf("nhap m : "); code = scanf("%d",&m);
	}while(m>size || m<= 0 || code == 0);
}
//====//
void MangA(int n){
	printf("Mang cua ban la : A[%d]\n",n);
	for(int i = 0 ; i< n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]); 
	}
}
//====//
void MangB(int m ){
	printf("\nMang cua ban la : B[%d]\n",m);
	for(int i = 0 ; i<m ;i++){
		printf("B[%d] = ",i);  scanf("%d",&B[i]);
	}
}
//=====//
void XemA(int n , int A[]){
	printf("\nThong tin cua mang A la :\n ");
	for(int i = 0 ; i< n ; i++){
		printf("%d\t",A[i]);
	}
}
//=====//
void XemB(int &m , int B[]){
	printf("\nThong tin cua mang B la :\n ");
	for(int i = 0 ; i<m ; i++){
		printf("%d\t",B[i]);
	}
}
//===//
void ChenMang(int &n , int &m , int p , int A[] , int B[] ){
	printf("nhap vitri can chen : "); scanf("%d",&p);
	if(p<n){
		for(int i = m + n - 1 ; i>= p ; i--){
			A[i] = A[i-m];
		}
	for(int i = p ; i<p+m ; i++)
		A[i] = B[i-p]; 		
	}
}
int main(int argc, char** argv) {
	Input(n,m);
	MangA(n);
	MangB(m);
	XemA(n,A);
	XemB(m,B);
    ChenMang(n,m,p,A,B);
    printf("\nMang A sau khi chen la :\n");
    XemA(m + n,A);
	return 0;
}
