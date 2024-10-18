#include <iostream>

using namespace std;
int n , A[1000] , B[1000] , C[1000] , nA , nB , nC;
void nhapMang(int &n , int A[]){
  cout<<"Nhap so luong phan tu mang : "<<endl;
  cin>>n; 
  for(int i = 0 ; i<n ; i++){
  	cout<<"A["<<i<<"] = "; 
  	cin>>A[i];
  }	
}


int main()
{
	nhapMang(n,A);
	nhapMang(n,B);
//	xuatMang(A,B,C,nA,nB,nC);
	return 0;
}
