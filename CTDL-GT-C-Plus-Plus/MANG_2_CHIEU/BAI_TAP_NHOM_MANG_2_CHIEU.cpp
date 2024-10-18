#include<iostream>
using namespace std ;



void nhapMang(int A[][100] , int n , int m ){
	cout<<"Nhap gia tri cho mang A : "<<endl;
	for(int i = 0 ; i<n ; i++){
		for(int j = 0 ; j<m ;j++){
			cout<<"A["<<i<<"]["<<j<<"] = "; cin>>A[i][j];
		}
	}
}

void xuatMang(int A[][100], int n , int m ){
	cout<<"Thong tin mang A : "<<endl;
	for(int i = 0 ; i<n ;i++){
		for(int j = 0 ; j < m ; j++){
			cout<<A[i][j]<<" ";
		}
		cout<<endl;
	}
}

//cau 3 
void demSoLanXuatHien(int A[][100] , int n , int m ){
	const int MAX_VALUE = 1000 ; 
	int count[MAX_VALUE] = {0};
	for(int i = 0 ; i<n ; i++){
		for(int j = 0 ; j<m ; j++){
			if(A[i][j] > 0 && A[i][j] < MAX_VALUE){
				count[A[i][j]]++;
			}
		}
	}
	
	for(int i = 1 ; i<MAX_VALUE;i++){
		if(count[i] > 0){
			cout<<"So "<<i<<" xuat hien : "<<count[i] <<" lan"<<endl;
		}
	}
}


//cau 4 
int tinhTongHang(int A[] , int m){
	int tong = 0 ; 
	for(int i = 0 ; i<m ; i++){
		tong = tong + A[i];
	}
	return tong ; 
}

void sapXepTheoTongHang(int A[][100] , int n , int m ){
	for(int i = 0 ; i<n-1 ; i++){
		for(int j = 0 ; j<n-1 ; j++){
			int tong_j = tinhTongHang(A[j] , m);
			int tong_j1= tinhTongHang(A[j+1] , m);
			if(tong_j > tong_j1){
				for(int k = 0 ; k<m ; k++){
					swap(A[j][k] , A[j+1][k]);
				}
			}
		}
	}
}




 
int main(){
	int n , m , A[100][100];
	cout<<"Nhap n hang : "; cin>>n;
	cout<<"Nhap m cot : "; cin>>m;
	nhapMang(A,n,m);
	demSoLanXuatHien(A,n,m);
//	sapXepTheoTongHang(A,n,m);
//	cout<<"Mang cua ban sau khi sap xep la : "<<endl;
//	xuatMang(A,n,m);
	return 0 ;
}
