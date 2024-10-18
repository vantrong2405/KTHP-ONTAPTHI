#include<iostream>
using namespace std ; 

void nhapMang(int a[][100] , int n , int m ){
	cout<<"Nhap gia tri cho mang a : "<<endl;
	for(int i = 0 ; i<n ; i++){
		for(int j = 0 ; j<m ; j++){
			cout<<"a["<<i<<"]["<<j<<"] = "; cin>>a[i][j];
		}
	}
}


int tinhTong(int a[][100] , int n , int m ){
	int tong = 0 ; 
	for(int i = 0 ; i<n ; i++){
		for(int j = 0 ; j<m ; j++){
			tong = tong + a[i][j];
		}
	}
	return tong ;
}

void inMang(int a[][100] , int n , int m){
	cout<<"Mang a : "<<endl;
	for(int i = 0  ; i<n ; i++){
		for(int j = 0 ; j<m ; j++){
			cout<<a[i][j]<<" ";
		}
	}
}
int main(){
	int  n , m , a[100][100];
	cout<<"Nhap so hang : "; cin>>n ; 
	cout<<"Nhap so cot : "; cin>>m;
	nhapMang(a,n,m);
    inMang(a,n,m);
    cout<<"\n Tong cac so trong mang a la : "<<tinhTong(a,n,m)<<endl;
	return 0 ; 
}
