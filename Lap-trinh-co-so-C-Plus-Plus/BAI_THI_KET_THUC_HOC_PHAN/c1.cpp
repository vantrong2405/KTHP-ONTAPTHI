#include<iostream>
#include<cstring>
using namespace std ; 
int main(){
	string n ;
	cout<<"Nhap chuoi : "; 
	getline(cin,n);
	int dem = 0 ;
	for(int i = 0 ; i<n.size();i++){
		if((n[i] >='A' && n[i] <='Z')){
			dem = dem + 1 ; 
		}
	}
	cout<<"So luong ky tu in hoa la : "<<dem;
	return 0 ; 
}
