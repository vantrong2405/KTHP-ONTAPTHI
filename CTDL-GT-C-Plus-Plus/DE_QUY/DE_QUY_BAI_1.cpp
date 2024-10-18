#include<iostream>
#include<string>
#include <sstream>
using namespace std ; 

long long giaiThua(long long x){
	if(x == 1 ){
		return 1 ; 
	}else{
		return giaiThua(x-1) * x ; 
	}
}
int main(){
	long long n ; 
	cout<<"Nhap n : ";
	cin>>n;
	stringstream ss;//nhan vao number
	ss<<giaiThua(n);
	string x = 	ss.str();//chuyen doi tham so ss( dang kieu number) thanh string
	int count = 0 ; 
	for(int i = 0 ; i<x.length();i++){
		if(x[i] != '0'){
			count = 0 ;
		}else{
			if(x[i] == '0' ){
			count++;
		}
		}
		}
		
		cout<<"Gia tri cua GiaiThua("<<n<<") = "<<giaiThua(n)<<endl;
		cout<<"So luong ky tu 0 la  : "<<count<<endl;
	
	return 0 ;
	
	}
