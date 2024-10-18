
#include <iostream>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i ,j, x , k = 0  ;
int A[200];
//======================//
void Input(int &n , char c ){
	int code = 0 ; 
	do{
		printf("nhap %c = ",c); code = scanf("%d",&n); fflush(stdin);
		printf("Mang cua ban la : A[%d]\n",n);
	}while(code == 0 || n <= 0 || n > 200  );
}
//Tao mang //
void TaoMang(int n , int A[]){
	for(int i = 0 ; i<n ; i++){
		printf("A[%d] = ",i);
		scanf("%d",&A[i]);
	}
}
// In mang //
void XemMang(int &n , int A[]){
	for(int i = 0 ; i<n ; i++){
		printf("%d\t",A[i]);
	}
	printf("\n");
}
void XoaX(int &n , int k , int A[] ){
//	if(k< n-1)
		for(int i = k ; i< n -1 ; i++)
			A[i] = A[i+1]; 
			n = n - 1 ; 
}
int main(int argc, char** argv) {
 Input(n,'n');
 TaoMang(n,A);
 XemMang(n,A);
printf("\nnhap k : "); scanf("%d",&k);
XoaX(n,k,A);
 printf("Mang sau khi xoa la :\n");
 XemMang(n,A);
return 0 ; 
}

