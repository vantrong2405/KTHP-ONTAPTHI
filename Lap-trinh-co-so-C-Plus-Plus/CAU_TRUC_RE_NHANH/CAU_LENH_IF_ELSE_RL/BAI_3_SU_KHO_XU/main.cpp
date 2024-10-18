#include <iostream>
#include<cstring>
using namespace std ; 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int main(int argc, char** argv) {
	string Nguoi1 , Nguoi2;
	char k1[50] = "Im Lang";
	char k2[50] = "Khai Nhan";
	cout<<"Nhap loi khai nguoi 1 : "; getline(cin,Nguoi1);
	cout<<"Nhap loi khai nguoi 2 : "; getline(cin,Nguoi2);
	if(Nguoi1 == k1 && Nguoi2 == k1 )
		cout<<"Ca 2 ngoi tu 2 nam "<<endl;
	//=========//
	if(Nguoi1 == k2 && Nguoi2 == k2 )
		cout<<"Nguoi 1 va 2 ngoi tu 3 nam "<<endl;
	//=========//
	if(Nguoi1 == k2 && Nguoi2 == k1 ){
		cout<<"Nguoi 1 duoc tha va nguoi 2 ngoi tu 4 nam "<<endl;
	}else if(Nguoi1 == k1 && Nguoi2 == k2){
		cout<<"Nguoi 2 duoc tha va nguoi 1 ngoi tu 4 nam "<<endl;
	}else{
		cout<<"Sai loi khai "<<endl;
	}
	
	return 0;
}
