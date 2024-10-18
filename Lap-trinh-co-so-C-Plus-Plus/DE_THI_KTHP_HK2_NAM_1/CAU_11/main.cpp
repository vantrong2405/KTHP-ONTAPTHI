#include <iostream>
#include<string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
char n[50]; 
int i , dem = 0 ; 
int main(int argc, char** argv) {
    printf("nhap chuoi : "); gets(n);
    int dodai = strlen(n);
    printf("Nhung ky tu duoc in hoa la :\n");
    for(int i = 0 ; i < dodai ; i++){
    	if(n[i] >= 'A' && n[i] <='Z'){
    		printf("%c\t",n[i]);
    		dem++;
		}
	}
	printf("\nTrong xau co '%d' ky tu in hoa ",dem++);
	return 0;
}
