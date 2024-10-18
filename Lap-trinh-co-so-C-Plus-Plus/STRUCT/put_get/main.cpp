#include <iostream>
#include<string.h>// nhung thu vien nay nam trong string.h
#include<conio.h>
#include<stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	char Ten[50];
	char QueQuan[15];
	printf("Nhap Ten : ");
	fflush(stdin); gets(Ten);//nhap chuoi

	printf("Nhap Que Quan : ");
	fflush(stdin); gets(QueQuan);//nhap chuoi
	
	printf("Thong tin :\n");
	puts(Ten);//xuat chuoi (ten) ra man hinh;
	puts(QueQuan);//xuat chuoi (Que Quan) ra man hinh 
	int dodai = strlen(Ten);//ham strlen lay do dai cua chuoi
	printf("dodai = %d\n",dodai);
	
	strcpy(QueQuan , "Ha Noi "); //coppy chuoi Que Quan , thay the Que Quan minh nhap thanh Ha Noi 
	puts(Ten);
	puts(QueQuan);
	char soluong[] = "20";
	double thanhtien = 500.0 * atof(soluong);//chuyen chuoi dang so thuc sang so thuc 
	printf("thanhtien = %.3lf\n",thanhtien);  
	return 0;
}
