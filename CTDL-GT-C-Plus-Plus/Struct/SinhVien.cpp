#include<iostream>
using namespace std ; 

struct sv{
   int MSV;
   char hoLot[100];
   char ten[100];
   float cc , gk , ck , tongKet ;
};

char xepLoai(double tk){
	char xl ; 
	if(tk >= 8.5 ) xl = 'A';
	else if(tk >= 7.0) xl = 'B';
	else if(tk >= 6.0) xl = 'C';
	else if(tk >= 4.5) xl = 'D';
	else{
		xl = 'F';
	}
	return xl ; 
}
bool checkMSV(sv &x[] , int n){
	for(int i = 0 ; i<n ; i++){
		for(int j = i + 1 ; j<n ; j++){
			if(x[i] == x[j]){
				return false ; 
			}
		}
	}
	return true ; 
}

void nhapThongTinSinhVien(sv &x){
  cout<<"Nhap MSV : "; cin>>x.MSV;fflush(stdin);
  cout<<"Nhap ho lot : "; cin.getline(x.hoLot,100);fflush(stdin);
  cout<<"Nhap ten : ";  cin.get(x.ten , 100);fflush(stdin);
  cout<<"Nhap diem CC  : "; cin>>x.cc;
  cout<<"Nhap diem GK  : "; cin>>x.gk;
  cout<<"Nhap diem CK  : "; cin>>x.ck;
  x.tongKet = (x.cc * 0.1 + x.gk * 0.2 + x.ck * 0.3);
}

void xuatThongTinSinhVien(sv x){
	cout<<"\tMSV : "; cout<<x.MSV<<endl;
	cout<<"\tHo va ten : "; fflush(stdin); cout<<x.hoLot<<" "<<x.ten<<endl;
	cout<<"\tChuyen can : "<<x.cc<<endl;
	cout<<"\tGiua ky : "<<x.gk<<endl;
	cout<<"\tCuoi ky : "<<x.ck<<endl;
	cout<<"\tTong ket : "<<x.tongKet<<endl;
	char ketQua = xepLoai(x.tongKet);
	cout<<"\tXep loai : "<<ketQua<<endl;
}

int main(){
	int n ; cout<<"Nhap so luong sinh vien : "; cin>>n;
	sv A[1000];
	for(int i = 0 ; i<n ; i++){
		cout<<"Nhap thong tin sinh vien thu "<<(i+1)<<endl;
		nhapThongTinSinhVien(A[i]);
	}

	for(int i = 0 ; i<n ; i++){
	 cout<<"-------------Thong tin sinh vien thu"<<(i+1)<<"-------------------"<<endl;
	 xuatThongTinSinhVien(A[i]);
	}
	return 0 ; 
}
