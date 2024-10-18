#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
FILE *f1,*f2;
int main(int argc, char** argv) {
	char c,x;
	f1=fopen("mauthu1.txt","r");f2=fopen("mauthu2.txt","w");
	if(f1==NULL) printf("Error !!!"); return 1;
	fscanf(f1,"%c",&x);x=toupper(x);
	fprintf(f2,"%c",x);
	while(!feof(f1)){
		fscanf(f1,"%c",&c);fprintf(f2,"%c",c);
		if(c==' '){
			fscanf(f1,"%c",&x);x=toupper(x);
			fprintf(f2,"%c",x);
		}
	}
	fclose(f1);fclose(f2);
	f1=fopen("mauthu2.txt","r");
	char s[20],dem=0;
	while(!feof(f1)){
		fscanf(f1,"%s",&s);
		dem++;
	}
	printf("dem=%d",dem);
	fclose(f1);
	return 0;
}
