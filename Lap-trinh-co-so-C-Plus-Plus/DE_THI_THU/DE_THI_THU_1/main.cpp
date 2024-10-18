#include <iostream>
#include<stdio.h>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
char s[100] ;
printf("nhap xau : "); gets(s);
strl(s);// in hoa  
int dodai = strlen(s);
for(int i = 0 ; i<dodai ; i++){
	if(s[i] == ' ' ){
		if((s[i] + 1 >='A' && s[i] + 1<='Z' || s[i] + 1 >='a' && s[i] + 1<='z' )) 
			   strlwr(s);	
}
}
puts(s);
	return 0;
}
