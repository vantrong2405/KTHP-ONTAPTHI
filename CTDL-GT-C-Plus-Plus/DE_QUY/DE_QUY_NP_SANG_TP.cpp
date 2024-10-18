#include<iostream>
using namespace std ; 
int chuyenNhiPhan(int n ){
	if(n==0){
		return 0 ; 
	}else{
		return chuyenNhiPhan(n/2) * 10 + n % 2 ; 
	}
}

int main(){
	int n ;
	cout<<"Nhap n : "; 
	cin>>n; 
	cout<<"Chuyen sang nhi phan : "<<chuyenNhiPhan(n);
	
	
	return 0 ;
}
