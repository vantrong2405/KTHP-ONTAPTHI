#include<iostream>
#include<string>
#include<conio.h>
#include<fstream>
#include<Windows.h>
using namespace std ; 
void Xuat(){	
	ifstream filein ; 
	string n ;
    filein.open("banner.txt",ios::in);
    while(filein.eof() == false){
    	getline(filein,n);
    	cout<<n<<endl;
    	Sleep(50); 
	}
}	
int main(){
Xuat();	
getch();
} 










































































