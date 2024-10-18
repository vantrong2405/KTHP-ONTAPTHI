#include<iostream>
using namespace std ; 
int main(){ 
    int dem = 1 , n = 0; 
    char c = 179; 
	cout<<"Bang cuu chuong  "<<": "<<endl;
	for(int i = 2 ; i<=9 ; i++ ){
		for(int j = 1 ;j<=10 ; j++){
			cout<<i<<" * "<<j<<" = "<<i*j<<endl; 
			dem++;
			n++;
		}
		
		if(dem == i-1){
			cout<<"\t\t";
		} 

	}
	
	return 0 ; 
}
