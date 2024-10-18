#include <iostream>
using namespace std ;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int S = 1 , n , i ; 
int tinhtonggiaithua(int n ){
	if(n == 1 ) return 1 ;
	else{
		return  n + tinhtonggiaithua(n-1);
	} 
}
//=====//
int CauB(){
	for(int i = 1 ; i<=n ; i++){
		S = S*i;
	}
	return S ; 
}
//
int main(int argc, char** argv) {
	cout<<"Nhap n : "; cin>>n;
	cout<<"Tong giai thua la : "<<tinhtonggiaithua(n)<<endl;
	cout<<"Sn = "<<CauB()<<endl;
	return 0;
}
