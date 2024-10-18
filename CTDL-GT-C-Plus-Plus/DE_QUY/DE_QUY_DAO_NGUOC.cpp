#include<iostream>
#include <sstream>
#include<cstring>
using namespace std ;
int daoNguoc(int n){
	static int k = 0 ; // duy tri gia tri cua cac bien ko reset lai khi goi lai ham ( static)
	if(n == 0 ){
		return k ; 
	} 
	int x = n % 10 ; //lay so du
	k = k * 10 + x ; 
	return daoNguoc(n/10); 
} 
int main(){
	int n ; 
	cout<<"Nhap n : "; cin>>n;
	cout<<"Ket qua : "<<daoNguoc(n);
	return 0 ; 
}

