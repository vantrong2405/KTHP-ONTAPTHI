#include <iostream>
#define size 50
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , m , p , i ; 
int A[size], B[size];
//==============//
void Input(int &n , int &m){
	int code = 0 ; 
	do{
		printf("nhap n : "); code = scanf("%d",&n);
	}while(code==0 || n<=0 || n>size);
	//=========//
	do{
		printf("nhap m : "); code = scanf("%d",&m);
	}while(code==0 || m<=0 || m>size);
}
//Nhap mang A[size]
void MangA(int A[] , int &n){
	printf("Mang cua ban la A[%d]\n",n);
	for(int i = 0 ; i<n ; i++){
		printf("A[%d]: ",i); scanf("%d",&A[i]); 
	}
	printf("\n");
}
//Nhap mang B[size]
void MangB(int A[] , int &m){
	printf("Mang cua ban la B[%d]\n",m);
	for(int i = 0 ; i<m ; i++){
		printf("A[%d] : ",i); scanf("%d",&B[i]);
	}
	printf("\n");
}
//Xem Mang 
void XemMang(int A[], int B[] , int &n , int &m  ){
	printf("-----------=======Thong tin cua mang A[%d] :===========------------\n",n);
	for(int i = 0 ; i<n ; i++){
		printf("%d\t",A[i]);
	}
		printf("\n\n");
	printf("-----------=======Thong tin cua mang B[%d] :===========------------\n",m);
	for(int i = 0 ; i<m ; i++){
		printf("%d\t",B[i]);
	}
		printf("\n");
}
void ChenP(int A[] , int B[] , int n , int p ){
	if(p<n){
			printf("nhap vi tri can chen : "); scanf("%d",&p);
	for(int i = n - 1  ; i<= p ; i-- ){
		A[i+1] = A[i];
	}
}
	A[p] = B[i];
	n = n + 1 ;
	for(int i = 0 ; i<n ; i++){
		printf("%d\t",A[i]);
	}
}
int main(int argc, char** argv) {
	Input(n,m);
	MangA(A,n);
	MangB(A,m);
	XemMang(A,B,n,m);
	ChenP(A,B,n,p);
	return 0;
}
