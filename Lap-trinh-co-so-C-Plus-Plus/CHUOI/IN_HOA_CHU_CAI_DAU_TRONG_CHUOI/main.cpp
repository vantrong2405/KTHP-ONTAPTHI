#include<iostream>
#include<string>
using namespace std ; 
int main(){
	string s ; 
	cout<<"Nhap chuoi : ";
	getline(cin,s);
	for(int i = 0 ; i<s.length();i++){
		if(s[i] >= 'A' && s[i] <= 'Z'){
			s[i] = s[i] + 32;
		}
	}
	s[0] = s[0] - 32 ; 
	for(int i = 0 ; i<s.length() ; i++){
		if(s[i] == ' '){
			s[i+1] = s[i+1] - 32 ;
		}
	}
	cout<<"chuoi cua ban la : "<<s;
	return 0 ;
}
	
