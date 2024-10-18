#include <iostream>
using namespace std ; 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
double chieuCao , vongNguc , canNang ;
int main(int argc, char** argv) {
	cout<<"Nhap Chieu cao (cm) : ";cin>>chieuCao;
	cout<<"Nhap Vong Nguc (cm) : "; cin>>vongNguc;
	cout<<"Nhap Can Nang  (kg) : "; cin>>canNang;
	double csPignet = chieuCao - (vongNguc + canNang);
	if(csPignet < 15){
		cout<<"Rat tot "<<endl;
	}else if(csPignet >=16 && csPignet <=20){
		cout<<"Tot "<<endl;
	}else if(csPignet >=21 && csPignet <=35){
		cout<<"Trung binh "<<endl;
	}else if(csPignet >=26 && csPignet <=30 ){
		cout<<"Yeu"<<endl;
	}else{
		cout<<" Rat Yeu"<<endl;
	}
	return 0;
}
