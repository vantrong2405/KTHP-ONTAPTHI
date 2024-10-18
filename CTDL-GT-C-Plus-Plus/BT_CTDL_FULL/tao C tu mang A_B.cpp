// thuat toan tim kiem nhi phan
// cho 1 mang A gom n phan tu va 1 mang B gom m phan tu tat ca hai mang deu da duoc sap xep tang dan. Hay tao ra 1 mang C tu 2 mang A, B sao cho C van dc sap xep tang dan(khong duoc sap xep lai mang C)
//VD: Mang A gom 5 phan tu == 1 5 9 14 23 27
// mang B 2 7 8
//DS c 1 2 5 7 8 9 13 23 27
#include<iostream>
using namespace std;
void nhap_mang(int A[], int &n){
int dequi(int A[], int t, int p, int k){
	if(t > p){
		return false;
	}
	int g = (t + p) / 2;
	if(A[g] == k){
		return true;
	} else if(A[g] < k){
		dequi(A, g + 1,p , k);
	}else{
		dequi(A, t, g - 1, k);
	}
	
}

main(){
	int A[1000], n, k;
//	nhap_mang(A, n);

	
	cout<<"nhap k: ";cin>>k;
	int x = dequi(A,0,n - 1, k);
	if(x){
		cout<<" Da tim thay k ";
	}else {
		cout<<"khong tim thay k ";
	}
}


