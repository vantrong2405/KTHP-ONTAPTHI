#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct SinhVien{
	char masv[5];
	char tensv[30];
	double diem ;  
};
SinhVien Lop[50];
//===============//
int n , i ; 
//==============//
int  Input(int n){
	int code = 0 ;
	do{
		printf("Nhap so sinh vien cua lop : "); code = scanf("%d",&n); 
		fflush(stdin);
	}while(code == 0 || n <= 0);
	return n ;
} 
//==============//
SinhVien InputSV(){
	SinhVien X ;
		printf("Nhap ma Sinh Vien : "); fflush(stdin) ; gets(X.masv);
		printf("Nhap ten Sinh Vien : "); fflush(stdin); gets(X.tensv);
		printf("Nhap diem Sinh Vien :"); scanf("%lf",&X.diem);
		printf("\n");
		return X ;
}
//==================//
void NhapDanhSach(int n ){
	for(int i = 1 ; i<=n;i++){
		printf("=====Nhap thong tin sinh vien thu %d======\n",i);
		SinhVien X = InputSV();
		Lop[i] = X ;
	}
}
//===================//
void XuatDanhSach(int n){
	printf("\n===============Thong tin cua Sinh Vien====================\n");
	SinhVien X ;
	for(int i = 1 ; i<=n ; i++){
		printf("Thong tin sinh vien thu %d :\n",i);
		printf("Ma Sinh Vien :"); puts(Lop[i].masv); fflush(stdin);
		printf("Ten Sinh Vien :"); puts(Lop[i].tensv);fflush(stdin);
		printf("Diem Sinh Vien : %.1lf",Lop[i].diem);fflush(stdin);
		printf("\n\n");
}
}
int main(int argc, char** argv) {
    n = Input(n);
    NhapDanhSach(n);
    XuatDanhSach(n);
	return 0;
}
