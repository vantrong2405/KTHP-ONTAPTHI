#include<iostream>
using namespace std ;
int total(int x){
	if(x==0){
		return 0;
	}else{
		return total(x-1) + x ; 
	}
}
 
int main(){
	int n ; 		
    cout<<"Nhap n : ";
	cin>>n;
	cout<<"Value 1 -> "<<n<<" la : "<<total(n);
	return 0 ; 
}
