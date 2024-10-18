#include<conio.h>
#include<iostream>
#include<cstring>

using namespace std ;
int main(){
    char HoVaTen[500];
    cout<<"Nhap ho va ten  : "; gets(HoVaTen);
    cout<<"Do dai cua chuoi la : "<<strlen(HoVaTen);
    return 0;
}
