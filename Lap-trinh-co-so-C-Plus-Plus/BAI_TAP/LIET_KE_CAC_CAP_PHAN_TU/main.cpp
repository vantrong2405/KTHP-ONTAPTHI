#include <iostream>
using namespace std ; 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , j ; 
int A[50];
//=========//
void Input(int &n){
	cout<<"Nhap n : "; cin>>n ; //nhap kich thuoc mang 
}
//=======//
void TaoMang(int A[] , int &n){
	for(int i = 0 ; i<n ; i++){
		cout<<"A["<<i<<"] = "; cin>>A[i];
	}
}
//=======//
void XemMang(int A[] , int &n){
	cout<<"Thong tin mang A["<<n<<"] "<<endl;
	for(int i = 0 ; i<n ; i++)
	   cout<<A[i]<<"\t";
}
void LietKe(int A[] , int &n ){
	cout<<"\nCac cap gia tri cua A[i] la : "<<endl;
	for(int i = 0 ; i<n-1 ; i++)
		for(int j = i+1 ; j<n ; j++)
			cout<<"("<<A[i]<<","<<A[j]<<")"<<"\t";
}
int main(int argc, char** argv) {
	Input(n);
	TaoMang(A,n);
	XemMang(A,n);
	LietKe(A,n);
	return 0;
}
