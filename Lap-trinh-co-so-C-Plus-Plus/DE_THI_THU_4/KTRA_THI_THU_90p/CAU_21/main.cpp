#include <iostream>
#include<string.h>
#include<cstring>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
char S[50];
char C; 
int temp = 0 ; 
int main(int argc, char** argv) {
	printf("nhap xau S : "); gets(S);
	printf("nhap ky tu C : "); scanf("%c",&C);
	for(int i = 0 ; i<strlen(S) ; i++){
		if(S[i] - 32 == C || S[i] == C || S[i] + 32 == C ){
			temp++ ; 
		}
	}
	printf("So lan xuat hien cua ky tu '%c' la : %d",C,temp);
	return 0;
}


