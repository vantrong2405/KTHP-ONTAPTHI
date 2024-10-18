#include "stdio.h"
#include "string.h"
void chuyenDoi(char x[]){

	for(int i=0; i<strlen(x); i++){

			if(x[0]>=97 && x[0]<=122)
				x[0]=x[0]-32;			
	}
}
int main(){
	char s[100] ;
	printf("Nhap s = ");
	gets(s);
	chuyenDoi(s);
	printf("\ns = %s", s);
}

