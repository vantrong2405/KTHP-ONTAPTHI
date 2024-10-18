#include<iostream>
using namespace std ;
int UCLN(int a , int b){
	if(a == b){
		return a ;
	}else if(a > b){
		return UCLN(a-b,b);
	}else{
		return UCLN(a , b-a);
	}
} 
int main(){
	int a , b ; 
	cout<<"Nhap a : "; cin>>a;
	cout<<"Nhap b : "; cin>>b; 
	cout<<"UCLN("<<a<<","<<b<<") = "<<UCLN(a,b)<<endl;
	
	return 0 ; 
}
