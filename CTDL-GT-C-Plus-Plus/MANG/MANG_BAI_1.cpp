#include<iostream>
using namespace std ; 
int A[100];
int n ; 
void input(int &n){
	cout<<"Nhap n : "; cin>>n;
}
void nhapMang(int n , int A[]){
	cout<<"Nhap phan tu cua mang : A["<<n<<"] "<<endl;
	for(int i = 0 ; i<n ; i++){
		cout<<"A["<<i<<"] = ";
		cin>>A[i];
	}
}

void xuatMang(int n , int A[]){
	cout<<"Mang cua ban la : "<<endl;
	for(int i = 0 ; i<n ; i++){
		cout<<A[i]<<"\t";
	}
}
int main(){
	input(n);
	nhapMang(n,A);
	xuatMang(n,A);	
	return 0 ; 
}
