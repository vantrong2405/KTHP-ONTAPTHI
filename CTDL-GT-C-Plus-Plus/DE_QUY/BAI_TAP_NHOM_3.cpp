#include<iostream>
#include<math.h>
using namespace std ;
int n , A[100] ;

void input(int &n) {
	cout<<"Nhap n : ";
	cin>>n;
}

void nhapMang(int A[] , int n) {
	cout<<"Nhap so phan tu cua mang :  A["<<n<<"]"<<endl;
	for(int i = 0 ; i<n ; i++) {
		cout<<"A["<<i<<"] = ";
		cin>>A[i];
	}
}

void checkK(int a[], int N){
	int k;
	cin>>k;
	for(int i = 0 ; i<N ; i++ ) { 
		if(a[i] ==  k ) { 
		cout<<"CO";
			break; 
		}
	} 
}

int tBinhChan(int a[], int n ) {
	int tb = 0,count = 0 ;
	for(int i =0 ; i<n; i++ ) {
		if(a[i] % 2 == 0 ) {
			count++ ;
			tb+=a[i];
		}
	}
	tb = tb / count;
	return tb;
}

void xuatMang(int A[] , int n) {
	cout<<"Mang cua ban la : ";
	for(int i = 0 ; i<n ; i++) {
		cout<<A[i]<<"\t";
	}
}

bool checkNT(int n) {
	if(n < 2 ) return false;
	for(int i = 2 ; i<=sqrt(n); i++) {
		if(n % i  == 0 )  {
			return false;
		}
	}
	return true;
}

int main() {
	input(n);
	nhapMang(A,n);
//	xuatMang(A,n);
//	cout<<tBinhChan(A,n);
//	for(int i =0 ; i < n ; i++ ) {
//		if(checkNT(A[i])) {
//			cout<<A[i]<< " ";
//		}
//	}
	checkK(A, n);
	return 0 ;
}
