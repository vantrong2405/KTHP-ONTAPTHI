#include <iostream>
#define size 20 
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
int TimX(int &n , int A[] , int x ){
	int vitri = -1 ; //tuc la vi tri neu khong tim thay se la -1 
	for( i = 0 ; i<n ; i++ ){
		if(x == A[i]){
			vitri = i ;
		}
	}
	return vitri ; 
} 
int main(int argc, char** argv) {
	Input(n);
	TaoMang(n,A);
	XuatMang(n,A);
	printf("\nNhap gia tri can tim : "); scanf("%d",&x);
	if(TimX(n,A,x) == - 1){
		printf("%d khong co trong mang ",x);
	}else{
		printf("%d co trong mang tai vi tri thu %d",x,TimX(n,A,x));
	}
	return 0;
}
