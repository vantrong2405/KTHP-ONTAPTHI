#include <iostream>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
FILE *f;
int n  ;
int main(){
   //doc file nao 
   f = fopen("ViDu1.txt","r");
   if(f == NULL){
   	printf("Errol ! ");
   }
   //Doc file 
   fscanf(f,"%d",&n);// lan luot : con tro f , dinh dang bien , dia chi bien 
   printf("Gia Tri : %d",n);//in 
   //Dong file
   fclose(f);
	return 0;
}
