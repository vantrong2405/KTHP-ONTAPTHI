#include<iostream>
using namespace std ;

double deQuyAB(int a , int b){ 
    double value;   
    if(b == 0 ) return 1 ;
    else if(b == 1) return a ;
    else if(b < 0){
    	b = -b;
		b--; 
    	value = (a * deQuyAB(a,b));
        return 1/value;
  }else {
  		b =  b - 1 ;
  	return a * deQuyAB(a,b);
  }
} 
int main(){
	cout<<"Gia tri cua "<<2<<"^"<<4<<" la :  "<<deQuyAB(2,4)<<endl;
	return 0 ; 
}

