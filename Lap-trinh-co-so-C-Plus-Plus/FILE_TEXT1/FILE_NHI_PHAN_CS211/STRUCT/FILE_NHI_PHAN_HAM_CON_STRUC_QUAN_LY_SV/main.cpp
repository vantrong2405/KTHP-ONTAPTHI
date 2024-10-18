#include <iostream>
#include<string.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
//==========//
FILE *fptr;
int n  , i ; 
//============//
struct SV{
	char masv[5];
	char tensv[30];
	double DTB;
	double lythuyet;
	double thuchanh;
	double trungbinh;
	char xeploai[30];
};
SV Lop[50];

int Input(int &n){
	int code = 0;
	do{
		printf("Nhap si so cua lop : ");
		code = scanf("%d",&n);
	}while(code==0);
	return n;		
}
//===============//
void GHIFILE(char *tenfile , int &n){
		//Ghi FILE
		fptr = fopen(tenfile,"wb");
		if(fptr == NULL){
			printf("Errol ! ");
		}
		for(int i =0; i < n; i++){
		printf("Nhap Thong tin sinh vien thu %d :\n\n",i+1);
		char masv[5];
		int ok = 1;
		printf("Ma sinh vien :"); fflush(stdin); gets(masv);
		for(int j = i -1; j >=0; j--){
			if(strcmp(masv,Lop[j].masv)==0)ok=0; // so sanh ma sinh vien voi ma sinh vien cua lop j xem co giong nhau hay khong neu giong nhau thi cho bien ok =0;
		}
		if(ok==0){
			i = i -1;continue;
		}
		SV X;strcpy(X.masv,masv);
		printf("Ten sinh vien : "); fflush(stdin); gets(X.tensv);
		int code;
		do{
			printf("Diem thuc hanh :");
			code = scanf("%lf",&X.thuchanh);
		}while(code == 0 || X.thuchanh < 0 || X.thuchanh > 10);
		
		do{
			printf("Diem ly thuyet :");
			code = scanf("%lf",&X.lythuyet);
		}while(code == 0 || X.lythuyet < 0 || X.lythuyet > 10);
		X.trungbinh = (X.lythuyet + X.thuchanh)/2;
		if(X.trungbinh >=8)strcpy(X.xeploai,"Gioi");
		else if(X.trungbinh >=7)strcpy(X.xeploai,"Kha");
		else if(X.trungbinh >=5)strcpy(X.xeploai,"Trung Binh");
		else strcpy(X.xeploai,"Yeu");
		Lop[i] = X;
		fwrite(&Lop,sizeof(SV),1,fptr);
	}
}
//=================//

void DOCFILE(char *tenfile , int &n){
	fptr = fopen(tenfile,"rb");
	while(!feof(fptr)&&fread(&Lop,sizeof(SV),1,fptr)){
		printf("\nThong tin sinh vien thu %d:\n",i+1);
		printf("\nMa sinh vien:"); puts(Lop[i].masv);
		printf("\nTen sinh vien:"); puts(Lop[i].tensv);
		printf("\nThuc hanh :\t\t%.11f",Lop[i].thuchanh);
		printf("\nLy thuyet :\t\t%.11f",Lop[i].lythuyet);
		printf("\nTrung binh :\t\t%.11f",Lop[i].trungbinh);
		printf("\nXep loai :\t"); puts(Lop[i].xeploai);
	}
}
int main(int argc, char** argv) {
    Input(n);
    GHIFILE((char*)"test1.dat",n);
    DOCFILE((char*)"test1.dat",n);
	fclose(fptr);
	return 0;
}

