#include <iostream>
#include<cstring>
using namespace std ;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
char c ;
int n , i , dem = 0 ; 
string s ; 
//=========//
int main(int argc, char** argv) {
    cout<<"nhap chuoi s :  "; getline(cin,s);
    cout<<"nhap ky tu c : "; cin>>c;
    for(int i = 0 ; i<s.size() ; i++){
    	if(s[i] == c || s[i] - 32 == c || s[i] + 32 == c ){
    		dem++;
		}
	}
	cout<<"dem = "<<dem++<<endl;
	return 0;
}
