#include<iostream>
using namespace std ; 
int main(){
	int S=0 , M  , n = 0 ;
	cout<<"Nhap M : ";
	cin>>M ;   
	for(int i = 0 ; i<=M ; i++){
		if(S>M){
			break;
		}else{
			S = S + (2 * i + 1);
			if(S<M){
				n++;
			}
		}
	}
	cout<<"n tim duoc la : "<<n<<endl;
	return 0 ;
}
