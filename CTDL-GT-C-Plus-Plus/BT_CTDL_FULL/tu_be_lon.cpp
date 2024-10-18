#include <iostrem>
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
void tao_mang(int a[],int na,int b[],int nb,int c[],int nc){
	nc= na+nb;int i=0,j=0 ;
	for(int k=0;k<nc;k++){
		if(a[i]<b[j]||j==nb){
			c[k]= a[i];i++; 
		} else{
			c[k]= b[j];j++ ;
		} 
	} 
} 
main(){
	int a[100000],b[1000000],c[1000000],na,nb,nc ;
	nhap_mang(a,na);
	nhap_mang(b,nb);
	tao_mang(a,na,b,nb,c,nc);
	xuat_mang(c,nc); 
}  
ghép 2 mang sắp xếp  từ bé đén lớn