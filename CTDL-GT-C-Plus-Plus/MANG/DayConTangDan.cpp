#include<iostream>
#include<cstring>
using namespace std ;
int A[1000] , n , B[100] , kq ;

void nhapMang(int &n , int A[]){
	cout<<"Nhap n : "; cin>>n ;
    for(int i = 0 ; i<n ; i++){
    cin>>A[i];
	}
}

void xuatMang(int n , int A[] , string cauDan){
	cout<<cauDan<<endl;
	for(int i = 0 ; i<n ; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}

int soLuongDayConTang(int n , int A[]){
	int dem = 0 , kq = 0 ; 
	for(int i = 0 ; i<n ; i++){
		if(A[i] < A[i+1]){
			dem++;
		}else{
			dem = 1 ; 
		}
		kq = max(kq , dem);
	}
	return kq ; 
}

void inDayConTang(int n, int A[], int B[]) {
    int dem = 0 , start = 0 , end = 0 , kq = 0 ; 
    for(int i = 0 ; i<n-1 ; i++){
    	if(A[i] < A[i+1]){
    		dem++;//dem vi tri
		}else{
			if(dem > kq){
				kq = dem ; 
				end = i ; //bóc ra vi trí cuoi cua thang dem 
			}
			dem = 1 ;// reset dem = 0 
		}
	}

	start = end - kq + 1 ; 
	for(int i = start ; i<=end ; i++){    
		B[i-start] = A[i];
	}
	cout<<"2. Day con tang dan : ";
	for(int i = 0 ; i<kq ; i++){
		cout<<B[i]<<" "; z  
	}
}
int main(){
	nhapMang(n,A);
	xuatMang(n,A,"Mang cua ban la : ");
	cout<<"1. So luong day con tang dan trong mang : "<<soLuongDayConTang(n,A)<<endl;
	inDayConTang(n,A,B);
 
	return 0 ; 
}
