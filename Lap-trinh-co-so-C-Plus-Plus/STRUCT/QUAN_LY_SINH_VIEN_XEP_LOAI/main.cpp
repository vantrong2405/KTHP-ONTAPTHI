#include <iostream>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct SinhVien{
	char MaSv[5];// chuoi ma sinh vien 
	char TenSv[30];// chuoi ten sinh vien 
	double ThucHanh;
	double LyThuyet;
	double TrungBinh;
	char XepLoai[30];
}; 
SinhVien Lop[50];
int n , i , j ;
//===================//
int Input(int n ){
	int code = 0 ;
	do{
		printf("Nhap so luong sinh vien : ");
		code = scanf("%d",&n); fflush(stdin);
	}while(code == 0 || n<=0);
	return n ;
}
//====================//
void  NhapDanhSach(int n ){
  for(int i = 0 ; i<n ; i++){
  	printf("============Nhap Thong tin sinh vien thu %d========\n",i+1);
    char MaSv[5];  
    int ok = 1 ;
    printf("Nhap Ma So Sinh Vien :"); fflush(stdin) ; gets(MaSv); 
    for( i = j - 1 ; j>=0 ; j--){
    	if(strcmp(MaSv,Lop[j].MaSv)==0) ok = 0 ;// so sanh 2 chuoi neu ma sinh vien nhap vao bang voi Ma sinh vien cua tat ca lan nhap thi bien ok = 0 
	}
	if(ok == 0){
	i = i-1;
	continue ;// gap lenh nay no se quay lai vong lap for 	
	} 
  SinhVien X ; strcpy(X.MaSv,MaSv); //coppy  X.masv = masv ;
  printf("Nhap Ten Sinh Vien : "); fflush(stdin); gets(X.TenSv);
  int code = 0 ;
  do{
  	printf("Nhap Diem thuc hanh : "); code = scanf("%lf",&X.ThucHanh); fflush(stdin);
  }while(code == 0 || X.ThucHanh <= 0 || X.ThucHanh > 10);	
  
  do{
   printf("Nhap Diem Ly thuyet : "); code = scanf("%lf",&X.LyThuyet) ; fflush(stdin);
  }while(code == 0 || X.LyThuyet <= 0 || X.LyThuyet > 10); 
   X.TrungBinh = (X.ThucHanh + X.LyThuyet) / 2;
   	if(X.TrungBinh >=8) strcpy(X.XepLoai,"Gioi");
   	else if (X.TrungBinh >=7) strcpy(X.XepLoai,"Kha");
   	else if (X.TrungBinh >=5) strcpy(X.XepLoai,"Trung Binh");
   	else strcpy(X.XepLoai,"Yeu");
   	Lop[i] = X ; 
}
}
//===================//
void XuatDanhSach(int n){
   printf("============Thong tin cua sinh vien===========\n");
   for(int i = 1 ; i<=n ; i++){
   	printf("Thong tin cua Sinh Vien thu %d la :\n ",i);
   printf("Ma So :"); puts(Lop[i].MaSv);
   printf("Ten :") ; puts(Lop[i].TenSv);
   printf("Diem thuc hanh :") ; printf("%lf",Lop[i].ThucHanh);
   printf("Diem ly thuyet :") ; printf("%lf",Lop[i].LyThuyet);
   printf("Diem Trung binh :") ; printf("%lf",Lop[i].TrungBinh);
   printf("Xep loai :") ; puts(Lop[i].XepLoai);
   printf("\n"); 
   }
}

int main(int argc, char** argv) {
	n = Input(n);
	NhapDanhSach(n);
	XuatDanhSach(n);
	return 0;
}
