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
//Tim x //
	int TimX(int x , int A[] , int n ){
		int vitri = -1 ;//luc nay neu vi tri khong tim thay thi la -1 
		for(int i = 0 ; i<n ; i++){
			if(x == A[i]){   
				vitri = i ;
			}
		}
		return vitri ;
	}
//Xoa X //
void XoaX(int &n , int k , int A[] ){
	if(k< n-1)
		for(int i = k ; i< n -1 ; i++)
			A[i] = A[i+1]; 
			n = n - 1 ; 
}
//chen x ;
void ChenX(int &n , int k , int A[] , int x){
	if(k<n){
		for(int i = n - 1 ; i>=k ; i--){
			A[i+1] = A[i];
		}	
	}
	A[k] = x ;
	n = n + 1 ;
}
//Xoa snt //
int KTSoNgto(int n){
    if(n<2)
        return 0;
    else{
        for(int i=2;i<=n/2;i++)
            if(n%i==0)
                return 0;
        return 1;
    }
}
void Xoa(int A[], int vt, int &n){
    for(int i=vt;i<n;i++)
        A[i]=A[i+1];
    n--;
}
 
void XoaSnt(int A[], int &n){    
    for(int i=0;i<n;i++){
        if(KTSoNgto(A[i])){
            Xoa(A,i,n);
            i--;
        }
    }
}
//Xoa cac phan tu trung nhau 
void XoaTrung(int A[],int &n){
   for (i=0;i<n-1;i++){
    j=i+1;
    while (j<n)
      if (A[i]==A[j]){
         for (k=j;k<n-1;k++) A[k]=A[k+1];
         n=n-1;
      }
      else j=j+1;
   }
} 

int main(int argc, char** argv) {
 Input(n,'n');
 TaoMang(n,A);
 XemMang(n,A);
 printf("\nnhap x : "); scanf("%d",&x);
  int k = TimX(x,A,n);
  if(k == -1){
 	printf("%d khong co trong mang '-1'\n",x);
 }else{
 	printf("%d nam tai vi tri thu '%d'\n ",x,k);
 }
 printf("\nnhap k : "); scanf("%d",&k);
 ChenX(n,k,A,x);
 printf("Mang sau khi chen la :\n");
 XemMang(n,A);
 XoaX(n,k,A);
 printf("Mang sau khi xoa la :\n");
 XemMang(n,A);
 printf("Mang sau khi da xoa so nguyen to la :\n");
 XoaSnt(A,n);
 XemMang(n,A);
 XoaTrung(A,n);
 printf("Mang sau khi xoa phan tu trung nhau:\n");
 XemMang(n,A);
 return 0 ;	
}
