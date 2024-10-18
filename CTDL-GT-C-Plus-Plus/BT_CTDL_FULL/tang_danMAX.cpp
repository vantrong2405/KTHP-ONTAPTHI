#include <iostream>
using namespace std ;
void  nhap_mang(int a[], int &n){
	cout<< "nhap vao n "; cin >> n;
	for(int i =0 ; i<n;i++){
		cin>>a[i]; 
	} 
}
void xuat_mang(int a[],int n){
	cout<<"mang co"<<n<<" phan tu la ";
	for(int i=0;i<n;i++){
		cout<<a[i] <<" ";
	} 
} 
int do_dai_tang(int a[],int n){
	int ht=1 ,kq =0 ;
	for(int i=0; i<n ;i++){
		if(a[i] > a[i+1]){
			ht=1; 
		} else{
			ht++; 
		} 
		kq =  max(kq,ht); 
	} 
	return kq; 
} 
main(){
	int a[100000],n;
	nhap_mang(a,n);
	int x=  do_dai_tang (a,n);
	cout<<x; 
} 