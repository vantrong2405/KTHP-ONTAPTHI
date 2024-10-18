#include <iostream>
using namespace std ;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , i , dem ; 

//=============// 
void TaoMang(int &sopt , int *&A[]){
	cout<<"Nhap Thong tin mang A["<<n<<"]"<<endl;
	for(int i = 0 ; i<n ; i++){
		cout<<"A["<<i<<"] = "; cin>>A[i];
	}
}
//========//
void XemMang(int &n , int A[]){
	cout<<"Thong tin mang : "<<endl;
	for(int i = 0 ; i<n ; i++){
		cout<<A[i]<<"\t";
	}
}
int main(int argc, char** argv) {
	int n ;
	cout<<"Nhap n : "; cin>>n; 
	int *A = new int[n];
	TaoMang(n,A);
	XemMang(n,A);
	return 0;
}
