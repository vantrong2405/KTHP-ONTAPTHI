#include <iostream>
using namespace std;
struct sv{
			int msv;
	char hoten[100],xl;
	float cc,gk,ck,tk;
	};
		char tinh_xep_loai(float tk){
		char xl ;
		if(tk>= 8.5){
			xl='A'; 
		} else if(tk>7){
			xl='B'; 
		} else if(tk>=5.5){
			xl='c';
			 
		} else if(tk>= 4){
			xl ='d'; 
		} else{
			xl='f'; 
		} 
		return xl; 
	}
	void nhap_sv(sv &x){
	cout<< " nhap ma sv";cin>> x.msv ;
	cout << "nhap hoten";fflush(stdin);
	cin.getline(x.hoten ,1000);
	cout << " nhap diem cc";cin>> x.cc;
	cout << " nhap diem gk";cin>> x.gk;
	cout << " nhap diem ck";cin>> x.ck;
	x.tk =0.1*x.cc + 0.3 *x.gk + 0.6 *x.ck ;
	x.xl=tinh_xep_loai(x.tk); 
	} 
	 
	void xuat_sv(sv x){
	cout<< "\t thông tin sinh vien" ; 
	cout<< "\n\t msv" <<x.msv ;
	cout<< "\n\t hoten"  <<x.hoten; 
	cout<< "\n\ttong k?t "  << x.tk; 
	cout<<"\n|t xep loai"<<x.xl; 
	} 
	void nhapmang(sv a[], int &n){
		cout<<" nhap vao so sv";cin>>n;
		for (int i=0 ;i<n;i++){
			nhap_sv(a[i]); 
		} 
	} 
	void xuat_mang(sv a[], int n){
			cout <<"\t tông co"<<n<<" sinh vien";
			for (int i=0;i<n;i++){
				xuat_sv(a[i]); 
			} 
		} 
	void sap_xep(sv a[],int n){
		for(int i=0;i<n-1;i++){
			for (int j=i+1 ; j<n;j++){
				if(a[i].tk>a[j].tk){
					sv temp = a[i];
					a[i]=a[j];
					a[j]=temp; 
				} 
			}
		} 
	} 
	void chen_k (sv a[],int &n){
		sv k;
		nhap_sv(k);
		for(int i=n;i>0 ;i--){
			a[i ]= a[i-1]; 
		} 
		a[0]=k;
		n++; 
	} 
	void xoaK(sv a[],int &n){
		n--;
		for(int i=0;i<n;i++){
			a[i]= a[i+1]; 
		} 
		 
	} 
 
main(){
	int  n ;
	sv a[1000]; 
	nhapmang(a,n);
	xuat_mang(a,n);
	 
}