#include <iostream >
using namespace std ;
int len(char a[]){
	int i = 0 ;
	while(true){
		if(a[i]=='\0'){
			return i; 
		} 
		i++; 
	} 
} 
void left(char a[], int n){
	a[n] ='\0'; 
} 
void right(char a[ ] , int n){
	int lenA= len(a);
	for(int i=0;i<=n;i++){
		a[i] = a[lenA - n+i]; 
	} 
} 
void mid(char  a[],int k,int n){
	left(a,n+k-1);
	right(a,n); 
} 
main(){
	char a[100000];int  n, k; 
	cout<<"nhap chuoi "; cin. getline(a,10000) ;
	cout<< " nhap n";cin>>n ;
	left(a,n);
	cout<<a; 
}