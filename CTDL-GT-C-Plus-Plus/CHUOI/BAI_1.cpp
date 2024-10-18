#include<iostream>
#include<cmath>
using namespace std ; 
char n[1000] ; 
int vitri = 0 ; 
void input(char n[]){
	cout<<"Nhap chuoi : ";
    cin.getline(n,1000);
}

int layDoDaiKyTu(char n[]) {
    int i = 0;
    while (true) {
        if (n[i] == '\0') {
            return i;
        }
        i++;
    }
}

void layKyTuDau(char* n) { 
    int x = layDoDaiKyTu(n);
    for (int i = 0; i < x; i++) {
        if (n[i] == ' ') {
            	break;
        } else {
            cout << n[i];
        }
    }
}

void layKyTuSau(char* n) { 
    char y[1000] ; 
    int x = layDoDaiKyTu(n);
    int vitri = 0 ; 
    for (int i = x-1; i >0; i--) {
        if (n[i] == ' ') {
            	break;
        } else {
            vitri = i ; 
        }
    }
   
    for(int i = vitri ; i<x ; i++){
    	cout<<n[i];
	}
}

int main(){
	input(n);
	cout<<"Do dai cua chuoi : "<<layDoDaiKyTu(n)<<endl;
	cout<<"Ky tu dau cua chuoi : "; 
	layKyTuDau(n);
	cout<<endl;
	cout<<"Ky tu sau cua chuoi : ";
	layKyTuSau(n);
	return 0 ; 
}
	
