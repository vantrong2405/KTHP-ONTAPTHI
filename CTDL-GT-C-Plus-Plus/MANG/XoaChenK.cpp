//cho mang a gom n phan tu , nhap vao k ,hay chen vao dau mang  2 7 1 4 8 , k = 9 => dap so : 9 2 7 1 4 8 

#include<iostream>
using namespace std ;
int n , A[1000] , k ;
void nhapMang(int &n , int A[]){
	cout<<"Nhap n : ";
	cin>>n;
	for(int i = 0 ; i<n ; i++){
		cin>>A[i];
	}
} 

void xuatMang(int n , int A[]){
	cout<<"Mang cua ban la : "<<endl;
	for(int i = 0 ; i<n ;i++){
		cout<<A[i]<<"\t";
	}
}

void chenK(int A[] ,int &n , int &k){
//	cout<<"Nhap k : "; cin>>k;
	for(int i = n ; i>0 ; i--){
		A[i] = A[i-1];
	}
	A[0] = k;
	n = n + 1 ; 
}


void xoaK(int A[] , int &n , int &k){
	cout<<"Nhap vi tri can xoa : "; cin>>k;
	n--;
	for(int i = k ; i<n ; i++ ){
		A[i] = A[i+1];
	}
}

void xoaGiaTriK(int A[] , int &n , int &k){
	for(int i = 0 ; i<n ; i++){
		if(k == A[i]){
			xoaK(A,n,k);
		}
	}
}

int main(){
	nhapMang(n,A);
	xuatMang(n,A);
	cout<<endl;
//	chenK(A,n,k);
//	xuatMang(n,A);
	xoaK(A,n,k);
	xuatMang(n,A);
//	xuatMang(n,A);
//cout<<"n la  :"<<n ;
	return 0 ;
} 
