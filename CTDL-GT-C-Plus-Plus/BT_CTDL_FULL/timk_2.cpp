#include <iostream>
using namespace std ;
void  nhap_mang(int a[], int &n){
	cout<< "nhap vao n "; cin >> n;
	for(int i =0 ; i<n;i++){
		cin>>a[i]; 
	} 
}
int tim_k(int a[ ],int n,int k){
	int trai =0,phai = n-1 ,giua ;
	while(trai<= phai){
		giua = (trai + phai) /2;
		if(a[giua]== k){
			return true ;
		} else if (a[giua]>k){
			phai =giua -1 ; 
		} else{
			trai = giua +1 ;
		} 
	} 
	return false ;
} 
main(){
	int a[100000],n,k;
	nhap_mang(a,n);
	cout<<" nhap k"; cin >>k ; 
	int x= tim_k(a,n,k);
	if(x){
		cout<<" da tim thay k"; 
	} else{
		cout << " ko tim thây";
	}
} 
 tim k