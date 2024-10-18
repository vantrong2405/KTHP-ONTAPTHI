#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int a , b , c ;
int min ;  
int main(int argc, char** argv) {
    printf("nhap a : "); scanf("%d",&a);
    printf("nhap b : "); scanf("%d",&b);
    printf("nhap c : "); scanf("%d",&c);
    if(a <= b && a <= c ){
    	min = a ; 
	}else if(b<=a && b <= c){
		min = b ; 
	}else{
		min = c ; 
	}
	//Tim min so le  
	if(min % 2 == 1 ){
		printf("Min = %d ",min);
	}else{
		printf("Khong tim duoc ");
	}
	return 0;
}
