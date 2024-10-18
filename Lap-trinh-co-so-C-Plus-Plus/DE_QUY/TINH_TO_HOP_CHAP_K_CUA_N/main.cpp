#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n , k , C ;
//==============================//

int ToHop(int n , int k){
	if(k==n || k == 0 ) return 1 ;// vi vd  4C4 = 1 va 4C0 = 1 
	return ToHop(n-1,k) + ToHop(n-1 , k-1);
		
}

//==============================//
int main(int argc, char** argv) {
	int code = 0 ;
    do{
	printf("nhap n : "); code=scanf("%d",&n);
	fflush(stdin);
	}while(n<0 || code == 0 );
		
	do{
	printf("nhap k : "); code=scanf("%d",&k);
	fflush(stdin);
	}while(k<0 || k > n || code == 0 );
	C = ToHop(n , k );
	printf("C(%d,%d) = %d",n,k,C);
	
	
	return 0;
}
