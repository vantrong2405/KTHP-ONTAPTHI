#include <iostream>
using namespace std ; 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int a , b , c , d ; 
	int max ; 
	cout<<"Nhap a , b , c , d : "; cin>>a>>b>>c>>d;
	if(a>=b && a>=c && a>=d) max = a ; 
	if(b>=a && b>=c && b>=d) max = b ; 
	if(c>=a && c>=b && c>=d) max = c ; 
	if(d>=a && d>=b && d>=c) max = d ; 
	cout<<"max = "<<max<<endl;
	if(max == a )  c = d ; 
	if(a == c){
		cout<<"Dung "<<endl;
	}  
	return 0;
}
