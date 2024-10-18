#include <iostream>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
FILE *f;
int n ; 
int main(int argc, char** argv) {
	//mo file nao o che do nao doc hay ghi 
	f = fopen("ViDu1.txt","r");
	if(f==NULL){
	 printf("Errol ! ");
	}
	fscanf(f,"%d",&n);//doc du lieu  tu file 
	printf("Gia tri cua file : %d ",n);//in ra du lieu tu file
	//dong file
	fclose(f);//mo file nao thi dong file do 
	return 0;
}
