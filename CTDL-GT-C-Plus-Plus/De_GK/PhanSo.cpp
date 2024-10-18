#include<iostream>
using namespace std ; 
struct phanSo{
	int tu ; 
	int mau ; 
};

void xuatPS(phanSo c ){
	cout<<"Phan so : "<<c.tu<<"/"<<c.mau<<endl;;
}

void nhapPS(phanSo &c){
    cout<<"\tNhap tu so : "; cin>>c.tu;
	cout<<"\tNhap mau so : "; cin>>c.mau;
}

int UCLN(int a , int b){
	if(a>b) return UCLN(a-b , b);
	else if(a<b) return UCLN(a , b-a);
	else return a ; 
}

void rutGonPS(phanSo &c ){
    int n = UCLN(c.tu , c.mau);
    c.tu = c.tu / n ; 
    c.mau = c.mau / n ;
}


void tinhTongPS(phanSo a , phanSo b){
	phanSo c;
	c.tu = a.tu * b.mau + b.tu * a.mau;
	c.mau = a.mau * b.mau; 
	rutGonPS(c);
	xuatPS(c);
}

void hieuPS(phanSo a , phanSo b){
	phanSo c;
	c.tu = a.tu * b.mau - b.tu * a.mau;
	c.mau = a.mau * b.mau; 
	rutGonPS(c);
	xuatPS(c);
}

void nhanPS(phanSo a , phanSo b){
	phanSo c;
	c.tu = a.tu * b.tu ;
	c.mau = a.mau * b.mau; 
	rutGonPS(c);
	xuatPS(c);
}
void chiaPS(phanSo a , phanSo b){
	phanSo c;
	c.tu = a.tu * b.mau ;
	c.mau = a.mau * b.tu; 
	if(b.mau == 0 || a.mau == 0 ){
		cout<<"Khong chia 0";
	}else{
		rutGonPS(c);
		xuatPS(c);
	}
}

int main(){
	phanSo x , y ;
	int luaChon; 
	char c ;  
    do{
     cout<<"-------------------Menu-------------------"<<endl;
	cout<<"0. Thoat chuong trinh"<<endl;
	cout<<"1. Tinh tong 2 phan so"<<endl;
	cout<<"2. Tinh hieu 2 phan so"<<endl;
	cout<<"3. Tinh nhan 2 phan so"<<endl;
	cout<<"4. Tinh chia 2 phan so"<<endl;
	cout<<"5. Nhap 2 phan so "<<endl;
	cout<<"Nhap vao lua chon cua ban : ";
	cin>>luaChon;
	switch(luaChon){
		case 0 :{
			return 0 ; 
		}
		
		case 1 :{
			tinhTongPS(x,y);
			break;
		}
		
		case 2 :{
			hieuPS(x,y);
			break;
		}
		
		case 3:{
			nhanPS(x,y);
			break;
		}
		
		case 4:{
			chiaPS(x,y);
			break;
		}
		
		case 5:{
			cout<<"Nhap PS 1 : "<<endl;
			nhapPS(x);
			cout<<"Nhap PS 2 : "<<endl;
		    nhapPS(y);
			break;
		}
	}
	cout<<"Ban muon tiep tuc chay chuong trinh khong ? (y/n) : "; 
	cin>>c;
	}while(c == 'y');
  
	
	return 0 ; 
}
