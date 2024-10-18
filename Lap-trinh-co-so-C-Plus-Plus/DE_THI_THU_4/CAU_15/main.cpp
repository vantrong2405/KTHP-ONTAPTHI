#include <iostream>
#include<string.h>
#include<cstring>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
char ho_va_ten[50];
int main(int argc, char** argv) {
	printf("nhap ho va ten : "); gets(ho_va_ten);
	for(int i = 0 ; i<strlen(ho_va_ten);i++){
		ho_va_ten[i] = ho_va_ten[i] - 32 ; 
		if(ho_va_ten[i] == ' '){
		  
}
	}
	puts(ho_va_ten);
	return 0;
}
