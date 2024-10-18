#include <iostream>
#include<cstring>
using namespace std ; 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i , n ; 
char c ; 
int dem = 0 ;
int main(int argc, char** argv) {
	string s ;
	cout<<"nhap chuoi : "; getline(cin,s);
	cout<<"nhap ky tu : "; cin>>c;
	for(int i = 0 ; i<s.size() ; i++){
		if(s[i]+ 32 == c || s[i] - 32 == c || s[i] == c){
			dem++ ; 
		}
	}
    cout<<"So lan xh cua ky tu  "<<c<<" la : "<<dem++<<endl;
	return 0;
}
