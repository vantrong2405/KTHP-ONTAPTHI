#include<iostream>
using namespace std ; 
int fibo(int n ){
	if(n < 4){
		return n;
	}else{
		return fibo(n-1) + fibo(n-2);
	}
}
int main(){
    int n ; 
    cout<<"Nhap n : ";
    cin>>n;
    cout<<"Ket qua : "<<fibo(n);
	return 0 ; 
}
