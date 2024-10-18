//nguyen Van AN -> Nguyen Van An
#include<iostream>
#include<string.h>
using namespace std ;
 
int main(){
	char s[50];
	cout<<"nhap chuoi : "; 
	cin.getline(s,50);
    int length = strlen(s);
	for(int i = 0 ; i< length ; i++){
		s[i] = s[i] - 32 ; 
	}
		cout<<"chuoi cua ban la : "<<s<<endl;
	return 0 ; 
}


