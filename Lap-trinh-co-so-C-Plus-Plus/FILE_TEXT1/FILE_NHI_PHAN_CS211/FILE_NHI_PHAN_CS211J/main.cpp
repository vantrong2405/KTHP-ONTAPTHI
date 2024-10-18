#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

struct SV{
	char masv[50];
	char tensv[50];
	double diem ; 
};
SV P ;
	//====//
	FILE *fptr ;
	int n ; 
	//==================//
	void Input(int &n){
		int code = 0 ; 
		do{
			code = printf("Nhap si so :");
			code = scanf("%d",&n);
		}while(code == 0 );
	}
	//=================//
void GHIFILE(char *tenfile , int &n){
		//Ghi FILE
		fptr = fopen(tenfile,"wb");
		if(fptr == NULL){
			printf("Errol ! ");
		}
		for(int i = 0 ; i<n ; i++){
			printf("========Nhap thong tin cua sinh vien thu %d\n",i+1);
			printf("Ma Sv : "); scanf("%s",P.masv);
		printf("Ten Sv : "); fflush(stdin); gets(P.tensv);
		printf("Diem : ");scanf("%lf",&P.diem);
		fwrite(&P,sizeof(SV),1,fptr);
	}
}
//=================//

void DOCFILE(char *tenfile , int &n){
	fptr = fopen(tenfile,"rb");
	while(!feof(fptr)&&fread(&P,sizeof(SV),1,fptr)){
		printf("Ma sv : %s\n",P.masv);
		printf("Ten sv : "); fflush(stdin); puts(P.tensv);
		printf("Diem : %.2lf ",P.diem);
		printf("\n"); 
	}
	
}
int main(int argc, char** argv) {
    Input(n);
    GHIFILE((char*)"test.dat",n);
    DOCFILE((char*)"test.dat",n);
	fclose(fptr);
	return 0;
}

