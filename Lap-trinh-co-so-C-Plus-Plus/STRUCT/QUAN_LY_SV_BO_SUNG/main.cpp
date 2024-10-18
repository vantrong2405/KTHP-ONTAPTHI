#include <iostream>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct SinhVien{
	char masv[5];
	char tensv[30];
	double DTB;
	double lythuyet;
	double thuchanh;
	double trungbinh;
	char xeploai[30];
};
SinhVien Lop[50];
int n;
int Input(){
	int code = 0;
	do{
		printf("Nhap si so cua lop : ");
		code = scanf("%d",&n);
	}while(code==0);
	return n;		
}
//----------------------------------------------------------------//
void NhapDanhSach(int n){
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
		SinhVien X;strcpy(X.masv,masv);
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
	}
	
}
//----------------------------------------------------------------//
void XuatDanhSach(int n){
	printf("Xem thong tin sinh vien :\n");
	for(int i = 0; i < n; i++){
		printf("\nThong tin sinh vien thu %d:\n",i+1);
		printf("\nMa sinh vien:"); puts(Lop[i].masv);
		printf("\nTen sinh vien:"); puts(Lop[i].tensv);
		printf("\nThuc hanh :\t\t%.11f",Lop[i].thuchanh);
		printf("\nLy thuyet :\t\t%.11f",Lop[i].lythuyet);
		printf("\nTrung binh :\t\t%.11f",Lop[i].trungbinh);
		printf("\nXep loai :\t"); puts(Lop[i].xeploai);
	}
}
//-----------------------------------------------------------------//
void SapXep(int k ){
	switch(k){
		case 1 : 
		for(int i = 0 ; i<n ; i++)
		   for(int j = n - 1  ; j > i ; j--)
		      if(Lop[j].trungbinh > Lop[j-1].trungbinh){
		      	SinhVien X = Lop[j];
		      	Lop[j] = Lop[j-1];
		      	Lop[j-1] = X;
			  }
			  break ;
		case 2 : 
	for(int i = 0 ; i<n-1;i++)
	   for(int j = n - 1 ; j>i;j--)
	      if(strcmp(Lop[j].tensv,Lop[j-1].tensv)==-1){
	      SinhVien X = Lop[j];
		      	Lop[j] = Lop[j-1];
		      	Lop[j-1] = X;
		  }
		  break ; 
	}
}
//===============//
int Tim(char masv[]){
	for(int i = 0 ; i<n ; i++)
	if(strcmp(Lop[i].masv,masv)==0) return i ; 
	return -1 ; 	
}
//=================//
void Xoa(char masv[] , int &n){
	int chiso = Tim(masv);
	if(chiso == -1 ){
		printf("Khong co ma %s",masv);
		return ; 
	}
	for(int i = chiso ;i<n-1 ;i++)
	Lop[i] = Lop[i+1];
	n=n-1;
}
//========================//
void XoaTen(char tensv[] , int &n){
	int dem = 0 ;
	char masv[5];
	char strTen[5];
	for(int i = 0 ; i<n;i++)
	  if(strcmp(Lop[i].tensv,tensv)==0){
	   	dem = dem + 1 ;
	   	strcpy(masv,Lop[i].masv);
	   	if(dem>1) break ;
	   }
	   if(dem ==1)  Xoa(masv,n);
	else{
	    printf("Nhap ma sinh vien can xoa :\n");
	   	for(int i = 0 ; i<n ; i++)
	   	if(strcmp(Lop[i].tensv,tensv)==0){
	   	printf("\nThong tin sinh vien thu %d:\n",i+1);
		printf("\nMa sinh vien:"); puts(Lop[i].masv);
		printf("\nTen sinh vien:"); puts(Lop[i].tensv);
	}
	printf("Ma sinh vien :\n");
	Xoa(masv,n);
}
}
int main(int argc, char** argv) {
	n = Input();
	NhapDanhSach(n);
	XuatDanhSach(n);	
	printf("=================================================================================\n\n");
	printf("Danh sach sv sau khi da sap xep la :\n");
	int k ;
	printf("Nhap 1 (Sap Xep theo diem).\nNhap 2 (Sap Xep theo ten)");
	scanf("%d",&k);
	SapXep(k); XuatDanhSach(n);	
	char masv[5];
	printf("=================================================================================\n\n");
//	printf("nhap ma sinh vien can xoa :\t"); fflush(stdin); gets(masv);
//	Xoa(masv,n) ; XuatDanhSach(n);
    XoaTen("a",n); XuatDanhSach(n); 
	return 0;	
}
