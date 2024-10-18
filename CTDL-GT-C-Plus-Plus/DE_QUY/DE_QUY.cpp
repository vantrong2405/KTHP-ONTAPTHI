#include<iostream>
#include<cstring>
#include <sstream>
using namespace std ;
stringstream ss;//nhan vao number 
string chuyenSangNhiPhan(int n){
 if(n>0){
 	int value = n % 2 ; 
	ss<<value;
	string x = n % 2 ;
 	return x + ""+ chuyenSangNhiPhan(n/2) ;
 }else{
 	return "" ; 
 }
}

int main(){
	int n ;
	cout<<"Nhap n : "; 
	cin>>n;
	cout<<"Nhi phan cua "<<n<<" la : "<<chuyenSangNhiPhan(n);
  
	return 0; 
}
