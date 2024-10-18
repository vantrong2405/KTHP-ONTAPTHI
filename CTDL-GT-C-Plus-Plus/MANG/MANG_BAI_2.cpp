#include<iostream>
using namespace std ;
int A[100] ; int n ; int k ; 
void input(int &n){
	cout<<"Nhap n : "; cin>>n; 

}

void nhapMang(int A[] , int &n){
	cout<<"Mang cua ban la : A["<<n<<"] : "<<endl;
	for(int i = 0 ; i<n ; i++){
		cout<<"A["<<i<<"] = ";
		cin>>A[i];
	}
}

void nhapK(int &k){
		cout<<"Nhap k can tim kiem : "; cin>>k;
}

int timKiemNhiPhan(int A[] , int n , int k ){
	int trai = 0 , phai = n - 1 , giua ;
	while(trai<= phai){
		giua = (trai + phai)/2;
	if(A[giua] == k ){
		return true ; 
	}else if(A[giua] > k){
		phai = giua - 1 ; 
	}else{
		trai = giua + 1 ; 
	}
}
return false ; 
}

int deQuyNhiPhan(int A[] , int n , int k ){
	if(t > p){
		return false;
	}
	
	int g = (t+p)/2;
	
}
 
int main(){
	input(n);
	nhapMang(A,n);
	nhapK(k);
	int x = timKiemNhiPhan(A,n,k);
	if(x == true){
		cout<<"Da tim thay k "<<endl;
	}else{
		cout<<"Chua tim thay K "<<endl;
	}
	return 0 ; 
}
