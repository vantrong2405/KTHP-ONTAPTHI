#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
FILE *f;
struct VatTu{
   char mavt[5];
   char tenvt[15];
   int soluong;
   double dongia;
   double thanhtien;
};
VatTu P ; 
//===========//
FILE *fnguon , *fdich , *fptr ;
//============//

int GHIFILE(char* fileNguon , char* fileDich  ){
	//Doc du lieu 
	fnguon = fopen(fileNguon,"r");
	if(fnguon = NULL) return 1 ; 
	fdich = fopen (fileDich,"wb");
	if(fdich == NULL) return 1 ;
	while(!feof(fnguon)){
		fscanf(fnguon,"%s",&P.mavt);
		fscanf(fnguon,"%s",&P.tenvt);
		fscanf(fnguon,"%s",&P.soluong);
		fscanf(fnguon,"%s",&P.dongia);
		fwrite(&P,sizeof(VatTu),1,fdich);
	}
	fclose(fdich);
	fclose(fnguon);
	return 0 ; 
}
//==============//
int DOCFILE(char *tenfile){
	//Doc du lieu tu file 
	fptr = fopen(tenfile,"rb");
	if(fptr == NULL) return 1 ; //neu khong mo dc thi return 1 
	while(fread(&P,sizeof(P),1,fptr)){ 
	  printf("Ma vat tu : %s\n",P.mavt);
      printf("Ten : "); fflush(stdin); puts(P.tenvt);
      printf("So luong : %d\n",P.soluong);
      printf("Don gia : %lf\n",P.dongia);
      printf("Thanh tien : %.2lf",P.thanhtien);
	}
	fclose(fptr);// mo ra thi dong lai 
	return 0 ; 
}
int main(int argc, char** argv) {
    GHIFILE((char*)"data.txt",(char*)"result.dat");
    DOCFILE((char*)"result.dat");
	return 0;
}
