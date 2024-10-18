#include<iostream>
using namespace std ; 
	int *A = new int[100];
	int n ; 
	void Input(){
		cout<<"Nhap so luong mang : ";
		cin>>n;
	}
	
	void taoMang(){
		cout<<"Nhap phan tu mang : "<<endl;
		for(int i = 0 ; i<n ; i++){
			cout<<"A["<<i<<"] = ";
			cin>>A[i];
		}
	}
	
	void xemMang(){
		cout<<"Mang cua ban la : ";
		for(int i = 0 ; i<n ; i++){
			cout<<A[i]<<"\t";
		}
	}
	
	int soDao(int x){
		int S = 0 ;
		while(x != 0){//56782=> 28765
			int laySo = x % 10 ; //2
			S = S * 10 + laySo;
			x = x / 10;
		}
		return S ; 
	}
	
	bool soDoiXung(int y){
		if(soDao(y)==y && y >10) return true ; 
		return false;
	}
	
	void kiemTraSDX(){
		cout<<"\nSo doi xung co trong mang : ";
		for(int i = 0 ; i<n ; i++){
			if(soDoiXung(A[i])==true){
				cout<<A[i]<<"\t";
			}
		}
	}
	
int main(){
     Input();
     taoMang();
	 xemMang();
	 kiemTraSDX();
	return 0 ; 
}
