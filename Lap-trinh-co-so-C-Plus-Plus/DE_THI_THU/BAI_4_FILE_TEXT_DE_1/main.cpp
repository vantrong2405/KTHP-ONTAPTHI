#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
FILE *f1 , *f2;
int main(int argc, char** argv) {
	char c , x ; 
	f1 = fopen("mauthu1.txt","r");
	if(f1 == NULL){
		return 1 ;
	} 
	fscanf(f1,"%c",&x);//doc file cua f1 .
	x = toupper(x); 
	fprintf(f2,"%c",&x);
	while(!feof(f1)){
		fscanf(f1,"%c",&c); 
		fscanf(f2,"%c",&c);
		if(c == ' '){
			fscanf(f1,"%c",&c); x = toupper(x);
			fprintf(f2,"%c",&c); 
		}
	}
	return 0;
}
